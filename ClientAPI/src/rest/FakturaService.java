package rest;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.bind.JAXBException;

import sessionbeans.concrete.FakturaDaoLocal;
import entity.fakture.Faktura;


@Path("/partneri")
public class FakturaService {
	
	@EJB
	private FakturaDaoLocal fakturaDao;
	
	
	public FakturaService() {
		System.out.println("Hello FakturaService");
		
	}
	
	
	@GET
	public void message() {
		System.out.println("REST service response!!1");
	}
	
	@POST
	@Path("/{id}/fakture")
	@Produces("application/xml")
	public void addFaktura(@PathParam("id") String id, Faktura faktura) {
		System.out.println("Invoking addFaktura!");
		
		System.out.println("Id poslovnog partnera: " + id);
		System.out.println(faktura);
		
		try {
			fakturaDao.persist(faktura);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@GET
	@Path("/{id}/fakture")
	@Produces("application/xml")
	public void getFakture(@PathParam("id") String id) {
		System.out.println("Invoking getFakture with id poslovnog partnera !");
		
		System.out.println("Id poslovnog partnera: " + id);
	}
}
