package session.dao;

import java.util.List;

import entity.Mt10x;

public interface Mt10xDaoLocal extends GenericDaoLocal<Mt10x, Integer> {

	public List<Mt10x> findAllMT102();

	public List<Mt10x> findAllMT103();

	public Mt10x getAllCollections(long id);
	
	public List<Mt10x> findAllMessagesWithStatus();
	
}
