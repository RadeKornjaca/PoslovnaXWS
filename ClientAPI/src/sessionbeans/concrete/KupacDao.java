package sessionbeans.concrete;

import javax.ejb.Local;
import javax.ejb.Stateless;

import sessionbeans.common.GenericDao;
import entity.kupac.Kupac;

@Stateless
@Local(KupacDaoLocal.class)
public class KupacDao extends GenericDao<Kupac, Long> implements KupacDaoLocal {

	public static final String contextPath = "entity.kupac";
	
	public static final String schemaName = "vlasnik";
	
	public KupacDao() {
		super(contextPath, schemaName);
	}

}
