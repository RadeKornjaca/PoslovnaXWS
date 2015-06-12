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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Banka> executeProcedure() {
		System.out.println("Usao u executeProcedure()");
		try {
			Query q = em.createNativeQuery("CALL getBanke(?);", Banka.class);
			q.setParameter(1, 123);
			List<Banka> banke= (List<Banka>) q.getResultList();
			System.out.println(banke + "MOJ SYSO --" + banke.get(0));
			int redni = 0;
			for (Banka banka : banke) {
				redni++;
				System.out.println();
				System.out.println(banka.getNaziv());
			}
			return banke;
		} catch (Exception e) {
			System.out.println("FAIL");
			e.printStackTrace();
		}
		return null;
	}

}
