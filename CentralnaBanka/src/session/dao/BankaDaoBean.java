package session.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import org.omg.CORBA.FREE_MEM;

import entity.Banka;
@Stateless
@Local(BankaDaoLocal.class)
public class BankaDaoBean extends GenericDaoBean<Banka, Integer> implements BankaDaoLocal{

	@Override
	public Banka findBanka(String naziv) {
		Query q = em.createNamedQuery("findBanka");
		q.setParameter("naziv", naziv);
		Banka banka = (Banka) q.getSingleResult();
		
		return banka;
	}

	@Override
	public Banka getAllCollections(long id) {
		Banka banka = em.find(Banka.class, id);
		banka.getRacunBanke().size();
		return banka;
	}
	
	

}
