package session.dao;

import entity.Drzava;

public interface DrzavaDaoLocal extends GenericDaoLocal<Drzava, Integer>{
	
	public Drzava findDrzava(String naziv);

}
