package session.dao;

import entity.Banka;

public interface BankaDaoLocal extends GenericDaoLocal<Banka, Integer>{
	
	public Banka findBanka(String naziv);

}
