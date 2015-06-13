package session.dao;

import java.util.List;

import entity.Nalog;

public interface NalogDaoLocal extends GenericDaoLocal<Nalog, Integer>{
	public List<Nalog> executeProcedure();
}
