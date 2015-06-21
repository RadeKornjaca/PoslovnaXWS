package sessionbeans.concrete;

import javax.ejb.Local;
import javax.ejb.Stateless;

import poslovnaxws.poruke.MT103;
import sessionbeans.common.GenericDao;

@Stateless
@Local(MT103DaoLocal.class)
public class MT103Dao extends GenericDao<MT103, Long> implements
		MT103DaoLocal {

	public static final String contextPath = "poslovnaxws.poruke";

	public static final String schemaName = "mt103";

	public MT103Dao() {
		super(contextPath, schemaName);
	}

}
