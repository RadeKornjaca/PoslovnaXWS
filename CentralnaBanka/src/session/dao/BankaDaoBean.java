package session.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

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

}
