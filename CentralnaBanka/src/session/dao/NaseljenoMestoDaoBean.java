package session.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import entity.NaseljenoMesto;

@Stateless
@Local(NaseljenoMestoDaoLocal.class)
public class NaseljenoMestoDaoBean extends GenericDaoBean<NaseljenoMesto, Integer> implements NaseljenoMestoDaoLocal{

	@Override
	public NaseljenoMesto findNaseljenoMesto(String nazivMesta) {
		Query q = em.createNamedQuery("findNaseljenoMesto");
		q.setParameter("naziv", nazivMesta);
		NaseljenoMesto naseljenoMesto = (NaseljenoMesto) q.getSingleResult();
		
		return naseljenoMesto;
	}

}
