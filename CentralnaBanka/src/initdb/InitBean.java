package initdb;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Banka;
import entity.Drzava;

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
		
		Drzava drzava = new Drzava();
		
		drzava.setIdDrzave(1);
		drzava.setNazivDrzave("Srbija");
		drzava.setSifraDrzave("SRB");
		em.persist(drzava);
	}
	

}
