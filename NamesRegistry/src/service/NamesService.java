package service;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;

@Path("/names")
public class NamesService {

	public NamesService() {

	}

	@PUT
	@Path("/address")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response register(String pair, @Context HttpServletRequest hsr) {
		String fullPath = hsr.getServletContext().getRealPath("/")
				+ "../../names.json";
		ObjectMapper mapper = new ObjectMapper();
		try {

			String[] params = pair.split("!");

			ObjectNode json = (ObjectNode) mapper.readTree(new File(fullPath));

			if (params.length != 2) {
				Response.status(Status.BAD_REQUEST).build();
			}

			json.put(params[0].toLowerCase(), params[1]);

			mapper.writeValue(new File(fullPath), json);

			return Response.ok().build();

		} catch (IOException e) {
			System.out.println("IO exception json");
			e.printStackTrace();
		}

		return Response.ok().build();
	}

	@GET
	@Path("/{name}/address")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAddress(@PathParam("name") String name,
			@Context HttpServletRequest hsr) {
		String fullPath = hsr.getServletContext().getRealPath("/")
				+ "../../names.json";
		ObjectMapper mapper = new ObjectMapper();
		try {
			ObjectNode json = (ObjectNode) mapper.readTree(new File(fullPath));
			if (json.get(name) != null)
				return Response.ok(json.get(name).toString().replace("\"", ""))
						.build();
			else
				return Response.serverError().build();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Response.status(Status.NOT_FOUND).build();
	}

	@GET
	@Path("/cb")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAddress(@Context HttpServletRequest hsr) {
		String fullPath = hsr.getServletContext().getRealPath("/")
				+ "../../names.json";
		ObjectMapper mapper = new ObjectMapper();
		try {
			ObjectNode json = (ObjectNode) mapper.readTree(new File(fullPath));
			if (json.get("cb") != null)
				return Response.ok(json.get("cb").toString().replace("\"", ""))
						.build();
			else
				return Response.serverError().build();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Response.status(Status.NOT_FOUND).build();
	}
}
