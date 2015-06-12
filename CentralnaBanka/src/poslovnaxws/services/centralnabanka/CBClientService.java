package poslovnaxws.services.centralnabanka;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import session.dao.BankaDaoLocal;
import session.dao.DnevnoStanjeRacunaDaoLocal;
import session.dao.DrzavaDaoLocal;
import session.dao.Mt10xDaoLocal;
import session.dao.NalogDaoLocal;
import session.dao.NaseljenoMestoDaoLocal;
import session.dao.PorukaDaoLocal;
import session.dao.RacunBankeDaoLocal;
import session.dao.StavkaDnevnogRacunaDaoLocal;
import session.dao.StavkaPorukeDaoLocal;
import util.JndiUtils;
import wrappers.BankaWrapper;
import wrappers.DnevnoStanjeRacunaWrapper;
import wrappers.DrzavaWrapper;
import wrappers.MT10xWrapper;
import wrappers.NalogWrapper;
import wrappers.NaseljenoMestoWrapper;
import wrappers.RacunBankeWrapper;
import wrappers.StavkaDnevnogRacunaWrapper;
import wrappers.StavkaPorukeWrapper;
import entity.Mt10x;


public class CBClientService {
	
	/*	@EJB ne radi unutar CXF-a, treba koristiti JNDI lookup
	 *	realizovan u klasi JndiUtils.
	 */

	@EJB
	private BankaDaoLocal bankaDao = JndiUtils.getLocalEJB(JndiUtils.BANKA_EJB);
	
	@EJB
	private Mt10xDaoLocal mt10xDao;
	
	@EJB
	private DrzavaDaoLocal drzavaDao  = JndiUtils.getLocalEJB(JndiUtils.DRZAVA_EJB);
	
	@EJB
	private DnevnoStanjeRacunaDaoLocal dnevnoStanjeRacunaDao = JndiUtils.getLocalEJB(JndiUtils.DNEVNO_STANJE_RACUNA_EJB);
	
	@EJB
	private NalogDaoLocal nalogDao = JndiUtils.getLocalEJB(JndiUtils.NALOG_EJB);
	
	@EJB
	private NaseljenoMestoDaoLocal naseljenoMestoDao = JndiUtils.getLocalEJB(JndiUtils.NASELJENO_MESTO_EJB);
	
	@EJB
	private PorukaDaoLocal porukaDao = JndiUtils.getLocalEJB(JndiUtils.PORUKA_EJB);
	
	@EJB
	private RacunBankeDaoLocal racunDao = JndiUtils.getLocalEJB(JndiUtils.RACUN_BANKE_EJB);
	
	@EJB
	private StavkaDnevnogRacunaDaoLocal stavkaDnevnogRacunaDao = JndiUtils.getLocalEJB(JndiUtils.STAVKA_DNEVNOG_RACUNA_EJB);
	
	@EJB
	private StavkaPorukeDaoLocal stavkaPorukeDao = JndiUtils.getLocalEJB(JndiUtils.STAVKA_PORUKE_EJB);

	public CBClientService() {
		System.out.println("Hello FakturaService");

	}

	// TODO: vadi iz baze i vracaj

	@GET
	@Path("/poruke")
	@Produces(MediaType.APPLICATION_JSON)
	public MT10xWrapper poruke() {
		MT10xWrapper ret = new MT10xWrapper();
		Mt10x poruka1 = new Mt10x();
		poruka1.setIdPoruke(231);
		poruka1.setSvrhaPlacanja("Uplata silnih novaca.");
		ArrayList<Mt10x> list = new ArrayList<Mt10x>();
		list.add(poruka1);

		Mt10x poruka2 = new Mt10x();
		poruka2.setIdPoruke(455);
		poruka2.setSvrhaPlacanja("Novcaniceeeeeee!");
		list.add(poruka2);
		System.out.println("Ajajajaj!");
		
		mt10xDao = JndiUtils.getLocalEJB(JndiUtils.MT10X_EJB);
		
		ret.setWrappedParameter(mt10xDao.findAll());
		return ret;
	}

	@GET
	@Path("/banke")
	@Produces(MediaType.APPLICATION_JSON)
	public BankaWrapper banke() {
		BankaWrapper ret = new BankaWrapper();
		/*
		 * Banka banka = new Banka(); ArrayList<Banka> list = new
		 * ArrayList<Banka>(); banka.setNaziv("Bleja"); banka.setSifra(123);
		 * RacunBanke racun = new RacunBanke();
		 * racun.setBrojRacuna("111-1111111111111-11");
		 * banka.addRacunBanke(racun); list.add(banka);
		 * ret.setWrappedParameter(list);
		 */
		ret.setWrappedParameter(bankaDao.findAll());
		return ret;
	}
	
	@GET
	@Path("/dnevnaStanjaRacuna")
	@Produces(MediaType.APPLICATION_JSON)
	public DnevnoStanjeRacunaWrapper dnevnaStanjaRacuna() {
		DnevnoStanjeRacunaWrapper ret = new DnevnoStanjeRacunaWrapper();
		/*
		 * Banka banka = new Banka(); ArrayList<Banka> list = new
		 * ArrayList<Banka>(); banka.setNaziv("Bleja"); banka.setSifra(123);
		 * RacunBanke racun = new RacunBanke();
		 * racun.setBrojRacuna("111-1111111111111-11");
		 * banka.addRacunBanke(racun); list.add(banka);
		 * ret.setWrappedParameter(list);
		 */
		ret.setWrappedParameter(dnevnoStanjeRacunaDao.findAll());
		return ret;
	}
	
	@GET
	@Path("/drzave")
	@Produces(MediaType.APPLICATION_JSON)
	public DrzavaWrapper drzave() {
		DrzavaWrapper ret = new DrzavaWrapper();
		/*
		 * Banka banka = new Banka(); ArrayList<Banka> list = new
		 * ArrayList<Banka>(); banka.setNaziv("Bleja"); banka.setSifra(123);
		 * RacunBanke racun = new RacunBanke();
		 * racun.setBrojRacuna("111-1111111111111-11");
		 * banka.addRacunBanke(racun); list.add(banka);
		 * ret.setWrappedParameter(list);
		 */
		
		ret.setWrappedElement(drzavaDao.findAll());
		return ret;
	}
	
	@GET
	@Path("/nalozi")
	@Produces(MediaType.APPLICATION_JSON)
	public NalogWrapper nalozi() {
		NalogWrapper ret = new NalogWrapper();
		/*
		 * Banka banka = new Banka(); ArrayList<Banka> list = new
		 * ArrayList<Banka>(); banka.setNaziv("Bleja"); banka.setSifra(123);
		 * RacunBanke racun = new RacunBanke();
		 * racun.setBrojRacuna("111-1111111111111-11");
		 * banka.addRacunBanke(racun); list.add(banka);
		 * ret.setWrappedParameter(list);
		 */
		
		ret.setWrappedElement(nalogDao.findAll());
		return ret;
	}
	
	@GET
	@Path("/naseljenaMesta")
	@Produces(MediaType.APPLICATION_JSON)
	public NaseljenoMestoWrapper naseljenaMesta() {
		NaseljenoMestoWrapper ret = new NaseljenoMestoWrapper();
		/*
		 * Banka banka = new Banka(); ArrayList<Banka> list = new
		 * ArrayList<Banka>(); banka.setNaziv("Bleja"); banka.setSifra(123);
		 * RacunBanke racun = new RacunBanke();
		 * racun.setBrojRacuna("111-1111111111111-11");
		 * banka.addRacunBanke(racun); list.add(banka);
		 * ret.setWrappedParameter(list);
		 */
		
		ret.setWrappedElement(naseljenoMestoDao.findAll());
		return ret;
	}
	
	@GET
	@Path("/racuniBanaka")
	@Produces(MediaType.APPLICATION_JSON)
	public RacunBankeWrapper racuniBanaka() {
		RacunBankeWrapper ret = new RacunBankeWrapper();
		/*
		 * Banka banka = new Banka(); ArrayList<Banka> list = new
		 * ArrayList<Banka>(); banka.setNaziv("Bleja"); banka.setSifra(123);
		 * RacunBanke racun = new RacunBanke();
		 * racun.setBrojRacuna("111-1111111111111-11");
		 * banka.addRacunBanke(racun); list.add(banka);
		 * ret.setWrappedParameter(list);
		 */
		
		ret.setWrappedElement(racunDao.findAll());
		return ret;
	}
	
	@GET
	@Path("/stavkeDnevnogRacuna")
	@Produces(MediaType.APPLICATION_JSON)
	public StavkaDnevnogRacunaWrapper stavkeDnevnogRacuna() {
		StavkaDnevnogRacunaWrapper ret = new StavkaDnevnogRacunaWrapper();
		/*
		 * Banka banka = new Banka(); ArrayList<Banka> list = new
		 * ArrayList<Banka>(); banka.setNaziv("Bleja"); banka.setSifra(123);
		 * RacunBanke racun = new RacunBanke();
		 * racun.setBrojRacuna("111-1111111111111-11");
		 * banka.addRacunBanke(racun); list.add(banka);
		 * ret.setWrappedParameter(list);
		 */
		
		ret.setWrappedElement(stavkaDnevnogRacunaDao.findAll());
		return ret;
	}
	
	@GET
	@Path("/stavkePoruka")
	@Produces(MediaType.APPLICATION_JSON)
	public StavkaPorukeWrapper stavkePoruka() {
		StavkaPorukeWrapper ret = new StavkaPorukeWrapper();
		/*
		 * Banka banka = new Banka(); ArrayList<Banka> list = new
		 * ArrayList<Banka>(); banka.setNaziv("Bleja"); banka.setSifra(123);
		 * RacunBanke racun = new RacunBanke();
		 * racun.setBrojRacuna("111-1111111111111-11");
		 * banka.addRacunBanke(racun); list.add(banka);
		 * ret.setWrappedParameter(list);
		 */
		
		ret.setWrappedElement(stavkaPorukeDao.findAll());
		return ret;
	}
	

	@POST
	@Path("/{id}/banke")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addBanka(@PathParam("id") String id, BankaWrapper banka) {
		System.out.println(banka);
	}
}
