package sessionbeans.concrete;

import javax.ejb.Local;
import javax.ejb.Stateless;

import poslovnaxws.poruke.MT102;
import sessionbeans.common.GenericDao;

@Stateless
@Local(MT102DaoLocal.class)
public class MT102Dao extends GenericDao<MT102, Long> implements
		MT102DaoLocal {

	public static final String contextPath = "poslovnaxws.poruke";

	public static final String schemaName = "mt102";

	public MT102Dao() {
		super(contextPath, schemaName);
	}

}
