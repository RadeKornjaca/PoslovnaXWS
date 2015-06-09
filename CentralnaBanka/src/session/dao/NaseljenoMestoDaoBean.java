package session.dao;

import javax.persistence.Query;

import entity.NaseljenoMesto;

public class NaseljenoMestoDaoBean extends GenericDaoBean<NaseljenoMesto, Integer> implements NaseljenoMestoDaoLocal{

	@Override
	public NaseljenoMesto findNaseljenoMesto(String nazivMesta) {
		Query q = em.createNamedQuery("findNaseljenoMesto");
		q.setParameter("naziv", nazivMesta);
		NaseljenoMesto naseljenoMesto = (NaseljenoMesto) q.getSingleResult();
		
		return naseljenoMesto;
	}

}
