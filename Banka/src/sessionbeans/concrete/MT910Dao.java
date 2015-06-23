package sessionbeans.concrete;

import javax.ejb.Local;
import javax.ejb.Stateless;

import poslovnaxws.poruke.Poruka;
import sessionbeans.common.GenericDao;

@Stateless
@Local(MT910DaoLocal.class)
public class MT910Dao extends GenericDao<Poruka, Long> implements
		MT910DaoLocal {

	public static final String contextPath = "poslovnaxws.poruke";

	public static final String schemaName = "mt910";

	public MT910Dao() {
		super(contextPath, schemaName);
	}

}
