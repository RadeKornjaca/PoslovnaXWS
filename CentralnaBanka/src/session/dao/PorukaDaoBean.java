package session.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;
import entity.Poruka;

@Stateless
@Local(PorukaDaoLocal.class)
public class PorukaDaoBean extends GenericDaoBean<Poruka, Integer> implements PorukaDaoLocal{

}
