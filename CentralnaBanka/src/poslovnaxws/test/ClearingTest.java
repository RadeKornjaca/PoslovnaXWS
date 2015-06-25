package poslovnaxws.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import poslovnaxws.common.Status;
import poslovnaxws.services.centralnabanka.CentralnaBanka;

public class ClearingTest {

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
			Status response = banka.doClearing();
			System.out.println("response code: " + response.getKod());
			System.out.println("response: " + response.getOpis());

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("smara u mainu");
		}
	}

}
