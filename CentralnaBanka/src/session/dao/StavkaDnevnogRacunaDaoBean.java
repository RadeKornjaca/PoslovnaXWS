package session.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;

import entity.StavkaDnevnogRacuna;

@Stateless
@Local(StavkaDnevnogRacunaDaoLocal.class)
public class StavkaDnevnogRacunaDaoBean extends GenericDaoBean<StavkaDnevnogRacuna, Integer>{

}
