package sessionbeans.concrete;

import entity.fakture.StavkeFakture;
import sessionbeans.common.GenericDaoLocal;

public interface StavkeDaoLocal extends GenericDaoLocal<StavkeFakture, Long> {
	
	public StavkeFakture findStavkeFakture(String idDobavljaca, Long idFakture);
	
}
