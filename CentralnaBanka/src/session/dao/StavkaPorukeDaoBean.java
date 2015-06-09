package session.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;

import entity.StavkaPoruke;

@Stateless
@Local(StavkaPorukeDaoLocal.class)
public class StavkaPorukeDaoBean extends GenericDaoBean<StavkaPoruke, Integer> implements StavkaPorukeDaoLocal{

}
