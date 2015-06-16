package session.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import entity.Mt9xy;
import entity.Poruka;

@Stateless
@Local(Mt9xyDaoLocal.class)
public class Mt9xyDaoBean extends GenericDaoBean<Mt9xy, Integer> implements Mt9xyDaoLocal{

	@Override
	public List<Mt9xy> findAllMT900() {
		Query q = em.createQuery("SELECT x FROM Poruka x WHERE x.vrsta = '" + Poruka.Vrsta.MT900+"'");
		List<Mt9xy> result = q.getResultList();
		return result;
	}

	@Override
	public List<Mt9xy> findAllMT910() {
		Query q = em.createQuery("SELECT x FROM Poruka x WHERE x.vrsta = '" + Poruka.Vrsta.MT910+"'");
		List<Mt9xy> result = q.getResultList();
		return result;
	}
	

}
