package sessionbeans.concrete;

import sessionbeans.common.GenericDaoLocal;
import entity.fakture.Faktura;

public interface FakturaDaoLocal extends GenericDaoLocal<Faktura, Long> {
	
	public Faktura findFakturaById(String idDobavljaca, Long idFakture);
}
