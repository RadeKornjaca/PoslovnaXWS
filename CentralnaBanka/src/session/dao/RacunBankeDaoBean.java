package session.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import entity.RacunBanke;

@Stateless
@Local(RacunBankeDaoLocal.class)
public class RacunBankeDaoBean extends GenericDaoBean<RacunBanke, Integer> implements RacunBankeDaoLocal{

	@Override
	public RacunBanke findByBrojRacuna(String brojRacuna) {
		Query q = em.createNamedQuery("findByBrojRacuna");
		q.setParameter("brojRacuna", brojRacuna);
		RacunBanke racunBanke = (RacunBanke) q.getSingleResult();
		
		return racunBanke;
	}

	@Override
	public RacunBanke getAllCollections(int id) {
		RacunBanke racunBanke = findById(id);
		racunBanke.getDnevnoStanjeRacuna();
		
		return racunBanke;
	}

}
