package poslovnaxws.services.centralnabanka;

import java.util.HashMap;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
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

import session.dao.BankaDaoLocal;
import session.dao.DnevnoStanjeRacunaDaoLocal;
import session.dao.DrzavaDaoLocal;
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
import util.QueryBuilderException;
import wrappers.BankaWrapper;
import wrappers.DnevnoStanjeRacunaWrapper;
import wrappers.DrzavaWrapper;
import wrappers.MT10xWrapper;
import wrappers.MT9xyWrapper;
import wrappers.NalogWrapper;
import wrappers.NaseljenoMestoWrapper;
import wrappers.PorukaWrapper;
import wrappers.RacunBankeWrapper;
import wrappers.StavkaDnevnogRacunaWrapper;
import wrappers.StavkaPorukeWrapper;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import entity.Banka;
import entity.Drzava;
import entity.NaseljenoMesto;

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

	public CBClientService() {
		System.out.println("Hello CBClientService");

	}

	@GET
	@Path("/poruke")
	@Produces(MediaType.APPLICATION_JSON)
	public Response poruke(@Context UriInfo query) {

		PorukaWrapper ret = new PorukaWrapper();

		HashMap<String, String> params = new HashMap<String, String>();

		for (String key : query.getQueryParameters().keySet()) {

			params.put(key, query.getQueryParameters().getFirst(key));

		}

		String queryString;
		try {
			queryString = EntityInfoUtil.getQueryString(Drzava.class, params);
			ret.setWrappedElement(porukaDao.findBy(queryString));
		} catch (QueryBuilderException e) {
			e.printStackTrace();
			ObjectNode mapper = new ObjectNode(JsonNodeFactory.instance);
			mapper.put("message", "Bad request.");
			mapper.put("reason", e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(mapper.toString()).build();
		}

		return Response.ok(ret).build();
	}

	@GET
	@Path("/mt102")
	@Produces(MediaType.APPLICATION_JSON)
	public Response mt102(@Context UriInfo query) {

		MT10xWrapper ret = new MT10xWrapper();

		HashMap<String, String> params = new HashMap<String, String>();

		for (String key : query.getQueryParameters().keySet()) {

			params.put(key, query.getQueryParameters().getFirst(key));

		}

		String queryString;
		try {
			queryString = EntityInfoUtil.getQueryString(Drzava.class, params);
			ret.setWrappedElement(mt10xDao.findBy(queryString));
		} catch (QueryBuilderException e) {
			e.printStackTrace();
			ObjectNode mapper = new ObjectNode(JsonNodeFactory.instance);
			mapper.put("message", "Bad request.");
			mapper.put("reason", e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(mapper.toString()).build();
		}

		return Response.ok(ret).build();
	}

	@GET
	@Path("/mt103")
	@Produces(MediaType.APPLICATION_JSON)
	public Response mt103(@Context UriInfo query) {

		MT10xWrapper ret = new MT10xWrapper();

		HashMap<String, String> params = new HashMap<String, String>();

		for (String key : query.getQueryParameters().keySet()) {

			params.put(key, query.getQueryParameters().getFirst(key));

		}

		String queryString;
		try {
			queryString = EntityInfoUtil.getQueryString(Drzava.class, params);
			ret.setWrappedElement(mt10xDao.findBy(queryString));
		} catch (QueryBuilderException e) {
			e.printStackTrace();
			ObjectNode mapper = new ObjectNode(JsonNodeFactory.instance);
			mapper.put("message", "Bad request.");
			mapper.put("reason", e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(mapper.toString()).build();
		}

		return Response.ok(ret).build();
	}

	@GET
	@Path("/mt900")
	@Produces(MediaType.APPLICATION_JSON)
	public Response mt900(@Context UriInfo query) {

		MT9xyWrapper ret = new MT9xyWrapper();

		HashMap<String, String> params = new HashMap<String, String>();

		for (String key : query.getQueryParameters().keySet()) {

			params.put(key, query.getQueryParameters().getFirst(key));

		}

		String queryString;
		try {
			queryString = EntityInfoUtil.getQueryString(Drzava.class, params);
			ret.setWrappedElement(mt9xyDao.findBy(queryString));
		} catch (QueryBuilderException e) {
			e.printStackTrace();
			ObjectNode mapper = new ObjectNode(JsonNodeFactory.instance);
			mapper.put("message", "Bad request.");
			mapper.put("reason", e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(mapper.toString()).build();
		}

		return Response.ok(ret).build();
	}

	@GET
	@Path("/mt910")
	@Produces(MediaType.APPLICATION_JSON)
	public Response mt910(@Context UriInfo query) {

		MT9xyWrapper ret = new MT9xyWrapper();

		HashMap<String, String> params = new HashMap<String, String>();

		for (String key : query.getQueryParameters().keySet()) {

			params.put(key, query.getQueryParameters().getFirst(key));

		}

		String queryString;
		try {
			queryString = EntityInfoUtil.getQueryString(Drzava.class, params);
			ret.setWrappedElement(mt9xyDao.findBy(queryString));
		} catch (QueryBuilderException e) {
			e.printStackTrace();
			ObjectNode mapper = new ObjectNode(JsonNodeFactory.instance);
			mapper.put("message", "Bad request.");
			mapper.put("reason", e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(mapper.toString()).build();
		}

		return Response.ok(ret).build();
	}

	@GET
	@Path("/banke")
	@Produces(MediaType.APPLICATION_JSON)
	public Response banke(@Context UriInfo query) {

		BankaWrapper ret = new BankaWrapper();

		HashMap<String, String> params = new HashMap<String, String>();

		for (String key : query.getQueryParameters().keySet()) {

			params.put(key, query.getQueryParameters().getFirst(key));

		}

		String queryString;
		try {
			queryString = EntityInfoUtil.getQueryString(Banka.class, params);
			ret.setWrappedElement(bankaDao.findBy(queryString));
		} catch (QueryBuilderException e) {
			e.printStackTrace();
			ObjectNode mapper = new ObjectNode(JsonNodeFactory.instance);
			mapper.put("message", "Bad request.");
			mapper.put("reason", e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(mapper.toString()).build();
		}

		return Response.ok(ret).build();
	}

	@GET
	@Path("/dnevnaStanjaRacuna")
	@Produces(MediaType.APPLICATION_JSON)
	public Response dnevnaStanjaRacuna(@Context UriInfo query) {

		DnevnoStanjeRacunaWrapper ret = new DnevnoStanjeRacunaWrapper();

		HashMap<String, String> params = new HashMap<String, String>();

		for (String key : query.getQueryParameters().keySet()) {

			params.put(key, query.getQueryParameters().getFirst(key));

		}

		String queryString;
		try {
			queryString = EntityInfoUtil.getQueryString(Drzava.class, params);
			ret.setWrappedElement(dnevnoStanjeRacunaDao.findBy(queryString));
		} catch (QueryBuilderException e) {
			e.printStackTrace();
			ObjectNode mapper = new ObjectNode(JsonNodeFactory.instance);
			mapper.put("message", "Bad request.");
			mapper.put("reason", e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(mapper.toString()).build();
		}

		return Response.ok(ret).build();
	}

	@GET
	@Path("/drzave")
	@Produces(MediaType.APPLICATION_JSON)
	public Response drzave(@Context UriInfo query) {

		DrzavaWrapper ret = new DrzavaWrapper();

		HashMap<String, String> params = new HashMap<String, String>();

		for (String key : query.getQueryParameters().keySet()) {

			params.put(key, query.getQueryParameters().getFirst(key));

		}

		String queryString;
		try {
			queryString = EntityInfoUtil.getQueryString(Drzava.class, params);
			ret.setWrappedElement(drzavaDao.findBy(queryString));
		} catch (QueryBuilderException e) {
			e.printStackTrace();
			ObjectNode mapper = new ObjectNode(JsonNodeFactory.instance);
			mapper.put("message", "Bad request.");
			mapper.put("reason", e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(mapper.toString()).build();
		}

		return Response.ok(ret).build();
	}

	@GET
	@Path("/nalozi")
	@Produces(MediaType.APPLICATION_JSON)
	public Response nalozi(@Context UriInfo query) {

		NalogWrapper ret = new NalogWrapper();

		HashMap<String, String> params = new HashMap<String, String>();

		for (String key : query.getQueryParameters().keySet()) {

			params.put(key, query.getQueryParameters().getFirst(key));

		}

		String queryString;
		try {
			queryString = EntityInfoUtil.getQueryString(Drzava.class, params);
			ret.setWrappedElement(nalogDao.findBy(queryString));
		} catch (QueryBuilderException e) {
			e.printStackTrace();
			ObjectNode mapper = new ObjectNode(JsonNodeFactory.instance);
			mapper.put("message", "Bad request.");
			mapper.put("reason", e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(mapper.toString()).build();
		}

		return Response.ok(ret).build();
	}

	@GET
	@Path("/naseljenaMesta")
	@Produces(MediaType.APPLICATION_JSON)
	public Response naseljenaMesta(@Context UriInfo query) {

		NaseljenoMestoWrapper ret = new NaseljenoMestoWrapper();

		HashMap<String, String> params = new HashMap<String, String>();

		for (String key : query.getQueryParameters().keySet()) {

			params.put(key, query.getQueryParameters().getFirst(key));

		}

		String queryString;
		try {
			queryString = EntityInfoUtil.getQueryString(Drzava.class, params);
			ret.setWrappedElement(naseljenoMestoDao.findBy(queryString));
		} catch (QueryBuilderException e) {
			e.printStackTrace();
			ObjectNode mapper = new ObjectNode(JsonNodeFactory.instance);
			mapper.put("message", "Bad request.");
			mapper.put("reason", e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(mapper.toString()).build();
		}

		return Response.ok(ret).build();
	}

	@GET
	@Path("/racuniBanaka")
	@Produces(MediaType.APPLICATION_JSON)
	public Response racuniBanaka(@Context UriInfo query) {

		RacunBankeWrapper ret = new RacunBankeWrapper();

		HashMap<String, String> params = new HashMap<String, String>();

		for (String key : query.getQueryParameters().keySet()) {

			params.put(key, query.getQueryParameters().getFirst(key));

		}

		String queryString;
		try {
			queryString = EntityInfoUtil.getQueryString(Drzava.class, params);
			ret.setWrappedElement(racunDao.findBy(queryString));
		} catch (QueryBuilderException e) {
			e.printStackTrace();
			ObjectNode mapper = new ObjectNode(JsonNodeFactory.instance);
			mapper.put("message", "Bad request.");
			mapper.put("reason", e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(mapper.toString()).build();
		}

		return Response.ok(ret).build();
	}

	@GET
	@Path("/stavkeDnevnogRacuna")
	@Produces(MediaType.APPLICATION_JSON)
	public Response stavkeDnevnogRacuna(@Context UriInfo query) {

		StavkaDnevnogRacunaWrapper ret = new StavkaDnevnogRacunaWrapper();

		HashMap<String, String> params = new HashMap<String, String>();

		for (String key : query.getQueryParameters().keySet()) {

			params.put(key, query.getQueryParameters().getFirst(key));

		}

		String queryString;
		try {
			queryString = EntityInfoUtil.getQueryString(Drzava.class, params);
			ret.setWrappedElement(stavkaDnevnogRacunaDao.findBy(queryString));
		} catch (QueryBuilderException e) {
			e.printStackTrace();
			ObjectNode mapper = new ObjectNode(JsonNodeFactory.instance);
			mapper.put("message", "Bad request.");
			mapper.put("reason", e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(mapper.toString()).build();
		}

		return Response.ok(ret).build();
	}

	@GET
	@Path("/stavkePoruka")
	@Produces(MediaType.APPLICATION_JSON)
	public Response stavkePoruka(@Context UriInfo query) {

		StavkaPorukeWrapper ret = new StavkaPorukeWrapper();

		HashMap<String, String> params = new HashMap<String, String>();

		for (String key : query.getQueryParameters().keySet()) {

			params.put(key, query.getQueryParameters().getFirst(key));

		}

		String queryString;
		try {
			queryString = EntityInfoUtil.getQueryString(Drzava.class, params);
			ret.setWrappedElement(stavkaPorukeDao.findBy(queryString));
		} catch (QueryBuilderException e) {
			e.printStackTrace();
			ObjectNode mapper = new ObjectNode(JsonNodeFactory.instance);
			mapper.put("message", "Bad request.");
			mapper.put("reason", e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(mapper.toString()).build();
		}

		return Response.ok(ret).build();
	}

	@POST
	@Path("/banke")
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
			// EntityExistsException se nalazi ugnje�den u gomili drugih
			// Ne mo�e se uhvatiti na elegantan na�in
			return Response.status(Response.Status.CONFLICT).build();
		}

		return Response.ok().build();

	}

	@POST
	@Path("/drzave")
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
			// EntityExistsException se nalazi ugnje�den u gomili drugih
			// Ne mo�e se uhvatiti na elegantan na�in
			return Response.status(Response.Status.CONFLICT).build();
		}

		return Response.ok().build();

	}

	@POST
	@Path("/naseljenaMesta")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addNaseljenoMesto(NaseljenoMestoWrapper mestoWrapper) {

		NaseljenoMesto mesto = mestoWrapper.getWrappedParameter().get(0);
		
		//Drzava je mandatory
		if (mesto.getDrzava() == null) {
			ObjectNode mapper = new ObjectNode(JsonNodeFactory.instance);
			mapper.put("message", "Dr�ava can't be null.");
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(mapper.toString()).build();
		}
		
		Drzava drzava = drzavaDao.loadFully((int) mesto.getDrzava().getIdDrzave());

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
			// EntityExistsException se nalazi ugnje�den u gomili drugih
			// Ne mo�e se uhvatiti na elegantan na�in
			return Response.status(Response.Status.CONFLICT).build();
		}

		return Response.ok().build();

	}

	@PUT
	@Path("/{id}/drzave")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editDrzava(@PathParam(value = "id") int id,
			DrzavaWrapper drzavaWrapper) {

		Drzava drzavaNew = drzavaWrapper.getWrappedElement().get(0);
		Drzava drzavaOld = drzavaDao.findById(id);

		drzavaOld.setNazivDrzave(drzavaNew.getNazivDrzave());
		drzavaOld.setSifraDrzave(drzavaNew.getSifraDrzave());
		System.out.println(drzavaOld.getNazivDrzave());
		//TODO: Nova mesta

		try {
			drzavaDao.merge(drzavaOld);
			System.out.println(drzavaOld.getNazivDrzave());
		} catch (RuntimeException e) {
			// EntityExistsException se nalazi ugnje�den u gomili drugih
			// Ne mo�e se uhvatiti na elegantan na�in
			return Response.status(Response.Status.CONFLICT).build();
		}

		return Response.ok().build();

	}

	@PUT
	@Path("/{id}/naseljenaMesta")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editMesto(@PathParam(value = "id") int id,
			NaseljenoMestoWrapper mestoWrapper) {

		NaseljenoMesto mestoNew = mestoWrapper.getWrappedParameter().get(0);
		NaseljenoMesto mestoOld = naseljenoMestoDao.findById(id);

		mestoOld.setNazivMesta(mestoNew.getNazivMesta());
		mestoOld.setSifraMesta(mestoNew.getSifraMesta());

		try {

			naseljenoMestoDao.merge(mestoOld);
		} catch (RuntimeException e) {
			// EntityExistsException se nalazi ugnje�den u gomili drugih
			// Ne mo�e se uhvatiti na elegantan na�in
			return Response.status(Response.Status.CONFLICT).build();
		}

		return Response.ok().build();

	}

	@PUT
	@Path("/{id}/banke")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editBanka(@PathParam(value = "id") int id,
			BankaWrapper bankaWrapper) {

		Banka bankaNew = bankaWrapper.getWrappedParameter().get(0);
		Banka bankaOld = bankaDao.findById(id);

		bankaOld.setNaziv(bankaNew.getNaziv());
		bankaOld.setSifra(bankaNew.getSifra());
		bankaOld.setSwiftKod(bankaNew.getSwiftKod());
		bankaOld.setRacunBanke(bankaNew.getRacunBanke());

		try {

			bankaDao.merge(bankaOld);
		} catch (RuntimeException e) {
			// EntityExistsException se nalazi ugnje�den u gomili drugih
			// Ne mo�e se uhvatiti na elegantan na�in
			return Response.status(Response.Status.CONFLICT).build();
		}

		return Response.ok().build();

	}
	
	@GET
	@Path("/{id}/drzave")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getDrzava(@PathParam(value = "id") int id){
		DrzavaWrapper ret = new DrzavaWrapper();
		Drzava value = drzavaDao.findById(id);
		
		if (value != null){
			ret.getWrappedElement().add(value);
			return Response.ok(ret).build();
		}
		else{
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
}
