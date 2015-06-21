package sessionbeans.concrete;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import sessionbeans.common.GenericDao;
import entity.fakture.Faktura;
import entity.fakture.StavkeFakture;

@Stateless
@Local(StavkeDaoLocal.class)
public class StavkeDao extends GenericDao<StavkeFakture, Long> implements StavkeDaoLocal{


	public static final String contextPath = "entity.fakture";
	
	public static final String schemaName = "stavkeFakture";
	
	@EJB
	private FakturaDaoLocal fakturaDao;
	
	public StavkeDao() {
		super(contextPath, schemaName);
	}

	@Override
	public StavkeFakture findStavkeFakture(String idDobavljaca, Long idFakture) {
		Faktura faktura = fakturaDao.findFakturaById(idDobavljaca, idFakture);
		
		return faktura.getStavkeFakture();
	}
	
	

}
