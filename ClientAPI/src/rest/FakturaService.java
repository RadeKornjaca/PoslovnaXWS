package rest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
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

import sessionbeans.concrete.FakturaDaoLocal;
import sessionbeans.concrete.TFirmaDaoLocal;
import entity.common.TFirma;
import entity.fakture.Faktura;
import entity.fakture.TStavkaFakture;

@Path("/partneri")
public class FakturaService {

	@EJB
	private FakturaDaoLocal fakturaDao;

	@EJB
	private TFirmaDaoLocal tfirmaDao;

	public FakturaService() {

	}

	@POST
	@Path("/{id}/fakture")
	@Produces("application/xml")
	public Response addFaktura(@PathParam("id") String id, Faktura faktura) {
		System.out.println("Invoking addFaktura!");

		System.out.println("Id poslovnog partnera: " + id);
		System.out.println(faktura);

		Response response = Response.status(Status.BAD_REQUEST).build();

		TFirma dobavljac = null;
		try {
			dobavljac = tfirmaDao.findById(Long.parseLong(id));
		} catch (NumberFormatException | JAXBException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println(tfirmaDao);
		System.out.println(dobavljac);
		
		if(dobavljac != null){
			try {
				fakturaDao.persist(faktura);
				try {
					response = Response.status(Status.CREATED).contentLocation(new URI("/partneri/" + id + "/fakture/" + faktura.getId())).build();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			response = Response.status(Status.FORBIDDEN).build();
		}

		
		return response;
	}

	@GET
	@Path("/{id}/fakture")
	@Produces("application/xml")
	public List<Faktura> getFakture(@PathParam("id") String id) {
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

		return fakture;
	}

	@GET
	@Path("/{id_dobavljaca}/fakture/{id_fakture}")
	@Produces("application/xml")
	public Faktura getFakturaFromDobavljac(
			@PathParam("id_dobavljaca") String idDobavljaca,
			@PathParam("id_fakture") String idFakture) {
		System.out.println("Invoking getFakturaFromDobavljac");

		return new Faktura();
	}

	@GET
	@Path("/{id_dobavljaca}/fakture/{id_fakture}/stavke")
	@Produces("application/xml")
	public List<TStavkaFakture> getStavke(
			@PathParam("id_dobavljaca") String idDobavljaca,
			@PathParam("id_fakture") String idFakture) {

		return new ArrayList<TStavkaFakture>();

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
	public TStavkaFakture getStavka(
			@PathParam("id_dobavljaca") String idDobavljaca,
			@PathParam("id_fakture") String idFakture,
			@PathParam("red_br") String redBr) {
		return new TStavkaFakture();

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
		long idDobavljaca = Long.parseLong(idDob);
		long idFakture = Long.parseLong(idFak);
		int redBr = Integer.parseInt(br);

		System.out.println("Invoking deleteStavka!");

		Response response;

		// fali HTTP 403 ukoliko dobavljac nije poslovni partner kupca

		Faktura faktura = null;
		try {
			faktura = fakturaDao.findById(idFakture);
		} catch (JAXBException e) {
			response = Response.status(Status.NOT_FOUND).build();
		} catch (IOException e) {
			e.printStackTrace();
		}

		TStavkaFakture resource = faktura.getStavkeFakture().getStavkaFakture()
				.get(redBr); // TODO: Povuci iz baze

		if (resource != null) {
			// TODO: Remove stavka
			response = Response.ok().build();
		} else {
			response = Response.noContent().build();
		}

		return response;
	}

}
