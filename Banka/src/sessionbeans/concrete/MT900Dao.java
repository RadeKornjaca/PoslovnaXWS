package sessionbeans.concrete;

import javax.ejb.Local;
import javax.ejb.Stateless;

import poslovnaxws.poruke.Poruka;
import sessionbeans.common.GenericDao;

@Stateless
@Local(MT900DaoLocal.class)
public class MT900Dao extends GenericDao<Poruka, Long> implements
		MT900DaoLocal {

	public static final String contextPath = "poslovnaxws.poruke";

	public static final String schemaName = "mt900";

	public MT900Dao() {
		super(contextPath, schemaName);
	}

}
