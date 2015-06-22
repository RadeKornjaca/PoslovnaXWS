package poslovnaxws.test;

import java.io.File;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import poslovnaxws.banke.Presek;
import poslovnaxws.banke.Uplata;
import poslovnaxws.banke.ZahtevZaIzvod;
import poslovnaxws.common.Status;
import poslovnaxws.poruke.MT102;
import poslovnaxws.poruke.MT103;
import poslovnaxws.services.banka.BankaServiceMessages;
import poslovnaxws.services.banka.NotificationMessage;

public class MT102Test {

	public static QName serviceName;
	public static QName portName;
	public static Service service;
	public static BankaServiceMessages banka;

	public static void main(String[] args) throws Exception {
		URL wsdl;
		wsdl = new URL("http://localhost:8080/banka/services/banka?wsdl");

		serviceName = new QName("PoslovnaXWS/services/banka", "BankaService");
		portName = new QName("PoslovnaXWS/services/banka", "BankaServicePort");

		service = Service.create(wsdl, serviceName);

		banka = service.getPort(portName, BankaServiceMessages.class);

		// testValid();

		/*
		 * File file = new File("C:/Users/Lazar/Desktop/Faks/mt900.xml");
		 * JAXBContext jaxbContext = JAXBContext.newInstance(MT900.class);
		 * Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		 * MT900 mt900 = (MT900) jaxbUnmarshaller.unmarshal(file);
		 * 
		 * // Status response = banka.receiveMT900(mt900);
		 * 
		 * ZahtevZaIzvod zahtev = new ZahtevZaIzvod();
		 * 
		 * XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance()
		 * .newXMLGregorianCalendarDate(2015, 6, 19,
		 * DatatypeConstants.FIELD_UNDEFINED);
		 * 
		 * zahtev.setDatum(xmlDate);
		 * 
		 * zahtev.setRedniBrojPreseka(new BigInteger("0"));
		 * 
		 * Presek presek = banka.zahtevZaIzvod(zahtev);
		 * 
		 * testValidMT102();
		 * 
		 * testInvalidMT102();
		 */

		 //testValidMT102();

		//testZahtev();

		 testValidUplata();

	}

	private static void testZahtev() {
		ZahtevZaIzvod zahtev = new ZahtevZaIzvod();

		zahtev.setBrojRacuna("111-1111111111111-11");
		zahtev.setRedniBrojPreseka(new BigInteger("1"));

		XMLGregorianCalendar datum;
		try {
			datum = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(
					2015, 6, 21, DatatypeConstants.FIELD_UNDEFINED);

			zahtev.setDatum(datum);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}

		try {
			for (int i = 1;; i++) {
				zahtev.setRedniBrojPreseka(new BigInteger(String.valueOf(i)));
				Presek presek = banka.zahtevZaIzvod(zahtev);
				System.out.println(presek.getZaglavlje().getNovoStanje());
			}
		} catch (NotificationMessage e) {
			System.out.println(e.getMessage());
		}
	}

	private static void testValidMT102() throws JAXBException {

		File file = new File("C:/Users/Lazar/Desktop/Faks/test.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(MT102.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		MT102 message = (MT102) jaxbUnmarshaller.unmarshal(file);
		
		Status response = banka.receiveMT102(message);
		System.out.println("response: " + +response.getKod() + ":"
				+ response.getOpis());

	}

	private static void testInvalidMT102() throws JAXBException {

		File file = new File("C:/Users/Lazar/Desktop/Faks/test.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(MT102.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		MT102 message = (MT102) jaxbUnmarshaller.unmarshal(file);

		message.getBankaDuznik().setRacun("123-123-12312-3123-123-123");

		Status response = banka.receiveMT102(message);
		System.out.println("response: " + +response.getKod() + ":"
				+ response.getOpis());

	}

	private static void testValidUplata() throws JAXBException {

		File file = new File("E:/Za faks/XML TESTOVI/testMT103Valid.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(MT103.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		MT103 message = (MT103) jaxbUnmarshaller.unmarshal(file);
		Uplata uplata = new Uplata();
		uplata.setNalog(message.getUplata());
		Status response = banka.receiveUplata(uplata);
		System.out.println("response: " + +response.getKod() + ":"
				+ response.getOpis());

	}

}
