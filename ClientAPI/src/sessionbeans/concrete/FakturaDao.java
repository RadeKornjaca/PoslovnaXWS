package sessionbeans.concrete;

import javax.ejb.Local;
import javax.ejb.Stateless;

import sessionbeans.common.GenericDao;
import entity.fakture.Faktura;

@Stateless
@Local(FakturaDaoLocal.class)
public class FakturaDao extends GenericDao<Faktura, Long> implements
		FakturaDaoLocal {

	public static final String contextPath = "entity.fakture";
	
	public static final String schemaName = "fakture";
	
	
	public FakturaDao() {
		super(contextPath, schemaName);
	}

}
