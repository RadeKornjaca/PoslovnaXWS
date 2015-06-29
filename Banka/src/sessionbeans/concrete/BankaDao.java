package sessionbeans.concrete;

import javax.ejb.Local;
import javax.ejb.Stateless;

import poslovnaxws.banke.Banka;
import sessionbeans.common.GenericDao;

@Stateless
@Local(BankaDaoLocal.class)
public class BankaDao extends GenericDao<Banka, Long> implements BankaDaoLocal {

	public static final String contextPath = "poslovnaxws.banke";

	public static final String schemaName = "banka";

	public BankaDao() {
		super(contextPath, schemaName);
	}

}
