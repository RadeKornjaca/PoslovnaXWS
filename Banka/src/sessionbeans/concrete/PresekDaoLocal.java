package sessionbeans.concrete;

import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;

import poslovnaxws.banke.Presek;
import poslovnaxws.services.banka.NotificationMessage;
import sessionbeans.common.GenericDaoLocal;

public interface PresekDaoLocal extends GenericDaoLocal<Presek, String>{

	public Presek getPresek(XMLGregorianCalendar datum, String brojRacuna, int redniBroj) throws NotificationMessage;
	
}
