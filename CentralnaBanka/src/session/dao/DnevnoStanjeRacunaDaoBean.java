package session.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import entity.DnevnoStanjeRacuna;

@Stateless
@Local(DnevnoStanjeRacunaDaoLocal.class)
public class DnevnoStanjeRacunaDaoBean extends GenericDaoBean<DnevnoStanjeRacuna, Integer> implements DnevnoStanjeRacunaDaoLocal{

	@SuppressWarnings("unchecked")
	@Override
	public List<DnevnoStanjeRacuna> findDnevnoStanjeRacuna(String datum, long id) {
		Query q = em.createNamedQuery("findDnevnoStanjeRacuna");
		q.setParameter("datum", datum);
		q.setParameter("idRacunaBanke", id);
		List<DnevnoStanjeRacuna> dnevnoStanjeRacuna = (List<DnevnoStanjeRacuna>) q.getResultList();
		
		return dnevnoStanjeRacuna;
	}

	@Override
	public DnevnoStanjeRacuna getAllCollections(long id) {
		DnevnoStanjeRacuna dnevnoStanjeRacuna = em.find(DnevnoStanjeRacuna.class, id);
		dnevnoStanjeRacuna.getStavkaDnevnogRacuna().size();
		return dnevnoStanjeRacuna;
		
	}

}
