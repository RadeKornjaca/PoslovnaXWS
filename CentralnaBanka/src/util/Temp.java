package util;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import poslovnaxws.banke.NotificationMessage;
import poslovnaxws.banke.Presek;
import poslovnaxws.banke.ZahtevZaIzvod;
import poslovnaxws.poruke.MT102;
import poslovnaxws.poruke.MT103;
import poslovnaxws.poruke.MT900;
import poslovnaxws.poruke.MT910;
import poslovnaxws.services.banka.BankaServiceMessages;

public class Temp {
	
	public static String BANKA_WSDL = "http://localhost:8080/banka/services/banka?wsdl";

	public static BankaServiceMessages createBankaService(String url) {
		URL wsdl;
		try {
			wsdl = new URL(url);
			
			QName serviceName = new QName("PoslovnaXWS/services/banka",
					"BankaService");
			QName portName = new QName("PoslovnaXWS/services/banka",
					"BankaServicePort");
			
			Service service = Service.create(wsdl, serviceName);
			
			return service.getPort(portName, BankaServiceMessages.class);

		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		
		return null;

	}

	public static void sendMT900(MT900 message, String url) {
		
		BankaServiceMessages banka = createBankaService(url);
		
		banka.receiveMT900(message);
	}
	
	public static void sendMT910(MT910 message, String url) {
		
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
	}

}
