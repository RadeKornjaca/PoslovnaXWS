package util;

import com.fasterxml.jackson.databind.node.ObjectNode;
/**
 * Interfejs koji entitete prevodi u oblik pogodan za REST.
 * @author Tim 5
 *
 */
public interface Restifyable {
	
	/**
	 * Pretvara entitet u jackson json objekat. Izbacuje reference
	 * i umesto njih stavlja URL odgovarajuceg resursa na REST-u.
	 * @return entitet pretvoren u jackson json objekat.
	 */
	public ObjectNode restify();
	
	public String resourceURL();
	
	public String tableURL();

}
