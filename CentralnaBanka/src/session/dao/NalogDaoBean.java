package session.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import entity.Nalog;

@Stateless
@Local(NalogDaoLocal.class)
public class NalogDaoBean extends GenericDaoBean<Nalog, Integer> implements NalogDaoLocal{

	@SuppressWarnings("unchecked")
	@Override
	public List<Nalog> executeProcedure() {
		System.out.println("Usao u executeProcedure()");
		try {
			Query q = em.createNativeQuery("CALL getForClearing();", Nalog.class);
			q.setParameter(1, 123);
			List<Nalog> nalozi= (List<Nalog>) q.getResultList();
			int redni = 0;
			for (Nalog nalog : nalozi) {
				redni++;
				System.out.println();
				System.out.println(redni + ". nalog iznosa:" + nalog.getIznos() + "i hitno:" + nalog.isHitno());
			}
			return nalozi;
		} catch (Exception e) {
			System.out.println("FAIL");
			e.printStackTrace();
		}
		return null;
	}
	
}
