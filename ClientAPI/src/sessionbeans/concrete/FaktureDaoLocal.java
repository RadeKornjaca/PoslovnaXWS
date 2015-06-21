package sessionbeans.concrete;

import java.io.IOException;
import javax.xml.bind.JAXBException;

import entity.fakture.Fakture;
import sessionbeans.common.GenericDaoLocal;

public interface FaktureDaoLocal extends GenericDaoLocal<Fakture, Long> {

	public Fakture findAllById(String id) throws IOException, JAXBException;
}
