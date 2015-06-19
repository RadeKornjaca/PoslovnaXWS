package poslovnaxws.test;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import poslovnaxws.common.Status;
import poslovnaxws.poruke.MT103;
import poslovnaxws.services.centralnabanka.CentralnaBanka;

public class RTGSTest {

	public static QName serviceName;
	public static QName portName;
	public static Service service;
	public static CentralnaBanka banka;

	public static void main(String[] args) throws ParseException{
		URL wsdl;
		try {
			wsdl = new URL(
					"http://localhost:8080/CentralnaBanka/services/CBService?wsdl");
			serviceName = new QName("PoslovnaXWS/services/centralnaBanka",
					"CBService");
			portName = new QName("PoslovnaXWS/services/centralnaBanka",
					"CentralnaBankaPort");

			service = Service.create(wsdl, serviceName);

			banka = service.getPort(portName, CentralnaBanka.class);

			sendMT103();

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("smara u mainu");
		}
	}

	private static void sendMT103() {
		// TODO Auto-generated method stub
		JAXBContext context;
		MT103 mt103 = new MT103();
		try {
			context = JAXBContext.newInstance("poslovnaxws.poruke");
			Unmarshaller unmarshaller = context.createUnmarshaller();

			 mt103 = (MT103) unmarshaller.unmarshal(new File(
					"E:/Za faks/XML TESTOVI/testMT103Valid.xml"));

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Smara");
		}

		Status response = banka.receiveMT103(mt103);
		System.out.println("response code: " + response.getKod());
		System.out.println("response: " + response.getOpis());
		
	}

}
