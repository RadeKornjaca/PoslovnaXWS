package session.dao;

import java.util.List;

import entity.Banka;

public interface BankaDaoLocal extends GenericDaoLocal<Banka, Integer>{
	
	public Banka findBanka(String naziv);
	public List<Banka> executeProcedure();

}
