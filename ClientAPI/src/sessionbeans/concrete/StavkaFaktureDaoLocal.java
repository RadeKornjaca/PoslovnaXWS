package sessionbeans.concrete;

import java.math.BigInteger;
import entity.fakture.StavkaFakture;
import sessionbeans.common.GenericDaoLocal;

public interface StavkaFaktureDaoLocal extends
		GenericDaoLocal<StavkaFakture, Long> {

	public StavkaFakture findByIdInFaktura(String idDobavljaca, Long idFakture, BigInteger redBr); 
	
}
