package session.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;
import entity.RacunBanke;

@Stateless
@Local(RacunBankeDaoLocal.class)
public class RacunBankeDaoBean extends GenericDaoBean<RacunBanke, Integer> implements RacunBankeDaoLocal{

}
