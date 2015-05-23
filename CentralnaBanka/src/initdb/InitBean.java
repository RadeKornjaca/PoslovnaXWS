package initdb;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Banka;

@Stateless
@Remote(Init.class)
public class InitBean implements Init{

	@PersistenceContext(unitName = "CentralnaBanka")
	EntityManager em;
	
	public void init() {
		// TODO Auto-generated method stub
		Banka banka = new Banka();
		banka.setNaziv("banka");
		banka.setSifra(123);
		banka.setSwiftKod("123");
		em.persist(banka);
	}
	

}
