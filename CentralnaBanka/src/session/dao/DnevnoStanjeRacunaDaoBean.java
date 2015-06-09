package session.dao;

import java.util.Date;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import entity.DnevnoStanjeRacuna;

@Stateless
@Local(DnevnoStanjeRacunaDaoLocal.class)
public class DnevnoStanjeRacunaDaoBean extends GenericDaoBean<DnevnoStanjeRacuna, Integer> implements DnevnoStanjeRacunaDaoLocal{

	@Override
	public DnevnoStanjeRacuna findDnevnoStanjeRacuna(Date datum) {
		Query q = em.createNamedQuery("findDnevnoStanjeRacuna");
		q.setParameter("datum", datum);
		DnevnoStanjeRacuna dnevnoStanjeRacuna = (DnevnoStanjeRacuna) q.getSingleResult();
		
		return dnevnoStanjeRacuna;
	}

}
