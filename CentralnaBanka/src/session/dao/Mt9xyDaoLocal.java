package session.dao;

import entity.Mt10x;
import entity.Mt9xy;

public interface Mt9xyDaoLocal extends GenericDaoLocal<Mt9xy, Integer>{

	public Mt10x getAllCollections(long id);
	
}
