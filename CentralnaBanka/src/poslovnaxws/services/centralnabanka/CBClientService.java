package poslovnaxws.services.centralnabanka;

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

import java.io.PrintStream;
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
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

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
import util.QueryBuilderException;
import util.Restifyable;
import wrappers.BankaWrapper;
import wrappers.DrzavaWrapper;
import wrappers.NaseljenoMestoWrapper;
import wrappers.Wrapper;

public class CBClientService {
	@EJB
	private BankaDaoLocal bankaDao = JndiUtils.getLocalEJB(JndiUtils.BANKA_EJB);
	@EJB
	private Mt10xDaoLocal mt10xDao = JndiUtils.getLocalEJB(JndiUtils.MT10X_EJB);
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
	@Produces({ "application/json" })
	public Response poruke(@Context UriInfo query) {
		try {
			String ret = getAll(this.porukaDao, query);

			return Response.ok(ret).build();
		} catch (QueryBuilderException e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/mt102")
	@Produces({ "application/json" })
	public Response mt102(@Context UriInfo query) {
		try {
			String ret = getAll(this.mt10xDao, query);

			return Response.ok(ret).build();
		} catch (QueryBuilderException e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/mt103")
	@Produces({ "application/json" })
	public Response mt103(@Context UriInfo query) {
		try {
			String ret = getAll(this.mt10xDao, query);

			return Response.ok(ret).build();
		} catch (QueryBuilderException e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/mt900")
	@Produces({ "application/json" })
	public Response mt900(@Context UriInfo query) {
		try {
			String ret = getAll(this.mt9xyDao, query);

			return Response.ok(ret).build();
		} catch (QueryBuilderException e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/mt910")
	@Produces({ "application/json" })
	public Response mt910(@Context UriInfo query) {
		try {
			String ret = getAll(this.mt9xyDao, query);

			return Response.ok(ret).build();
		} catch (QueryBuilderException e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/banka")
	@Produces({ "application/json" })
	public Response banke(@Context UriInfo query) {
		try {
			String ret = getAll(this.bankaDao, query);

			return Response.ok(ret).build();
		} catch (QueryBuilderException e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/dnevnoStanjeRacuna")
	@Produces({ "application/json" })
	public Response dnevnaStanjaRacuna(@Context UriInfo query) {
		try {
			String ret = getAll(this.dnevnoStanjeRacunaDao, query);

			return Response.ok(ret).build();
		} catch (QueryBuilderException e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/drzava")
	@Produces({ "application/json" })
	public Response drzave(@Context UriInfo query) {
		try {
			String ret = getAll(this.drzavaDao, query);

			return Response.ok(ret).build();
		} catch (QueryBuilderException e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/nalog")
	@Produces({ "application/json" })
	public Response nalozi(@Context UriInfo query) {
		try {
			String ret = getAll(this.nalogDao, query);

			return Response.ok(ret).build();
		} catch (QueryBuilderException e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/naseljenoMesto")
	@Produces({ "application/json" })
	public Response naseljenoMesto(@Context UriInfo query) {
		try {
			String ret = getAll(this.naseljenoMestoDao, query);

			return Response.ok(ret).build();
		} catch (QueryBuilderException e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/racunBanke")
	@Produces({ "application/json" })
	public Response racuniBanaka(@Context UriInfo query) {
		try {
			String ret = getAll(this.racunDao, query);

			return Response.ok(ret).build();
		} catch (QueryBuilderException e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/stavkaDnevnogRacuna")
	@Produces({ "application/json" })
	public Response stavkeDnevnogRacuna(@Context UriInfo query) {
		try {
			String ret = getAll(this.stavkaDnevnogRacunaDao, query);

			return Response.ok(ret).build();
		} catch (QueryBuilderException e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(e.getMessage()).build();
		}
	}

	@GET
	@Path("/stavkaPoruke")
	@Produces({ "application/json" })
	public Response stavkePoruka(@Context UriInfo query) {
		try {
			String ret = getAll(this.stavkaPorukeDao, query);

			return Response.ok(ret).build();
		} catch (QueryBuilderException e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(e.getMessage()).build();
		}
	}

	@POST
	@Path("/banka")
	@Consumes({ "application/json" })
	public Response addBanka(BankaWrapper bankaWrapper) {
		Banka banka = (Banka) bankaWrapper.getWrappedParameter().get(0);
		if (banka.getBankaId() != 0L) {
			ObjectNode mapper = new ObjectNode(JsonNodeFactory.instance);
			mapper.put("message", "Can't send ID.");

			return Response.status(Response.Status.BAD_REQUEST)
					.entity(mapper.toString()).build();
		}
		try {
			this.bankaDao.persist(banka);
		} catch (RuntimeException e) {
			return Response.status(Response.Status.CONFLICT).build();
		}
		return Response.ok().build();
	}

	@POST
	@Path("/drzava")
	@Consumes({ "application/json" })
	public Response addDrzava(DrzavaWrapper drzavaWrapper) {
		Drzava drzava = (Drzava) drzavaWrapper.getWrappedElement().get(0);
		if (drzava.getIdDrzave() != 0L) {
			ObjectNode mapper = new ObjectNode(JsonNodeFactory.instance);
			mapper.put("message", "Can't send ID.");

			return Response.status(Response.Status.BAD_REQUEST)
					.entity(mapper.toString()).build();
		}
		try {
			this.drzavaDao.persist(drzava);
		} catch (RuntimeException e) {
			return Response.status(Response.Status.CONFLICT).build();
		}
		return Response.ok().build();
	}

	@POST
	@Path("/naseljenoMesto")
	@Consumes({ "application/json" })
	public Response addNaseljenoMesto(NaseljenoMestoWrapper mestoWrapper) {
		NaseljenoMesto mesto = (NaseljenoMesto) mestoWrapper
				.getWrappedParameter().get(0);
		if (mesto.getDrzava() == null) {
			ObjectNode mapper = new ObjectNode(JsonNodeFactory.instance);
			mapper.put("message", "Država can't be null.");

			return Response.status(Response.Status.BAD_REQUEST)
					.entity(mapper.toString()).build();
		}
		Drzava drzava = this.drzavaDao.loadFully((int) mesto.getDrzava()
				.getIdDrzave());

		drzava.addNaseljenoMesto(mesto);
		if (mesto.getIdMesta() != 0L) {
			ObjectNode mapper = new ObjectNode(JsonNodeFactory.instance);
			mapper.put("message", "Can't send ID.");

			return Response.status(Response.Status.BAD_REQUEST)
					.entity(mapper.toString()).build();
		}
		try {
			this.naseljenoMestoDao.persist(mesto);
			this.drzavaDao.merge(drzava);
		} catch (RuntimeException e) {
			return Response.status(Response.Status.CONFLICT).build();
		}
		return Response.ok().build();
	}

	@PUT
	@Path("/{id}/drzava")
	@Consumes({ "application/json" })
	public Response editDrzava(@PathParam("id") int id,
			DrzavaWrapper drzavaWrapper) {
		Drzava drzavaNew = drzavaWrapper.getWrappedElement().get(0);
		//Drzava drzavaOld = this.drzavaDao.loadFully(id);
		try {
			this.drzavaDao.merge(drzavaNew);
		} catch (RuntimeException e) {
			return Response.status(Response.Status.CONFLICT).build();
		}
		return Response.ok().build();
	}

	@PUT
	@Path("/{id}/naseljenoMesto")
	@Consumes({ "application/json" })
	public Response editMesto(@PathParam("id") int id,
			NaseljenoMestoWrapper mestoWrapper) {
		NaseljenoMesto mestoNew = (NaseljenoMesto) mestoWrapper
				.getWrappedParameter().get(0);
		try {
			this.naseljenoMestoDao.merge(mestoNew);
		} catch (RuntimeException e) {
			return Response.status(Response.Status.CONFLICT).build();
		}
		return Response.ok().build();
	}

	@PUT
	@Path("/{id}/banka")
	@Produces({ "application/json" })
	public Response editBanka(@PathParam("id") int id, BankaWrapper bankaWrapper) {
		Banka banka = (Banka) bankaWrapper.getWrappedParameter().get(0);
		try {
			this.bankaDao.merge(banka);
		} catch (RuntimeException e) {
			return Response.status(Response.Status.CONFLICT).build();
		}
		return Response.ok().build();
	}

	@GET
	@Path("/{id}/drzava")
	@Produces({ "application/json" })
	public Response getDrzava(@PathParam("id") int id) {
		Wrapper ret = new Wrapper();
		Drzava value = (Drzava) this.drzavaDao.findById(Integer.valueOf(id));
		if (value != null) {
			ret.addData(value.restify());

			ret.setMeta(EntityInfoUtil.getFields(Drzava.class));

			ObjectMapper objectMapper = new ObjectMapper();

			ObjectNode json = (ObjectNode) objectMapper.valueToTree(ret);
			return Response.ok(json.toString()).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

	@GET
	@Path("/{id}/naseljenoMesto")
	@Produces({ "application/json" })
	public Response getNaseljenoMesto(@PathParam("id") int id) {
		Wrapper ret = new Wrapper();
		NaseljenoMesto value = (NaseljenoMesto) this.naseljenoMestoDao
				.findById(Integer.valueOf(id));
		if (value != null) {
			ret.addData(value.restify());

			ret.setMeta(EntityInfoUtil.getFields(NaseljenoMesto.class));

			ObjectMapper objectMapper = new ObjectMapper();

			ObjectNode json = (ObjectNode) objectMapper.valueToTree(ret);
			return Response.ok(json.toString()).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

	@GET
	@Path("/{id}/banka")
	@Produces({ "application/json" })
	public Response getBanka(@PathParam("id") int id) {
		Wrapper ret = new Wrapper();
		Banka value = (Banka) this.bankaDao.findById(Integer.valueOf(id));
		if (value != null) {
			ret.addData(value.restify());

			ret.setMeta(EntityInfoUtil.getFields(Banka.class));

			ObjectMapper objectMapper = new ObjectMapper();

			ObjectNode json = (ObjectNode) objectMapper.valueToTree(ret);
			return Response.ok(json.toString()).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

	@GET
	@Path("/{id}/poruka")
	@Produces({ "application/json" })
	public Response getPoruka(@PathParam("id") int id) {
		Wrapper ret = new Wrapper();
		Poruka value = (Poruka) this.porukaDao.findById(Integer.valueOf(id));
		if (value != null) {
			ret.addData(value.restify());

			ret.setMeta(EntityInfoUtil.getFields(Poruka.class));

			ObjectMapper objectMapper = new ObjectMapper();

			ObjectNode json = (ObjectNode) objectMapper.valueToTree(ret);
			return Response.ok(json.toString()).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

	@GET
	@Path("/{id}/mt102")
	@Produces({ "application/json" })
	public Response getMT102(@PathParam("id") int id) {
		Wrapper ret = new Wrapper();
		Mt10x value = (Mt10x) this.mt10xDao.findById(Integer.valueOf(id));
		if (value != null) {
			ret.addData(value.restify());

			ret.setMeta(EntityInfoUtil.getFields(Mt10x.class));

			ObjectMapper objectMapper = new ObjectMapper();

			ObjectNode json = (ObjectNode) objectMapper.valueToTree(ret);
			return Response.ok(json.toString()).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

	@GET
	@Path("/{id}/mt103")
	@Produces({ "application/json" })
	public Response getMT103(@PathParam("id") int id) {
		Wrapper ret = new Wrapper();
		Mt10x value = (Mt10x) this.mt10xDao.findById(Integer.valueOf(id));
		if (value != null) {
			ret.addData(value.restify());

			ret.setMeta(EntityInfoUtil.getFields(Mt10x.class));

			ObjectMapper objectMapper = new ObjectMapper();

			ObjectNode json = (ObjectNode) objectMapper.valueToTree(ret);
			return Response.ok(json.toString()).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

	@GET
	@Path("/{id}/mt900")
	@Produces({ "application/json" })
	public Response getMT900(@PathParam("id") int id) {
		Wrapper ret = new Wrapper();
		Mt9xy value = (Mt9xy) this.mt9xyDao.findById(Integer.valueOf(id));
		if (value != null) {
			ret.addData(value.restify());

			ret.setMeta(EntityInfoUtil.getFields(Mt9xy.class));

			ObjectMapper objectMapper = new ObjectMapper();

			ObjectNode json = (ObjectNode) objectMapper.valueToTree(ret);
			return Response.ok(json.toString()).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

	@GET
	@Path("/{id}/mt910")
	@Produces({ "application/json" })
	public Response getMT910(@PathParam("id") int id) {
		Wrapper ret = new Wrapper();
		Mt9xy value = (Mt9xy) this.mt9xyDao.findById(Integer.valueOf(id));
		if (value != null) {
			ret.addData(value.restify());

			ret.setMeta(EntityInfoUtil.getFields(Mt9xy.class));

			ObjectMapper objectMapper = new ObjectMapper();

			ObjectNode json = (ObjectNode) objectMapper.valueToTree(ret);
			return Response.ok(json.toString()).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

	@GET
	@Path("/{id}/racunBanke")
	@Produces({ "application/json" })
	public Response getRacunBanke(@PathParam("id") int id) {
		Wrapper ret = new Wrapper();
		RacunBanke value = (RacunBanke) this.racunDao.findById(Integer
				.valueOf(id));
		if (value != null) {
			ret.addData(value.restify());

			ret.setMeta(EntityInfoUtil.getFields(RacunBanke.class));

			ObjectMapper objectMapper = new ObjectMapper();

			ObjectNode json = (ObjectNode) objectMapper.valueToTree(ret);
			return Response.ok(json.toString()).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

	@GET
	@Path("/{id}/nalog")
	@Produces({ "application/json" })
	public Response getNalog(@PathParam("id") int id) {
		Wrapper ret = new Wrapper();
		Nalog value = (Nalog) this.nalogDao.findById(Integer.valueOf(id));
		if (value != null) {
			ret.addData(value.restify());

			ret.setMeta(EntityInfoUtil.getFields(DnevnoStanjeRacuna.class));

			ObjectMapper objectMapper = new ObjectMapper();

			ObjectNode json = (ObjectNode) objectMapper.valueToTree(ret);
			return Response.ok(json.toString()).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

	@GET
	@Path("/{id}/stavkaPoruke")
	@Produces({ "application/json" })
	public Response getStavkaPoruke(@PathParam("id") int id) {
		Wrapper ret = new Wrapper();
		StavkaPoruke value = (StavkaPoruke) this.stavkaPorukeDao
				.findById(Integer.valueOf(id));
		if (value != null) {
			ret.addData(value.restify());

			ret.setMeta(EntityInfoUtil.getFields(StavkaPoruke.class));

			ObjectMapper objectMapper = new ObjectMapper();

			ObjectNode json = (ObjectNode) objectMapper.valueToTree(ret);
			return Response.ok(json.toString()).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

	@GET
	@Path("/{id}/stavkaDnevnogRacuna")
	@Produces({ "application/json" })
	public Response getStavkaDnevnoRacuna(@PathParam("id") int id) {
		Wrapper ret = new Wrapper();
		StavkaDnevnogRacuna value = (StavkaDnevnogRacuna) this.stavkaDnevnogRacunaDao
				.findById(Integer.valueOf(id));
		if (value != null) {
			ret.addData(value.restify());

			ret.setMeta(EntityInfoUtil.getFields(StavkaDnevnogRacuna.class));

			ObjectMapper objectMapper = new ObjectMapper();

			ObjectNode json = (ObjectNode) objectMapper.valueToTree(ret);
			return Response.ok(json.toString()).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

	@GET
	@Path("/{id}/drzava/naseljenoMesto")
	@Produces({ "application/json" })
	public Response getMestaForDrzava(@PathParam("id") int id) {
		Wrapper ret = new Wrapper();
		Drzava value = this.drzavaDao.loadFully(id);
		if (value != null) {
			for (NaseljenoMesto mesto : value.getNaseljenoMesto()) {
				ret.addData(mesto.restify());
			}
			ret.setMeta(EntityInfoUtil.getFields(NaseljenoMesto.class));

			ObjectMapper objectMapper = new ObjectMapper();

			ObjectNode json = (ObjectNode) objectMapper.valueToTree(ret);
			return Response.ok(json.toString()).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

	@POST
	@Path("/{id}/naseljenoMesto/drzava")
	@Produces({ "application/json" })
	public Response addMestoForDrzava(@PathParam("id") int id,
			DrzavaWrapper wrapper) {
		long idDrzave = ((Drzava) wrapper.getWrappedElement().get(0))
				.getIdDrzave();
		Drzava drzava = this.drzavaDao.loadFully(idDrzave);
		NaseljenoMesto mesto = (NaseljenoMesto) this.naseljenoMestoDao
				.findById(Integer.valueOf(id));
		if (mesto == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		if (drzava != null) {
			drzava.addNaseljenoMesto(mesto);
			this.drzavaDao.merge(drzava);
			this.naseljenoMestoDao.merge(mesto);
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}/banka")
	@Consumes({ "application/json" })
	public Response removeBanka(@PathParam("id") int id) {
		Banka value = (Banka) this.bankaDao.findById(Integer.valueOf(id));
		if (value != null) {
			this.bankaDao.remove(value);
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}/drzava")
	@Consumes({ "application/json" })
	public Response removeDrzava(@PathParam("id") int id) {
		Drzava value = (Drzava) this.drzavaDao.findById(Integer.valueOf(id));
		if (value != null) {
			this.drzavaDao.remove(value);
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}/naseljenoMesto")
	@Consumes({ "application/json" })
	public Response removeMesto(@PathParam("id") int id) {
		NaseljenoMesto value = (NaseljenoMesto) this.naseljenoMestoDao
				.findById(Integer.valueOf(id));
		if (value != null) {
			this.naseljenoMestoDao.remove(value);
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok().build();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private String getAll(GenericDaoLocal dao, UriInfo query)
			throws QueryBuilderException {
		Wrapper ret = new Wrapper();

		HashMap<String, String> params = new HashMap<String, String>();
		for (String key : query.getQueryParameters().keySet()) {
			params.put(key, query.getQueryParameters().getFirst(key));
		}
		try {
			String queryString = EntityInfoUtil.getQueryString(
					dao.getEntityType(), params);

			List<Restifyable> dataList = dao.findBy(queryString);
			for (Restifyable data : dataList) {
				ret.addData(data.restify());
			}
			ret.setMeta(EntityInfoUtil.getFields(dao.getEntityType()));
		} catch (QueryBuilderException e) {
			e.printStackTrace();
			ObjectNode mapper = new ObjectNode(JsonNodeFactory.instance);
			mapper.put("message", "Loše formiran upit.");
			mapper.put("reason", e.getMessage());
			throw new QueryBuilderException(mapper.toString());
		}
		ObjectMapper objectMapper = new ObjectMapper();

		ObjectNode json = (ObjectNode) objectMapper.valueToTree(ret);
		return json.toString();
	}
}
