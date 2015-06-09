package session.dao;

import java.util.Date;

import entity.DnevnoStanjeRacuna;

public interface DnevnoStanjeRacunaDaoLocal extends GenericDaoLocal<DnevnoStanjeRacuna, Integer>{
	public DnevnoStanjeRacuna findDnevnoStanjeRacuna(Date datum);
}
