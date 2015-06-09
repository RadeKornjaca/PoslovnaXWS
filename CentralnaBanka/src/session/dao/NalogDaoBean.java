package session.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;

import entity.Nalog;

@Stateless
@Local(NalogDaoLocal.class)
public class NalogDaoBean extends GenericDaoBean<Nalog, Integer> implements NalogDaoLocal{

}
