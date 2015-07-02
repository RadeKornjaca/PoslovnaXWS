package poslovnaxws.test;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;

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
import poslovnaxws.services.banka.NotificationMessage;
import poslovnaxws.services.centralnabanka.CentralnaBanka;

public class CBTest {

	public static QName serviceName;
	public static QName portName;
	public static Service service;
	public static CentralnaBanka cb;

	public static void main(String[] args) throws Exception {
		URL wsdl;
		wsdl = new URL("http://192.168.1.4:8080/CentralnaBanka/services/CBService?wsdl");

		serviceName = new QName("PoslovnaXWS/services/centralnaBanka",
				"CBService");
		portName = new QName("PoslovnaXWS/services/centralnaBanka",
				"CentralnaBankaPort");

		service = Service.create(wsdl, serviceName);

		cb = service.getPort(portName, CentralnaBanka.class);

		testValidMT103();
		//testInvalidMT103();
		//testValidMT102();
		//testInvalidIznosMT102();

	}

	private static void testValidMT102() throws JAXBException {

		File file = new File(
				"C:/Users/Lazar/Desktop/Faks/test/testMT102Valid.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(MT102.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		MT102 message = (MT102) jaxbUnmarshaller.unmarshal(file);
		System.out.println(message.getBankaDuznik().getNaziv());
		System.out.println(message.getBankaPoverioc().getNaziv());
		
		System.out.println(message.getUkupanIznos());
		System.out.println(message.getUplate().getUplata().get(0).getIznos());
		
		Status response = cb.receiveMT102(message);
		System.out.println("response: " + +response.getKod() + ":"
				+ response.getOpis());

	}

	private static void testInvalidIznosMT102() throws JAXBException {

		File file = new File(
				"C:/Users/Lazar/Desktop/Faks/test/testMT102Valid.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(MT102.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		MT102 message = (MT102) jaxbUnmarshaller.unmarshal(file);
		System.out.println(message.getBankaDuznik().getNaziv());
		System.out.println(message.getBankaPoverioc().getNaziv());
		message.setUkupanIznos(new BigDecimal("3"));
		Status response = cb.receiveMT102(message);
		System.out.println("response: " + +response.getKod() + ":"
				+ response.getOpis());


	}
	
	private static void testValidMT103() throws JAXBException {

		File file = new File(
				"C:/Users/Lazar/Desktop/Faks/test/uplataPuno.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(MT103.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		MT103 message = (MT103) jaxbUnmarshaller.unmarshal(file);
		System.out.println(message.getBankaDuznik().getNaziv());
		System.out.println(message.getBankaPoverioc().getNaziv());
		message.getUplata().setIznos(new BigDecimal("100000"));
		Status response = cb.receiveMT103(message);
		System.out.println("response: " + +response.getKod() + ":"
				+ response.getOpis());

	}

	private static void testInvalidMT103() throws JAXBException {

		File file = new File(
				"C:/Users/Lazar/Desktop/Faks/test/uplataPuno.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(MT103.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		MT103 message = (MT103) jaxbUnmarshaller.unmarshal(file);
		message.getBankaPoverioc().setSwiftKod("NOPENOPE");
		Status response = cb.receiveMT103(message);
		System.out.println("response: " + +response.getKod() + ":"
				+ response.getOpis());

	}

}
