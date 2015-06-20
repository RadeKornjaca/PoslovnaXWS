package poslovnaxws.test;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import poslovnaxws.common.StatusWrapper;
import poslovnaxws.common.TBanka;
import poslovnaxws.common.TNalog;
import poslovnaxws.poruke.MT102;
import poslovnaxws.poruke.MT102.Uplate;
import poslovnaxws.poruke.MT102Wrapper;
import poslovnaxws.services.centralnabanka.CBClearing;

public class CopyOfMT102Test {

	public static QName serviceName;
	public static QName portName;
	public static Service service;
	public static CBClearing banka;

	public static void main(String[] args) throws JAXBException {
		URL wsdl;
		try {
			wsdl = new URL(
					"http://localhost:8080/CentralnaBanka/services/CBClearing?wsdl");

			serviceName = new QName("PoslovnaXWS/services/centralnaBanka",
					"CBService");
			portName = new QName("PoslovnaXWS/services/centralnaBanka",
					"CBClearingPort");

			service = Service.create(wsdl, serviceName);

			banka = service.getPort(portName, CBClearing.class);

			testValidClearing();

			testInvalid();

		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	private static void testValidClearing() throws JAXBException {

		File file = new File("C:/Users/Lazar/Desktop/Faks/test.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(MT102.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		MT102 message = (MT102) jaxbUnmarshaller.unmarshal(file);

		MT102Wrapper wrapper = new MT102Wrapper();

		wrapper.setWrappedParameter(message);

		StatusWrapper response = banka.receiveMT102Clearing(wrapper);
		System.out.println("response: "
				+ +response.getWrappedParameter().getKod() + ":"
				+ response.getWrappedParameter().getOpis());

	}

	private static void testInvalid() throws JAXBException {

		File file = new File("C:/Users/Lazar/Desktop/Faks/test.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(MT102.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		MT102 message = (MT102) jaxbUnmarshaller.unmarshal(file);
		
		message.getBankaDuznik().setRacun("123-123-12312-3123-123-123");

		MT102Wrapper wrapper = new MT102Wrapper();

		wrapper.setWrappedParameter(message);

		StatusWrapper response = banka.receiveMT102Clearing(wrapper);
		System.out.println("response: "
				+ +response.getWrappedParameter().getKod() + ":"
				+ response.getWrappedParameter().getOpis());

	}

}
