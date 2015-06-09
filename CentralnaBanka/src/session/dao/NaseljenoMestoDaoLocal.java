package session.dao;

import entity.NaseljenoMesto;

public interface NaseljenoMestoDaoLocal extends GenericDaoLocal<NaseljenoMesto, Integer>{
	
	public NaseljenoMesto findNaseljenoMesto(String nazivMesta);

}
