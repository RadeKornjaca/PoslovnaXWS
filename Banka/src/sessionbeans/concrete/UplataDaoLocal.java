package sessionbeans.concrete;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.xml.bind.JAXBException;

import poslovnaxws.banke.Uplata;
import sessionbeans.common.GenericDaoLocal;

public interface UplataDaoLocal extends GenericDaoLocal<Uplata, Long> {
	/**
	 *  
	 * @return Uplate sa kliringa, po bankama. Kljuc je sifra banke.
	 * @throws IOException
	 * @throws JAXBException
	 */
	public HashMap<String, List<Uplata>> setupClearing() throws IOException, JAXBException;
}
