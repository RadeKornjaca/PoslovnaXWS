package sessionbeans.concrete;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

import poslovnaxws.banke.Preseci;
import sessionbeans.common.GenericDaoLocal;

public interface PreseciDaoLocal extends GenericDaoLocal<Preseci, String> {
	public List<Preseci> findAllById(String id) throws IOException, JAXBException;
}
