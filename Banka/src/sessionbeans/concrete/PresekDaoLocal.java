package sessionbeans.concrete;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

import poslovnaxws.banke.Presek;
import poslovnaxws.common.TNalog;
import sessionbeans.common.GenericDaoLocal;

public interface PresekDaoLocal extends GenericDaoLocal<Presek, String> {
	public List<Presek> findAllById(String id) throws IOException, JAXBException;
}
