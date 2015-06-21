package sessionbeans.concrete;

import javax.ejb.Local;
import javax.ejb.Stateless;

import sessionbeans.common.GenericDao;
import entity.dobavljac.Dobavljac;

@Stateless
@Local(DobavljacDaoLocal.class)
public class DobavljacDao extends GenericDao<Dobavljac, Long> implements
		DobavljacDaoLocal {

	public static final String contextPath = "entity.dobavljac";
	
	public static final String schemaName = "partneri";
	
	public DobavljacDao() {
		super(contextPath, schemaName);
	}

}
