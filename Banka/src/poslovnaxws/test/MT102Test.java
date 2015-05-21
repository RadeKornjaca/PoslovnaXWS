package poslovnaxws.test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import poslovnaxws.common.Status;
import poslovnaxws.common.TBanka;
import poslovnaxws.common.TNalog;
import poslovnaxws.poruke.MT102;
import poslovnaxws.poruke.MT102.Uplate;
import poslovnaxws.services.banka.BankaServiceMessages;

public class MT102Test {

	public static void main(String[] args) {
		URL wsdl;
		try {
			wsdl = new URL(
					"http://localhost:8080/banka/services/BankaService?wsdl");

			QName serviceName = new QName("PoslovnaXWS/services/banka",
					"BankaService");
			QName portName = new QName("PoslovnaXWS/services/banka",
					"BankaServicePort");

			Service service = Service.create(wsdl, serviceName);

			BankaServiceMessages banka = service
					.getPort(portName, BankaServiceMessages.class);

			MT102 message = new MT102();

			TBanka duznik = new TBanka();
			duznik.setModel(new BigInteger("97"));
			duznik.setNaziv("Duznik");
			duznik.setPozivNaBroj("asdasgh");
			duznik.setRacun("1111111111111");
			duznik.setSwiftKod("123");

			TBanka poverioc = new TBanka();
			duznik.setModel(new BigInteger("97"));
			duznik.setNaziv("Poverioc");
			duznik.setPozivNaBroj("asdasgh");
			duznik.setRacun("2222222222222");
			duznik.setSwiftKod("345");

			message.setBankaDuznik(duznik);
			message.setBankaPoverioc(poverioc);

			TNalog nalog = new TNalog();

			GregorianCalendar datumTemp = new GregorianCalendar();
			datumTemp.setTime(new Date());
			XMLGregorianCalendar datum;
			try {
				datum = DatatypeFactory.newInstance().newXMLGregorianCalendar(
						datumTemp);

				message.setDatum(datum);
				message.setDatumValute(datum);

				nalog.setDatumNaloga(datum);
				nalog.setDatumValute(datum);

			} catch (DatatypeConfigurationException e) {
				e.printStackTrace();
			}

			message.setId("123");
			message.setSifraValute("RSD");
			message.setUkupanIznos(new BigDecimal(1235.24));

			Uplate uplate = new Uplate();

			nalog.setDuznik(duznik);
			nalog.setPrimalac(poverioc);
			nalog.setHitno(false);
			nalog.setId("111");
			nalog.setIznos(new BigDecimal(1235.24));
			nalog.setOznakaValute("RSD");
			nalog.setSvrhaPlacanja("Uplata silnih novaca.");

			uplate.getUplata().add(nalog);

			message.setUplate(uplate);
			
			Status response = banka.receiveMT102(message);
			System.out.println("response: " + response);

		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
