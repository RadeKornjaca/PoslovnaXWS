package session.dao;

import java.util.List;

import entity.DnevnoStanjeRacuna;

public interface DnevnoStanjeRacunaDaoLocal extends GenericDaoLocal<DnevnoStanjeRacuna, Integer>{
	public List<DnevnoStanjeRacuna> findDnevnoStanjeRacuna(String datum, long id);
	public DnevnoStanjeRacuna getAllCollections(long id);
}
