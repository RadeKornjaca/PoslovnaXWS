package session.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;

import entity.Mt10x;

@Stateless
@Local(Mt10xDaoLocal.class)
public class Mt10xDaoBean extends GenericDaoBean<Mt10x, Integer> implements Mt10xDaoLocal{
	
	@Override
	public Mt10x getAllCollections(long id) {
		Mt10x mt10x = em.find(Mt10x.class, id);
		mt10x.getStavkaPoruke().size();
		//mt10x.getMt9xy().size();
		return mt10x;
	}

}
