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
import session.dao.DrzavaDaoLocal;
import session.dao.Mt10xDaoLocal;
import util.JndiUtils;
import wrappers.BankaWrapper;
import wrappers.DrzavaWrapper;
import wrappers.MT10xWrapper;
import entity.Mt10x;


public class CBClientService {
	
	/*	@EJB ne radi unutar CXF-a, treba koristiti JNDI lookup
	 *	realizovan u klasi JndiUtils.
	 */

	@EJB
	private BankaDaoLocal bankaDao;
	
	@EJB
	private Mt10xDaoLocal mt10xDao;
	
	@EJB
	private DrzavaDaoLocal drzavaDao  = JndiUtils.getLocalEJB(JndiUtils.DRZAVA_EJB);

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
		poruka2.setSvrhaPlacanja("Novæaniceeeeeee!");
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

	@POST
	@Path("/{id}/banke")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addBanka(@PathParam("id") String id, BankaWrapper banka) {
		System.out.println(banka);
	}
}
