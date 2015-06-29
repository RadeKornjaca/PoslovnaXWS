package sessionbeans.concrete;

import javax.ejb.Local;
import javax.ejb.Stateless;

import poslovnaxws.banke.RacunBanke;
import sessionbeans.common.GenericDao;

@Stateless
@Local(RacunBankeDaoLocal.class)
public class RacunBankeDao extends GenericDao<RacunBanke, String> implements RacunBankeDaoLocal{

	public static final String contextPath = "poslovnaxws.banke";

	public static final String schemaName = "racuniBanke";
	
	public RacunBankeDao() {
		super(contextPath, schemaName);
	}

}
