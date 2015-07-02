package session.dao;

import entity.Banka;
import entity.Drzava;

public interface BankaDaoLocal extends GenericDaoLocal<Banka, Integer>{
	
	public Banka findBanka(String naziv);
	public Banka getAllCollections(long id);;

}
