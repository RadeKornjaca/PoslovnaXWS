package session.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;
import entity.Mt9xy;

@Stateless
@Local(Mt10xDaoLocal.class)
public class Mt9xyDaoBean extends GenericDaoBean<Mt9xy, Integer>{

}
