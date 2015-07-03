package session.dao;

import entity.RacunBanke;

public interface RacunBankeDaoLocal extends GenericDaoLocal<RacunBanke, Integer>{
	
	public RacunBanke findByBrojRacuna(String brojRacuna);
	public RacunBanke getAllCollections(int id);
}
