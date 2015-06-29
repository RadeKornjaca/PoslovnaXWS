package poslovnaxws.test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import poslovnaxws.banke.Presek;
import poslovnaxws.services.banka.BankaServiceMessages;
import poslovnaxws.services.banka.NotificationMessage;
import sessionbeans.concrete.PresekDao;

public class PribavljanjePresekaSaRednimBrojemZaRacun {
	
	public static QName serviceName;
	public static QName portName;
	public static Service service;
	public static BankaServiceMessages banka;
	
	public static void main(String[] args) {
		/*URL wsdl;
		try {
			wsdl = new URL("http://localhost:8080/banka/services/banka?wsdl");
			serviceName = new QName("PoslovnaXWS/services/banka", "BankaService");
			portName = new QName("PoslovnaXWS/services/banka", "BankaServicePort");

			service = Service.create(wsdl, serviceName);

			banka = service.getPort(portName, BankaServiceMessages.class);
			
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2015);
		cal.set(Calendar.MONTH, 5);
		cal.set(Calendar.DAY_OF_MONTH,21);
		//cal.set(2015, 6, 21);
		Date datum = cal.getTime();
		System.out.println(datum.toString());
		PresekDao presek = new PresekDao();
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(datum);
		
		XMLGregorianCalendar xmlDatum;
		try {
			xmlDatum = DatatypeFactory.newInstance()
			        .newXMLGregorianCalendar(
			                gc);
			Presek p;
			try {
				p = presek.getPresek(xmlDatum, "111-1111111111111-11", 1);
				System.out.println(p.getStavkePreseka().getStavka().get(0).getDuznik().getNaziv());
			} catch (NotificationMessage e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
