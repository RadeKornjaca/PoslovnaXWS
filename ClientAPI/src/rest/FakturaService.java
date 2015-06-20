package rest;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.JAXBException;

<<<<<<< HEAD
import sessionbeans.common.GenericDaoLocal;
import sessionbeans.concrete.DobavljacDaoLocal;
=======
>>>>>>> 76020f2430c70993f17910d5fc4872241b948a5b
import sessionbeans.concrete.FakturaDaoLocal;
import sessionbeans.concrete.StavkaFaktureDaoLocal;
import sessionbeans.concrete.StavkeDaoLocal;
import entity.fakture.Faktura;
import entity.fakture.StavkaFakture;
import entity.fakture.StavkeFakture;

@Path("/partneri")
public class FakturaService {

	@EJB
	private FakturaDaoLocal fakturaDao;

	@EJB
	private DobavljacDaoLocal dobavljacDao;
	
	@EJB
	private StavkaFaktureDaoLocal stavkaDao;
	
	@EJB
	private StavkeDaoLocal stavkeDao;

	public FakturaService() {

	}
	
	@POST
	@Path("/{id}/fakture")
	@Produces("application/xml")
	public Response addFaktura(@PathParam("id") Long id, Faktura faktura) throws URISyntaxException {
		System.out.println("Invoking addFaktura!");
		
		Response response;
		
		URI uri = new URI("/partneri/" + id + "/fakture/" + faktura.getId());
		
		if(checkDobavljac(id)){
			response = postResponsePack(fakturaDao, faktura, uri);
		} else {
			response = Response.status(Status.FORBIDDEN).build();
		}
		
		return response;
	}



	@GET
	@Path("/{id}/fakture")
	@Produces("application/xml")
	public Response getFakture(@PathParam("id") String id) {
		System.out.println("Invoking getFakture with id poslovnog partnera !");

		System.out.println("Id poslovnog partnera: " + id);

		List<Faktura> fakture = null;

		try {
			fakture = fakturaDao.findAllById(id);
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
	@Produces("application/xml")
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
	@Produces("application/xml")
	public Response getStavke(
			@PathParam("id_dobavljaca") String idDobavljaca,
			@PathParam("id_fakture") Long idFakture) {
		
		StavkeFakture stavkeFakture = null;
		
		stavkeFakture = stavkeDao.findStavkeFakture(idDobavljaca, idFakture);
		
		Response response;
		response = getResponsePack(stavkeFakture);
		
		
		return response;

	}

	@POST
	@Path("/{id_dobavljaca}/fakture/{id_fakture}/stavke")
	@Produces("application/xml")
	public void addStavka(@PathParam("id_dobavljaca") String idDobavljaca,
			@PathParam("id_fakture") String idFakture) {

	}

	@GET
	@Path("/{id_dobavljaca}/fakture/{id_fakture}/stavke/{red_br}")
	@Produces("application/xml")
	public Response getStavka(
			@PathParam("id_dobavljaca") String idDobavljaca,
			@PathParam("id_fakture") Long idFakture,
			@PathParam("red_br") BigInteger redBr) {
		
		StavkaFakture stavka = stavkaDao.findByIdInFaktura(idDobavljaca, idFakture, redBr);
		Response response;
		
		response = getResponsePack(stavka);
		
		return response;

	}

	@PUT
	@Path("/{id_dobavljaca}/fakture/{id_fakture}/stavke/{red_br}")
	@Produces("application/xml")
	public void updateStavka(@PathParam("id_dobavljaca") String idDobavljaca,
			@PathParam("id_fakture") String idFakture,
			@PathParam("red_br") String redBr) {

	}

	@DELETE
	@Path("/{id_dobavljaca}/fakture/{id_fakture}/stavke/{red_br}")
	@Produces("application/xml")
	public Response deleteStavka(@PathParam("id_dobavljaca") String idDob,
			@PathParam("id_fakture") String idFak,
			@PathParam("red_br") String br) {
				
		
		return null;


	}

	
	/**
	 * Metoda sluzi za generisanje HTTP odgovora prilikom GET zahteva, koji se 
	 * salje klijentu. Ukoliko postoje informacije, odgovor je tipa 200, 
	 * dok ukoliko je data == null, onda se salje odgovor tipa 404.
	 * 
	 * @param data - informacioni deo odgovora
	 * @return objekat klase Response koji predstavlja enkapsulaciju HTTP odgovora
	 */
	private Response getResponsePack(Object data) {
		Response response;
		if(data != null) {
			response = Response.ok(data).build();
		}
		else {
			response = Response.status(Status.NOT_FOUND).build();
		}
		return response;
	}
	
	/**
	 * Proverava da li postoji dobavljac u listi poslovnih partnera
	 * 
	 * @param id - vrednost PIB-a dobavljaca
	 * @return	boolean vrednost u zavisnosti od toga da li postoji partner ili ne
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
	 * Vrsi validaciju i upisuje novi entitet u bazu
	 * 
	 * @param dao	- daoBean entiteta koji se upisuje
	 * @param data	- konkretan novi podatak
	 * @param uri	- kontekstna putanja na kojoj ce biti upisan novi podatak
	 * @return	uspesnost operacije
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Response postResponsePack(GenericDaoLocal dao, Object data, URI uri) {
		Response response;
		
		try {
			dao.persist(data);
			response = Response.status(Status.CREATED).contentLocation(uri).build();

		} catch (JAXBException | IOException e) {
			response = Response.status(Status.BAD_REQUEST).build();
			e.printStackTrace();
		}

		
		return response;
	}
	
}
