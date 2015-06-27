package sessionbeans.concrete;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

import poslovnaxws.banke.Preseci;
import poslovnaxws.banke.Presek;
import sessionbeans.common.GenericDaoLocal;

public interface PreseciDaoLocal extends GenericDaoLocal<Preseci, String> {
	public List<Preseci> findAllById(String id) throws IOException, JAXBException;
	
	public Presek getPresek(int index, String id) throws IOException, JAXBException;
}
