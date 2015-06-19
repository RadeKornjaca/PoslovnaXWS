package session.dao;

import entity.Mt10x;

public interface Mt10xDaoLocal extends GenericDaoLocal<Mt10x, Integer>{

	public Mt10x getAllCollections(long id);
	
}
