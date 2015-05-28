package rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/firma")
public class FirmRESTService {
	
	public FirmRESTService() {
		
	
	}
	
	
	@GET
	public void message() {
		System.out.println("REST service response!!1");
	}
	
	@POST
	@Path("/firma/partneri/{id}/fakture")
	@Produces("application/xml")
	public void addFaktura(@PathParam("id") String id) {
		System.out.println("Invoking addFaktura!");

	}
}
