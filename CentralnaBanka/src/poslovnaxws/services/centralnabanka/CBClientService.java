package poslovnaxws.services.centralnabanka;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import poslovnaxws.poruke.MT900Wrapper;
import session.dao.BankaDaoLocal;
import session.dao.DnevnoStanjeRacunaDaoLocal;
import session.dao.DrzavaDaoLocal;
import session.dao.GenericDaoLocal;
import session.dao.Mt10xDaoLocal;
import session.dao.Mt9xyDaoLocal;
import session.dao.NalogDaoLocal;
import session.dao.NaseljenoMestoDaoLocal;
import session.dao.PorukaDaoLocal;
import session.dao.RacunBankeDaoLocal;
import session.dao.StavkaDnevnogRacunaDaoLocal;
import session.dao.StavkaPorukeDaoLocal;
import util.EntityInfoUtil;
import util.JndiUtils;
import util.MyJsonNode;
import util.QueryBuilderException;
import util.Restifyable;
import wrappers.BankaWrapper;
import wrappers.DnevnoStanjeRacunaWrapper;
import wrappers.DrzavaWrapper;
import wrappers.MT10xWrapper;
import wrappers.NalogWrapper;
import wrappers.NaseljenoMestoWrapper;
import wrappers.PorukaWrapper;
import wrappers.RacunBankeWrapper;
import wrappers.StavkaDnevnogRacunaWrapper;
import wrappers.StavkaPorukeWrapper;
import wrappers.Wrapper;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import entity.Banka;
import entity.DnevnoStanjeRacuna;
import entity.Drzava;
import entity.Mt10x;
import entity.Mt9xy;
import entity.Nalog;
import entity.NaseljenoMesto;
import entity.Poruka;
import entity.RacunBanke;
import entity.StavkaDnevnogRacuna;
import entity.StavkaPoruke;

public class CBClientService {

	/*
	 * @EJB ne radi unutar CXF-a, treba koristiti JNDI lookup realizovan u klasi
	 * JndiUtils.
	 */

	@EJB
	private BankaDaoLocal bankaDao = JndiUtils.getLocalEJB(JndiUtils.BANKA_EJB);

	@EJB
	private Mt10xDaoLocal mt10xDao = JndiUtils.getLocalEJB(JndiUtils.MT10X_EJB);;

	@EJB
	private DrzavaDaoLocal drzavaDao = JndiUtils
			.getLocalEJB(JndiUtils.DRZAVA_EJB);

	@EJB
	private DnevnoStanjeRacunaDaoLocal dnevnoStanjeRacunaDao = JndiUtils
			.getLocalEJB(JndiUtils.DNEVNO_STANJE_RACUNA_EJB);

	@EJB
	private NalogDaoLocal nalogDao = JndiUtils.getLocalEJB(JndiUtils.NALOG_EJB);

	@EJB
	private NaseljenoMestoDaoLocal naseljenoMestoDao = JndiUtils
			.getLocalEJB(JndiUtils.NASELJENO_MESTO_EJB);

	@EJB
	private PorukaDaoLocal porukaDao = JndiUtils
			.getLocalEJB(JndiUtils.PORUKA_EJB);

	@EJB
	private RacunBankeDaoLocal racunDao = JndiUtils
			.getLocalEJB(JndiUtils.RACUN_BANKE_EJB);

	@EJB
	private StavkaDnevnogRacunaDaoLocal stavkaDnevnogRacunaDao = JndiUtils
			.getLocalEJB(JndiUtils.STAVKA_DNEVNOG_RACUNA_EJB);

	@EJB
	private StavkaPorukeDaoLocal stavkaPorukeDao = JndiUtils
			.getLocalEJB(JndiUtils.STAVKA_PORUKE_EJB);

	@EJB
	private Mt9xyDaoLocal mt9xyDao = JndiUtils.getLocalEJB(JndiUtils.MT9xy_EJB);

	public static String REST_URL = "http://localhost:8080/CentralnaBanka/services/restService";

	public CBClientService() {
		System.out.println("Hello CBClientService");

	}

	@GET
	@Path("/poruka")
	@Produces(MediaType.APPLICATION_JSON)
	public Response poruke(@Context UriInfo query) {
		try {

			String ret = getAll(porukaDao, query);

			return Response.ok(ret).build();

		} catch (QueryBuilderException e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/mt102")
	@Produces(MediaType.APPLICATION_JSON)
	public Response mt102(@Context UriInfo query) {
		try {

			String ret = getAll(mt10xDao, query);

			return Response.ok(ret).build();

		} catch (QueryBuilderException e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/mt103")
	@Produces(MediaType.APPLICATION_JSON)
	public Response mt103(@Context UriInfo query) {
		try {

			String ret = getAll(mt10xDao, query);

			return Response.ok(ret).build();

		} catch (QueryBuilderException e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/mt900")
	@Produces(MediaType.APPLICATION_JSON)
	public Response mt900(@Context UriInfo query) {
		try {

			String ret = getAll(mt9xyDao, query);

			return Response.ok(ret).build();

		} catch (QueryBuilderException e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/mt910")
	@Produces(MediaType.APPLICATION_JSON)
	public Response mt910(@Context UriInfo query) {
		try {

			String ret = getAll(mt9xyDao, query);

			return Response.ok(ret).build();

		} catch (QueryBuilderException e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/banka")
	@Produces(MediaType.APPLICATION_JSON)
	public Response banke(@Context UriInfo query) {
		try {

			String ret = getAll(bankaDao, query);

			return Response.ok(ret).build();

		} catch (QueryBuilderException e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/dnevnoStanjeRacuna")
	@Produces(MediaType.APPLICATION_JSON)
	public Response dnevnaStanjaRacuna(@Context UriInfo query) {
		try {

			String ret = getAll(dnevnoStanjeRacunaDao, query);

			return Response.ok(ret).build();

		} catch (QueryBuilderException e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/drzava")
	@Produces(MediaType.APPLICATION_JSON)
	public Response drzave(@Context UriInfo query) {
		try {

			String ret = getAll(drzavaDao, query);

			return Response.ok(ret).build();

		} catch (QueryBuilderException e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(e.getMessage()).build();
		}

	}

	@GET
	@Path("/nalog")
	@Produces(MediaType.APPLICATION_JSON)
	public Response nalozi(@Context UriInfo query) {
		try {

			String ret = getAll(nalogDao, query);

			return Response.ok(ret).build();

		} catch (QueryBuilderException e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/naseljenoMesto")
	@Produces(MediaType.APPLICATION_JSON)
	public Response naseljenoMesto(@Context UriInfo query) {
		try {

			String ret = getAll(naseljenoMestoDao, query);

			return Response.ok(ret).build();

		} catch (QueryBuilderException e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/racunBanke")
	@Produces(MediaType.APPLICATION_JSON)
	public Response racuniBanaka(@Context UriInfo query) {
		try {

			String ret = getAll(racunDao, query);

			return Response.ok(ret).build();

		} catch (QueryBuilderException e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/stavkaDnevnogRacuna")
	@Produces(MediaType.APPLICATION_JSON)
	public Response stavkeDnevnogRacuna(@Context UriInfo query) {
		try {

			String ret = getAll(stavkaDnevnogRacunaDao, query);

			return Response.ok(ret).build();

		} catch (QueryBuilderException e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/stavkaPoruke")
	@Produces(MediaType.APPLICATION_JSON)
	public Response stavkePoruka(@Context UriInfo query) {
		try {

			String ret = getAll(stavkaPorukeDao, query);

			return Response.ok(ret).build();

		} catch (QueryBuilderException e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(e.getMessage()).build();
		}
	}

	@POST
	@Path("/banka")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addBanka(BankaWrapper bankaWrapper) {

		Banka banka = bankaWrapper.getWrappedParameter().get(0);
		if (banka.getBankaId() != 0) {
			ObjectNode mapper = new ObjectNode(JsonNodeFactory.instance);
			mapper.put("message", "Can't send ID.");
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(mapper.toString()).build();
		}
		try {
			bankaDao.persist(banka);
		} catch (RuntimeException e) {
			// EntityExistsException se nalazi ugnježden u gomili drugih
			// Ne može se uhvatiti na elegantan naèin
			return Response.status(Response.Status.CONFLICT).build();
		}

		return Response.ok().build();

	}

	@POST
	@Path("/drzava")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addDrzava(DrzavaWrapper drzavaWrapper) {

		Drzava drzava = drzavaWrapper.getWrappedElement().get(0);
		if (drzava.getIdDrzave() != 0) {
			ObjectNode mapper = new ObjectNode(JsonNodeFactory.instance);
			mapper.put("message", "Can't send ID.");
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(mapper.toString()).build();
		}
		try {
			drzavaDao.persist(drzava);
		} catch (RuntimeException e) {
			// EntityExistsException se nalazi ugnježden u gomili drugih
			// Ne može se uhvatiti na elegantan naèin
			return Response.status(Response.Status.CONFLICT).build();
		}

		return Response.ok().build();

	}

	@POST
	@Path("/naseljenoMesto")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addNaseljenoMesto(NaseljenoMestoWrapper mestoWrapper) {

		NaseljenoMesto mesto = mestoWrapper.getWrappedParameter().get(0);

		// Drzava je mandatory
		if (mesto.getDrzava() == null) {
			ObjectNode mapper = new ObjectNode(JsonNodeFactory.instance);
			mapper.put("message", "Država can't be null.");
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(mapper.toString()).build();
		}

		Drzava drzava = drzavaDao.loadFully((int) mesto.getDrzava()
				.getIdDrzave());

		drzava.addNaseljenoMesto(mesto);

		if (mesto.getIdMesta() != 0) {
			ObjectNode mapper = new ObjectNode(JsonNodeFactory.instance);
			mapper.put("message", "Can't send ID.");
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(mapper.toString()).build();
		}
		try {
			naseljenoMestoDao.persist(mesto);
			drzavaDao.merge(drzava);
		} catch (RuntimeException e) {
			// EntityExistsException se nalazi ugnježden u gomili drugih
			// Ne može se uhvatiti na elegantan naèin
			return Response.status(Response.Status.CONFLICT).build();
		}

		return Response.ok().build();

	}

	@PUT
	@Path("/{id}/drzava")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editDrzava(@PathParam(value = "id") int id,
			DrzavaWrapper drzavaWrapper) {

		Drzava drzavaOld = drzavaDao.loadFully(id);

		try {
			drzavaDao.merge(drzavaOld);
		} catch (RuntimeException e) {
			// EntityExistsException se nalazi ugnježden u gomili drugih
			// Ne može se uhvatiti na elegantan naèin
			return Response.status(Response.Status.CONFLICT).build();
		}

		return Response.ok().build();

	}

	@PUT
	@Path("/{id}/naseljenoMesto")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editMesto(@PathParam(value = "id") int id,
			NaseljenoMestoWrapper mestoWrapper) {

		NaseljenoMesto mestoNew = mestoWrapper.getWrappedParameter().get(0);
		// TODO: Nova mesta

		try {
			naseljenoMestoDao.merge(mestoNew);
		} catch (RuntimeException e) {
			// EntityExistsException se nalazi ugnježden u gomili drugih
			// Ne može se uhvatiti na elegantan naèin
			return Response.status(Response.Status.CONFLICT).build();
		}

		return Response.ok().build();

	}

	@PUT
	@Path("/{id}/banka")
	@Produces(MediaType.APPLICATION_JSON)
	public Response editBanka(@PathParam(value = "id") int id,
			BankaWrapper bankaWrapper) {

		Banka banka = bankaWrapper.getWrappedParameter().get(0);
		// TODO: Nova mesta

		try {
			bankaDao.merge(banka);
		} catch (RuntimeException e) {
			// EntityExistsException se nalazi ugnježden u gomili drugih
			// Ne može se uhvatiti na elegantan naèin
			return Response.status(Response.Status.CONFLICT).build();
		}

		return Response.ok().build();

	}

	@GET
	@Path("/{id}/drzava")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDrzava(@PathParam(value = "id") int id) {
		Wrapper ret = new Wrapper();
		Drzava value = drzavaDao.findById(id);

		if (value != null) {

			ret.addData(value.restify());

			ret.setMeta(EntityInfoUtil.getFields(Drzava.class));

			ObjectMapper objectMapper = new ObjectMapper();

			ObjectNode json = objectMapper.valueToTree(ret);
			return Response.ok(json.toString()).build();

		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	@GET
	@Path("/{id}/naseljenoMesto")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNaseljenoMesto(@PathParam(value = "id") int id) {
		Wrapper ret = new Wrapper();
		NaseljenoMesto value = naseljenoMestoDao.findById(id);

		if (value != null) {

			ret.addData(value.restify());

			ret.setMeta(EntityInfoUtil.getFields(NaseljenoMesto.class));

			ObjectMapper objectMapper = new ObjectMapper();

			ObjectNode json = objectMapper.valueToTree(ret);
			return Response.ok(json.toString()).build();

		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	@GET
	@Path("/{id}/banka")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBanka(@PathParam(value = "id") int id) {
		Wrapper ret = new Wrapper();
		Banka value = bankaDao.findById(id);

		if (value != null) {

			ret.addData(value.restify());

			ret.setMeta(EntityInfoUtil.getFields(Banka.class));

			ObjectMapper objectMapper = new ObjectMapper();

			ObjectNode json = objectMapper.valueToTree(ret);
			return Response.ok(json.toString()).build();

		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	@GET
	@Path("/{id}/poruka")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPoruka(@PathParam(value = "id") int id) {
		Wrapper ret = new Wrapper();
		Poruka value = porukaDao.findById(id);

		if (value != null) {

			ret.addData(value.restify());

			ret.setMeta(EntityInfoUtil.getFields(Poruka.class));

			ObjectMapper objectMapper = new ObjectMapper();

			ObjectNode json = objectMapper.valueToTree(ret);
			return Response.ok(json.toString()).build();

		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	@GET
	@Path("/{id}/mt102")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMT102(@PathParam(value = "id") int id) {
		Wrapper ret = new Wrapper();
		Mt10x value = mt10xDao.findById(id);

		if (value != null) {

			ret.addData(value.restify());

			ret.setMeta(EntityInfoUtil.getFields(Mt10x.class));

			ObjectMapper objectMapper = new ObjectMapper();

			ObjectNode json = objectMapper.valueToTree(ret);
			return Response.ok(json.toString()).build();

		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	@GET
	@Path("/{id}/mt103")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMT103(@PathParam(value = "id") int id) {
		Wrapper ret = new Wrapper();
		Mt10x value = mt10xDao.findById(id);

		if (value != null) {

			ret.addData(value.restify());

			ret.setMeta(EntityInfoUtil.getFields(Mt10x.class));

			ObjectMapper objectMapper = new ObjectMapper();

			ObjectNode json = objectMapper.valueToTree(ret);
			return Response.ok(json.toString()).build();

		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	@GET
	@Path("/{id}/mt900")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMT900(@PathParam(value = "id") int id) {
		Wrapper ret = new Wrapper();
		Mt9xy value = mt9xyDao.findById(id);

		if (value != null) {

			ret.addData(value.restify());

			ret.setMeta(EntityInfoUtil.getFields(Mt9xy.class));

			ObjectMapper objectMapper = new ObjectMapper();

			ObjectNode json = objectMapper.valueToTree(ret);
			return Response.ok(json.toString()).build();

		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	@GET
	@Path("/{id}/mt910")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMT910(@PathParam(value = "id") int id) {
		Wrapper ret = new Wrapper();
		Mt9xy value = mt9xyDao.findById(id);

		if (value != null) {

			ret.addData(value.restify());

			ret.setMeta(EntityInfoUtil.getFields(Mt9xy.class));

			ObjectMapper objectMapper = new ObjectMapper();

			ObjectNode json = objectMapper.valueToTree(ret);
			return Response.ok(json.toString()).build();

		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	@GET
	@Path("/{id}/racunBanke")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRacunBanke(@PathParam(value = "id") int id) {
		Wrapper ret = new Wrapper();
		RacunBanke value = racunDao.findById(id);

		if (value != null) {

			ret.addData(value.restify());

			ret.setMeta(EntityInfoUtil.getFields(RacunBanke.class));

			ObjectMapper objectMapper = new ObjectMapper();

			ObjectNode json = objectMapper.valueToTree(ret);
			return Response.ok(json.toString()).build();

		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	@GET
	@Path("/{id}/nalog")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNalog(@PathParam(value = "id") int id) {
		Wrapper ret = new Wrapper();
		Nalog value = nalogDao.findById(id);

		if (value != null) {

			ret.addData(value.restify());

			ret.setMeta(EntityInfoUtil.getFields(DnevnoStanjeRacuna.class));

			ObjectMapper objectMapper = new ObjectMapper();

			ObjectNode json = objectMapper.valueToTree(ret);
			return Response.ok(json.toString()).build();

		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	@GET
	@Path("/{id}/stavkaPoruke")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStavkaPoruke(@PathParam(value = "id") int id) {
		Wrapper ret = new Wrapper();
		StavkaPoruke value = stavkaPorukeDao.findById(id);

		if (value != null) {

			ret.addData(value.restify());

			ret.setMeta(EntityInfoUtil.getFields(StavkaPoruke.class));

			ObjectMapper objectMapper = new ObjectMapper();

			ObjectNode json = objectMapper.valueToTree(ret);
			return Response.ok(json.toString()).build();

		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	@GET
	@Path("/{id}/stavkaDnevnogRacuna")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStavkaDnevnoRacuna(@PathParam(value = "id") int id) {
		Wrapper ret = new Wrapper();
		StavkaDnevnogRacuna value = stavkaDnevnogRacunaDao.findById(id);

		if (value != null) {

			ret.addData(value.restify());

			ret.setMeta(EntityInfoUtil.getFields(StavkaDnevnogRacuna.class));

			ObjectMapper objectMapper = new ObjectMapper();

			ObjectNode json = objectMapper.valueToTree(ret);
			return Response.ok(json.toString()).build();

		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	@GET
	@Path("/{id}/drzava/naseljenoMesto")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMestaForDrzava(@PathParam(value = "id") int id) {
		Wrapper ret = new Wrapper();
		Drzava value = drzavaDao.loadFully(id);

		if (value != null) {

			for (NaseljenoMesto mesto : value.getNaseljenoMesto())
				ret.addData(mesto.restify());

			ret.setMeta(EntityInfoUtil.getFields(NaseljenoMesto.class));

			ObjectMapper objectMapper = new ObjectMapper();

			ObjectNode json = objectMapper.valueToTree(ret);
			return Response.ok(json.toString()).build();

		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	@POST
	@Path("/{id}/naseljenoMesto/drzava")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMestoForDrzava(@PathParam(value = "id") int id,
			DrzavaWrapper wrapper) {

		long idDrzave = wrapper.getWrappedElement().get(0).getIdDrzave();
		Drzava drzava = drzavaDao.loadFully(idDrzave);
		NaseljenoMesto mesto = naseljenoMestoDao.findById(id);

		if (mesto == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		} else if (drzava != null) {

			drzava.addNaseljenoMesto(mesto);
			drzavaDao.merge(drzava);
			naseljenoMestoDao.merge(mesto);
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}/banka")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response removeBanka(@PathParam(value = "id") int id) {
		Banka value = bankaDao.findById(id);

		if (value != null) {

			bankaDao.remove(value);

		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}/drzava")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response removeDrzava(@PathParam(value = "id") int id) {
		Drzava value = drzavaDao.findById(id);

		if (value != null) {

			drzavaDao.remove(value);

		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}/naseljenoMesto")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response removeMesto(@PathParam(value = "id") int id) {
		NaseljenoMesto value = naseljenoMestoDao.findById(id);

		if (value != null) {

			naseljenoMestoDao.remove(value);

		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok().build();
	}

	/**
	 * Pomocna metoda koja vraca sve entitete prosledjene klase na osnovu upita.
	 * 
	 * @param dao
	 * @param query
	 *            - upit iz URL-a REST servisa
	 * @return formirani string odgovora
	 * @throws QueryBuilderException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private String getAll(GenericDaoLocal dao, UriInfo query)
			throws QueryBuilderException {

		Wrapper ret = new Wrapper();

		HashMap<String, String> params = new HashMap<String, String>();
		// Izvuci iz upita sve parametre
		// Parametri se nalaze iza ? u URL-u, smesteni su u UriInfo
		for (String key : query.getQueryParameters().keySet()) {

			params.put(key, query.getQueryParameters().getFirst(key));

		}

		String queryString;
		try {
			queryString = EntityInfoUtil.getQueryString(dao.getEntityType(),
					params);

			List<Restifyable> dataList = dao.findBy(queryString);

			for (Restifyable data : dataList)
				ret.addData(data.restify());

			ret.setMeta(EntityInfoUtil.getFields(dao.getEntityType()));

		} catch (QueryBuilderException e) {
			e.printStackTrace();
			ObjectNode mapper = new ObjectNode(JsonNodeFactory.instance);
			mapper.put("message", "Loše formiran upit.");
			mapper.put("reason", e.getMessage());
			throw new QueryBuilderException(mapper.toString());
		}

		ObjectMapper objectMapper = new ObjectMapper();

		ObjectNode json = objectMapper.valueToTree(ret);
		return json.toString();
	}

}
