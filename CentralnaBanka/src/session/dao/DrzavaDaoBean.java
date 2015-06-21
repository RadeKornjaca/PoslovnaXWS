package session.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import entity.Drzava;
@Stateless
@Local(DrzavaDaoLocal.class)
public class DrzavaDaoBean extends GenericDaoBean<Drzava, Integer> implements DrzavaDaoLocal{

	@Override
	public Drzava findDrzava(String naziv) {
		Query q = em.createNamedQuery("findDrzava");
		q.setParameter("naziv", naziv);
		Drzava drzava = (Drzava) q.getSingleResult();
		
		return drzava;
	}

	@Override
	public Drzava loadFully(long id) {
		Drzava drzava = findById((int) id);
		drzava.getNaseljenoMesto().size();
		return drzava;
	}

}
