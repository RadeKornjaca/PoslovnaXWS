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
	public Mt10x getAllCollections(long id) {
		Mt10x mt10x = em.find(Mt10x.class, id);
		if (mt10x == null)
			return null;
		mt10x.getStavkaPoruke().size();
		//mt10x.getMt9xy().size();
		return mt10x;
	}
	
	

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



	@SuppressWarnings("unchecked")
	@Override
	public List<Mt10x> findAllMessagesWithStatus() {
		Query q = em.createNamedQuery("findByMessageStatus");
		q.setParameter("status", 1);
		//Query q = em.createNativeQuery("select * from Mt10x where status_poruke like 1", Mt10x.class);
		List<Mt10x> mt10xs = (List<Mt10x>)q.getResultList();
		return mt10xs;
	}

}
