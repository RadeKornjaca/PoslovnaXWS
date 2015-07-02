package rest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.Properties;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.namespace.QName;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.ws.Service;

import poslovnaxws.banke.Presek;
import poslovnaxws.banke.Uplata;
import poslovnaxws.banke.ZahtevZaIzvod;
import poslovnaxws.common.TBanka;
import poslovnaxws.common.TFirma;
import poslovnaxws.common.TStavkaPreseka;
import poslovnaxws.services.banka.BankaServiceMessages;
import poslovnaxws.services.banka.NotificationMessage;
import sessionbeans.concrete.DobavljacDaoLocal;
import sessionbeans.concrete.FakturaDaoLocal;
import sessionbeans.concrete.FaktureDaoLocal;
import sessionbeans.concrete.KupacDaoLocal;
import sessionbeans.concrete.StavkaFaktureDaoLocal;
import sessionbeans.concrete.StavkeDaoLocal;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import entity.dobavljac.Dobavljac;
import entity.fakture.Faktura;
import entity.fakture.Fakture;
import entity.fakture.StavkaFakture;
import entity.fakture.StavkeFakture;
import entity.kupac.Kupac;

@Path("/partneri")
public class FirmaService {

	private static final Logger LOG = Logger.getLogger(FirmaService.class
			.getName());

	@EJB
	private FaktureDaoLocal faktureDao;

	@EJB
	private FakturaDaoLocal fakturaDao;

	@EJB
	private DobavljacDaoLocal dobavljacDao;
	
	@EJB
	private KupacDaoLocal kupacDao;

	@EJB
	private StavkaFaktureDaoLocal stavkaDao;

	@EJB
	private StavkeDaoLocal stavkeDao;

	public FirmaService() {

	}

	@POST
	@Path("/{id}/fakture")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addFaktura(@PathParam("id") Long id, String jsonFaktura)
			throws URISyntaxException {
		System.out.println("Invoking addFaktura!");

		Response response;

		ObjectMapper mapper = new ObjectMapper();
		Faktura faktura;

		try {
			faktura = mapper.readValue(jsonFaktura, Faktura.class);
			URI uri = new URI("/partneri/" + id + "/fakture/"
					+ fakturaDao.getIdentity());

			if (checkDobavljac(id)) {
				try {
					fakturaDao.persist(faktura);
					response = Response.status(Status.CREATED)
							.contentLocation(uri).build();

				} catch (JAXBException | IOException e) {
					response = Response.status(Status.BAD_REQUEST).build();
					e.printStackTrace();
				}
			} else {
				response = Response.status(Status.FORBIDDEN).build();
			}
		} catch (IOException e1) {
			response = Response.status(Status.BAD_REQUEST).build();
			e1.printStackTrace();
		}

		return response;
	}

	@GET
	@Path("/{id}/fakture")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFakture(@PathParam("id") String id) {
		System.out.println("Invoking getFakture with id poslovnog partnera !");

		System.out.println("Id poslovnog partnera: " + id);

		Fakture fakture = null;

		try {
			fakture = faktureDao.findAllById(id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Response response = getResponsePack(fakture);

		return response;
	}

	@GET
	@Path("/{id_dobavljaca}/fakture/{id_fakture}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFakturaFromDobavljac(
			@PathParam("id_dobavljaca") String idDobavljaca,
			@PathParam("id_fakture") Long idFakture) {
		System.out.println("Invoking getFakturaFromDobavljac");

		Faktura faktura = fakturaDao.findFakturaById(idDobavljaca, idFakture);

		Response response;
		response = getResponsePack(faktura);

		return response;
	}

	@GET
	@Path("/{id_dobavljaca}/fakture/{id_fakture}/stavke")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStavke(@PathParam("id_dobavljaca") String idDobavljaca,
			@PathParam("id_fakture") Long idFakture) {

		StavkeFakture stavkeFakture = null;

		stavkeFakture = stavkeDao.findStavkeFakture(idDobavljaca, idFakture);

		Response response;
		response = getResponsePack(stavkeFakture);

		return response;

	}

	@POST
	@Path("/{id_dobavljaca}/fakture/{id_fakture}/stavke")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addStavka(@PathParam("id_dobavljaca") Long idDobavljaca,

	@PathParam("id_fakture") Long idFakture, String jsonStavka)
			throws URISyntaxException {

		System.out.println("Invoking addStavka!");
		System.out.println("idFakture: " + idFakture);
		System.out.println("idDobavljaca: " + idDobavljaca);

		Response response;

		Faktura faktura;
		ObjectMapper mapper = new ObjectMapper();
		StavkaFakture stavka;

		try {
			faktura = fakturaDao.findById(idFakture);

			stavka = mapper.readValue(jsonStavka, StavkaFakture.class);
			URI uri = new URI("/partneri/" + idDobavljaca + "/fakture"
					+ idFakture + "/stavke/" + stavka.getId());
			
			if (checkDobavljac(idDobavljaca)) {

				try {
					if(faktura.getStavkeFakture() == null) {
						faktura.setStavkeFakture(new StavkeFakture()); 			//za slucaj da u fakturi postoji samo zaglavlje
					}
					faktura.getStavkeFakture().getStavkaFakture().add(stavka);

					updateZaglavljeAdd(faktura, stavka);

					fakturaDao.merge(faktura, idFakture);

					response = Response.status(Status.CREATED)
							.contentLocation(uri).build();

				} catch (JAXBException | IOException e) {
					response = Response.status(Status.BAD_REQUEST).build();
					e.printStackTrace();
				}
			} else {
				response = Response.status(Status.FORBIDDEN).build();
			}

		} catch (JAXBException | IOException e1) {
			response = Response.status(Status.NOT_FOUND).build();
			e1.printStackTrace();
		}

		return response;

	}

	@GET
	@Path("/{id_dobavljaca}/fakture/{id_fakture}/stavke/{red_br}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStavka(@PathParam("id_dobavljaca") String idDobavljaca,

	@PathParam("id_fakture") Long idFakture,
			@PathParam("red_br") BigInteger redBr) {

		StavkaFakture stavka = stavkaDao.findByIdInFaktura(idDobavljaca,
				idFakture, redBr);
		Response response;

		response = getResponsePack(stavka);

		return response;

	}

	@PUT
	@Path("/{id_dobavljaca}/fakture/{id_fakture}/stavke/{red_br}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateStavka(@PathParam("id_dobavljaca") Long idDobavljaca,
			@PathParam("id_fakture") Long idFakture,
			@PathParam("red_br") BigInteger redBr, String jsonStavka)
			throws URISyntaxException {

		System.out.println("Invoking updateStavka!");
		System.out.println("idFakture: " + idFakture);
		System.out.println("idDobavljaca: " + idDobavljaca);

		Response response;

		Faktura faktura;
		ObjectMapper mapper = new ObjectMapper();
		StavkaFakture stavka;

		try {
			faktura = fakturaDao.findById(idFakture);
			stavka = mapper.readValue(jsonStavka, StavkaFakture.class);

			if (checkDobavljac(idDobavljaca)) {
				try {
					StavkaFakture oldStavka = stavkaDao.findByIdInFaktura(
							idDobavljaca.toString(), idFakture, redBr);
					updateZaglavljeSubtract(faktura, oldStavka);

					for (StavkaFakture s : faktura.getStavkeFakture()
							.getStavkaFakture()) {
						if (s.getRedniBroj().equals(oldStavka.getRedniBroj())) {
							s.setIznosRabata(stavka.getIznosRabata());
							s.setJedinicaMere(stavka.getJedinicaMere());
							s.setJedinicnaCena(stavka.getJedinicnaCena());
							s.setKolicina(stavka.getKolicina()); // ispao sam
																	// dobar
																	// covek,
																	// ali u
							s.setNaziv(stavka.getNaziv()); // ovom trenutku
															// mrzim svoj zivot
							s.setTip(stavka.getTip());
							s.setProcenatRabata(stavka.getProcenatRabata());
							s.setUkupanPorez(stavka.getUkupanPorez());
							s.setUmanjenoZaRabat(stavka.getUmanjenoZaRabat());
							s.setVrednost(stavka.getVrednost());
						}
					}

					updateZaglavljeAdd(faktura, stavka);

					fakturaDao.merge(faktura, idFakture);

					response = Response.ok().build();

				} catch (JAXBException | IOException e) {
					response = Response.status(Status.BAD_REQUEST).build();
					e.printStackTrace();
				}
			} else {
				response = Response.status(Status.FORBIDDEN).build();
			}

		} catch (JAXBException | IOException e1) {
			response = Response.status(Status.NOT_FOUND).build();
			e1.printStackTrace();
		}

		return response;

	}

	@DELETE
	@Path("/{id_dobavljaca}/fakture/{id_fakture}/stavke/{red_br}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteStavka(@PathParam("id_dobavljaca") Long idDobavljaca,
			@PathParam("id_fakture") Long idFakture,
			@PathParam("red_br") BigInteger redBr) {

		System.out.println("Invoking deleteStavka!");
		System.out.println("idFakture: " + idFakture);
		System.out.println("idDobavljaca: " + idDobavljaca);
		System.out.println("redBr: " + redBr);

		Response response = Response.status(Status.NOT_FOUND).build();

		Faktura faktura;

		try {
			faktura = fakturaDao.findById(idFakture);

			if (checkDobavljac(idDobavljaca)) {
				try {
					StavkaFakture oldStavka = stavkaDao.findByIdInFaktura(
							idDobavljaca.toString(), idFakture, redBr);

					Iterator<StavkaFakture> iterStavka = faktura
							.getStavkeFakture().getStavkaFakture().iterator();
					while (iterStavka.hasNext()) {
						if (iterStavka.next().getRedniBroj()
								.equals(oldStavka.getRedniBroj())) {

							updateZaglavljeSubtract(faktura, oldStavka);
							iterStavka.remove();
						}
					}

					fakturaDao.merge(faktura, idFakture);

					response = Response.status(Status.NO_CONTENT).build();

				} catch (JAXBException | IOException e) {
					response = Response.status(Status.BAD_REQUEST).build();
					e.printStackTrace();
				}
			} else {
				response = Response.status(Status.FORBIDDEN).build();
			}

		} catch (JAXBException | IOException e1) {
			response = Response.status(Status.NOT_FOUND).build();
			e1.printStackTrace();
		}

		return response;

	}

	@POST
	@Path("/uplata")
	@Produces("application/json")
	@Consumes("application/json")
	public Response uplata(String jsonRequest) {

		ObjectMapper mapper = new ObjectMapper();

		Uplata uplata = null;
		try {
			uplata = mapper.readValue(jsonRequest, Uplata.class);

			ObjectNode node = (ObjectNode) mapper.readTree(jsonRequest);

			if (node.get("nalog").get("duznik").get("swiftKod") != null) {
				TBanka duznik = mapper.readValue(node.get("nalog")
						.get("duznik").toString(), TBanka.class);
				uplata.getNalog().setDuznik(duznik);
			} else {
				TFirma duznik = mapper.readValue(node.get("nalog")
						.get("duznik").toString(), TFirma.class);
				uplata.getNalog().setDuznik(duznik);
			}

			if (node.get("nalog").get("primalac").get("swiftKod") != null) {
				TBanka primalac = mapper.readValue(
						node.get("nalog").get("primalac").toString(),
						TBanka.class);
				uplata.getNalog().setPrimalac(primalac);
			} else {
				TFirma primalac = mapper.readValue(
						node.get("nalog").get("primalac").toString(),
						TFirma.class);
				uplata.getNalog().setPrimalac(primalac);
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).build();

		} catch (JsonMappingException e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).build();
		} catch (IOException e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}

		RunnableService service = new RunnableService(uplata, uplata.getNalog()
				.getDuznik().getRacun().substring(0, 3));
		service.run();

		return Response.ok().build();

	}

	@PUT
	@Path("/presek")
	@Produces("application/json")
	@Consumes("application/json")
	public Response getPresek(String jsonRequest) {
		Presek presek = null;
		ObjectMapper mapper = new ObjectMapper();

		ZahtevZaIzvod zahtev;
		try {

			zahtev = mapper.readValue(jsonRequest, ZahtevZaIzvod.class);

		} catch (JsonParseException e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).build();

		} catch (JsonMappingException e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).build();
		} catch (IOException e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}

		ObjectNode json = null;
		try {
			BankaServiceMessages banka = createBankaService(zahtev
					.getBrojRacuna().substring(0, 3));
			for (int i = 1;;i++){
				zahtev.setRedniBrojPreseka(new BigInteger(String.valueOf(i)));
				if (presek == null)
					presek = banka.zahtevZaIzvod(zahtev);
				else{
					Presek novi  = banka.zahtevZaIzvod(zahtev);
					for (TStavkaPreseka stavka : novi.getStavkePreseka().getStavka()){
						presek.addStavka(stavka);
					}
				}
			}

		} catch (NotificationMessage e) {
			System.out.println(e.getMessage());
			if (presek == null)
				return Response.status(Status.INTERNAL_SERVER_ERROR).build();
			else if (e.getStatus().getKod() == 0){
				json = mapper.valueToTree(presek);
				return Response.ok(json.toString()).build();
			}
		}

		json = mapper.valueToTree(presek);
		return Response.ok(json.toString()).build();
	}

	/**
	 * Metoda sluzi za generisanje HTTP odgovora prilikom GET zahteva, koji se
	 * salje klijentu. Ukoliko postoje informacije, odgovor je tipa 200, dok
	 * ukoliko je data == null, onda se salje odgovor tipa 404.
	 * 
	 * @param data
	 *            - informacioni deo odgovora
	 * @return objekat klase Response koji predstavlja enkapsulaciju HTTP
	 *         odgovora
	 */
	private Response getResponsePack(Object data) {
		Response response;

		ObjectMapper mapper = new ObjectMapper();
		ObjectNode json = mapper.valueToTree(data);

		if (data != null) {
			response = Response.ok(json.toString()).build();
		} else {
			response = Response.status(Status.NOT_FOUND).build();
		}
		return response;
	}

	/**
	 * Proverava da li postoji dobavljac u listi poslovnih partnera
	 * 
	 * @param id
	 *            - vrednost PIB-a dobavljaca
	 * @return boolean vrednost u zavisnosti od toga da li postoji partner ili
	 *         ne
	 */
	private boolean checkDobavljac(Long id) {
		try {
			dobavljacDao.findById(id);
		} catch (NumberFormatException | JAXBException | IOException e1) {
			return false;
		}
		return true;
	}

	/**
	 * Sluzi da prilikom dodavanja nove stavke u fakturu azurira vrednosti u
	 * zaglavlju koje zavise od vrednosti u stavkama
	 * 
	 */
	private void updateZaglavljeAdd(Faktura faktura, StavkaFakture stavka) {
		if (stavka.getTip().equals("roba")) {
			faktura.getZaglavlje().setVrednostRobe(
					faktura.getZaglavlje().getVrednostRobe()
							.add(stavka.getVrednost()));
		} else if (stavka.getTip().equals("usluga")) {
			faktura.getZaglavlje().setVrednostUsluge(
					faktura.getZaglavlje().getVrednostUsluge()
							.add(stavka.getVrednost()));
		}
		faktura.getZaglavlje().setUkupnoRobaIUsluge(
				faktura.getZaglavlje().getVrednostRobe()
						.add(faktura.getZaglavlje().getVrednostUsluge()));
		faktura.getZaglavlje().setUkupanRabat(
				faktura.getZaglavlje().getUkupanRabat()
						.add(stavka.getIznosRabata()));
		faktura.getZaglavlje().setUkupanPorez(
				faktura.getZaglavlje().getUkupanPorez()
						.add(stavka.getUkupanPorez()));
		faktura.getZaglavlje().setIznosZaUplatu(
				faktura.getZaglavlje().getUkupnoRobaIUsluge()
						.subtract(faktura.getZaglavlje().getUkupanRabat())
						.add(faktura.getZaglavlje().getUkupanPorez()));
	}

	/**
	 * Sluzi da prilikom brisanja stavke u fakturu azurira vrednosti u zaglavlju
	 * koje zavise od vrednosti u stavkama
	 * 
	 */
	private void updateZaglavljeSubtract(Faktura faktura, StavkaFakture stavka) {
		if (stavka.getTip().equals("roba")) {
			faktura.getZaglavlje().setVrednostRobe(
					faktura.getZaglavlje().getVrednostRobe()
							.subtract(stavka.getVrednost()));
		} else if (stavka.getTip().equals("usluga")) {
			faktura.getZaglavlje().setVrednostUsluge(
					faktura.getZaglavlje().getVrednostUsluge()
							.subtract(stavka.getVrednost()));
		}
		faktura.getZaglavlje().setUkupnoRobaIUsluge(
				faktura.getZaglavlje().getVrednostRobe()
						.subtract(faktura.getZaglavlje().getVrednostUsluge()));
		faktura.getZaglavlje().setUkupanRabat(
				faktura.getZaglavlje().getUkupanRabat()
						.subtract(stavka.getIznosRabata()));
		faktura.getZaglavlje().setUkupanPorez(
				faktura.getZaglavlje().getUkupanPorez()
						.subtract(stavka.getUkupanPorez()));
		faktura.getZaglavlje().setIznosZaUplatu(
				faktura.getZaglavlje().getUkupnoRobaIUsluge()
						.add(faktura.getZaglavlje().getUkupanRabat())
						.subtract(faktura.getZaglavlje().getUkupanPorez()));
	}

	private BankaServiceMessages createBankaService(String swiftKod) {

		Properties prop = new Properties();

		InputStream propInput = null;
		BufferedReader rd = null;

		try {
			propInput = new FileInputStream(
					"../webapps/client-rest-ws/WEB-INF/config.properties");
			prop.load(propInput);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		URL url, wsdl;
		HttpURLConnection conn = null;
		try {

			url = new URL(prop.getProperty("namingUrl")
					+ swiftKod.toLowerCase() + "/address");
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);

			conn.setRequestMethod("GET");

			String line, wsdlString = "";
			rd = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			while ((line = rd.readLine()) != null) {
				wsdlString += line;
			}

			System.out.println(wsdlString);

			QName serviceName = new QName("PoslovnaXWS/services/banka",
					"BankaService");
			QName portName = new QName("PoslovnaXWS/services/banka",
					"BankaServicePort");

			wsdl = new URL(wsdlString + "banka?wsdl");

			Service service = Service.create(wsdl, serviceName);

			conn.disconnect();

			return service.getPort(portName, BankaServiceMessages.class);

		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null)
				conn.disconnect();
		}

		return null;

	}

	@GET
	@Path("/{id_dobavljaca}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPartner(@PathParam("id_dobavljaca")Long idDobavljaca) {
		Response response;
		Dobavljac result = new Dobavljac();

		try {
			result = dobavljacDao.findById(idDobavljaca);
		} catch (IOException | JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response = getResponsePack(result);
		return response;
	}
	
	@GET
	@Path("/vlasnik/{id_kupca}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVlasnik(@PathParam("id_kupca")Long idKupca) {
		Response response;
		Kupac result = new Kupac();

		try {
			result = kupacDao.findById(idKupca);
		} catch (IOException | JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response = getResponsePack(result);
		return response;
	}

	/**
	 * Obraca se serveru banke u odvojenom thread-u.
	 * 
	 * @author Tim 5
	 *
	 */
	private class RunnableService implements Runnable {

		private Object message;
		private String sifra;

		public RunnableService(Object message, String sifra) {
			this.message = message;
			this.sifra = sifra;
		}

		@Override
		public void run() {
			BankaServiceMessages banka = createBankaService(sifra);
			if (banka == null)
				LOG.severe("Nije pronadjen servis banke.");
			else if (message instanceof Uplata) {

				poslovnaxws.common.Status status = banka
						.receiveUplata((Uplata) message);

				LOG.info("Poziv receiveUplata banke iz firme: "
						+ status.getKod() + ":" + status.getOpis());
			}
		}

	}

}
