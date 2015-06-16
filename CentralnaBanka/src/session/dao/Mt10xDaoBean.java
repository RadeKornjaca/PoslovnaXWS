package session.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import entity.Mt10x;
import entity.Poruka;

@Stateless
@Local(Mt10xDaoLocal.class)
public class Mt10xDaoBean extends GenericDaoBean<Mt10x, Integer> implements Mt10xDaoLocal{

	@Override
	public List<Mt10x> findAllMT102() {
		Query q = em.createQuery("SELECT x FROM Poruka x WHERE x.vrsta = '" + Poruka.Vrsta.MT102+"'");
		List<Mt10x> result = q.getResultList();
		return result;
	}

	@Override
	public List<Mt10x> findAllMT103() {
		Query q = em.createQuery("SELECT x FROM Poruka x WHERE x.vrsta = '" + Poruka.Vrsta.MT103 + "'");
		List<Mt10x> result = q.getResultList();
		return result;
	}

}
