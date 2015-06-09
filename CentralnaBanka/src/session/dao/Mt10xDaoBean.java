package session.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;
import entity.Mt10x;

@Stateless
@Local(Mt10xDaoLocal.class)
public class Mt10xDaoBean extends GenericDaoBean<Mt10x, Integer> implements Mt10xDaoLocal{

}
