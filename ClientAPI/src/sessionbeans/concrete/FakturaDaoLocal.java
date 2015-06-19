package sessionbeans.concrete;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

import sessionbeans.common.GenericDaoLocal;
import entity.fakture.Faktura;

public interface FakturaDaoLocal extends GenericDaoLocal<Faktura, Long> {
	
	public List<Faktura> findAllById(String id) throws IOException, JAXBException;
	public Faktura findFakturaById(String idDobavljaca, Long idFakture);
}
