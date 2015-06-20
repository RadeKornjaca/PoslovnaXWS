package poslovnaxws.test;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import poslovnaxws.poruke.MT103;
import poslovnaxws.poruke.MT103Wrapper;
import poslovnaxws.services.centralnabanka.CBClearing;

public class Temp {
	
	public static String BANKA_WSDL = "http://localhost:8080/CentralnaBanka/services/CBClearing?wsdl";

	public static CBClearing createBankaService() {
		URL wsdl;
		try {
			wsdl = new URL(
					"http://localhost:8080/CentralnaBanka/services/CBClearing?wsdl");

			QName serviceName = new QName("PoslovnaXWS/services/centralnaBanka",
					"CBService");
			QName portName = new QName("PoslovnaXWS/services/centralnaBanka",
					"CBClearingPort");
			
			Service service = Service.create(wsdl, serviceName);
			
			return service.getPort(portName, CBClearing.class);

		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		
		return null;

	}

	public static void sendMT103(MT103 message) {
		
		CBClearing banka = createBankaService();
		MT103Wrapper wrapper = new MT103Wrapper();
		wrapper.setWrappedParameter(message);
		banka.receiveMT103Clearing(wrapper);
	}
	
	/*public static void sendMT910(MT910 message, String url) {
		
		BankaServiceMessages banka = createBankaService(url);
		
		banka.receiveMT910(message);
	}
	
	public static void sendMT102(MT102 message, String url) {
		
		BankaServiceMessages banka = createBankaService(url);
		
		banka.receiveMT102(message);
	}
	
	public static void sendMT103(MT103 message, String url) {
		
		BankaServiceMessages banka = createBankaService(url);
		
		banka.receiveMT103(message);
	}
	
	public static Presek getPresek(ZahtevZaIzvod zahtevZaIzvod, String url) {
		
		BankaServiceMessages banka = createBankaService(url);
		
		try {
			return banka.zahtevZaIzvod(zahtevZaIzvod);
		} catch (NotificationMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		sendMT900(new MT900(), BANKA_WSDL);
		sendMT910(new MT910(), BANKA_WSDL);
		
		Presek presek = getPresek(new ZahtevZaIzvod(), BANKA_WSDL);
		System.out.println(presek);
	}*/

}
