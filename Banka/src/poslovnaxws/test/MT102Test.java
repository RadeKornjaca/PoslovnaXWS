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

import poslovnaxws.banke.ZahtevZaIzvod;
import poslovnaxws.common.NalogWrapper;
import poslovnaxws.common.Status;
import poslovnaxws.common.StatusWrapper;
import poslovnaxws.common.TBanka;
import poslovnaxws.common.TNalog;
import poslovnaxws.poruke.MT102;
import poslovnaxws.poruke.MT102.Uplate;
import poslovnaxws.poruke.MT102Wrapper;
import poslovnaxws.services.banka.BankaServiceMessages;
import poslovnaxws.services.banka.NotificationMessage;

public class MT102Test {

	public static QName serviceName;
	public static QName portName;
	public static Service service;
	public static BankaServiceMessages banka;

	public static void main(String[] args) {
		URL wsdl;
		try {
			wsdl = new URL(
					"http://localhost:8080/banka/services/BankaService?wsdl");

			serviceName = new QName("PoslovnaXWS/services/banka",
					"BankaService");
			portName = new QName("PoslovnaXWS/services/banka",
					"BankaServicePort");

			service = Service.create(wsdl, serviceName);

			banka = service.getPort(portName, BankaServiceMessages.class);

			testValid();

			// testInvalid();

		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	private static void testValid() {

		MT102 message = new MT102();

		TBanka duznik = new TBanka();
		duznik.setModel(new BigInteger("97"));
		duznik.setNaziv("Duznik");
		duznik.setPozivNaBroj("asdasgh");
		duznik.setRacun("111-1111111111111-11");
		duznik.setSwiftKod("BANKAS12");

		TBanka poverioc = new TBanka();
		poverioc.setModel(new BigInteger("97"));
		poverioc.setNaziv("Poverioc");
		poverioc.setPozivNaBroj("asdasgh");
		poverioc.setRacun("111-1111111111111-11");
		poverioc.setSwiftKod("BANKAS34");

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
		BigDecimal ukupanIznos = new BigDecimal(1235.24);
		ukupanIznos = ukupanIznos.setScale(2, RoundingMode.CEILING);
		message.setUkupanIznos(ukupanIznos);

		Uplate uplate = new Uplate();

		nalog.setDuznik(duznik);
		nalog.setPrimalac(poverioc);
		nalog.setHitno(false);
		nalog.setId("111");
		nalog.setIznos(ukupanIznos);
		nalog.setOznakaValute("RSD");
		nalog.setSvrhaPlacanja("Uplata silnih novaca.");

		uplate.getUplata().add(nalog);

		message.setUplate(uplate);
		MT102Wrapper wrapper = new MT102Wrapper();
		wrapper.setWrappedParameter(message);
		StatusWrapper response = banka.receiveMT102(wrapper);

		System.out.println("response: " + response.getWrappedParameter());

	}

	private static void testInvalid() {

		MT102 message = new MT102();

		TBanka duznik = new TBanka();
		duznik.setModel(new BigInteger("97"));
		duznik.setNaziv("Duznik");
		duznik.setPozivNaBroj("asdasgh");
		duznik.setRacun("111-11111111111111111111111111111111-11");
		duznik.setSwiftKod("123");

		TBanka poverioc = new TBanka();
		duznik.setModel(new BigInteger("97"));
		duznik.setNaziv("Poverioc");
		duznik.setPozivNaBroj("asdasgh");
		duznik.setRacun("111-11111111111111111111111111111111-11");
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
		MT102Wrapper wrapper = new MT102Wrapper();
		wrapper.setWrappedParameter(message);
		StatusWrapper response = banka.receiveMT102(wrapper);
		
		System.out.println("response: " + response.getWrappedParameter());

	}

	private void testZahtev() {
		ZahtevZaIzvod zahtev = new ZahtevZaIzvod();

		zahtev.setBrojRacuna("111111111111111111");
		zahtev.setRedniBrojPreseka(new BigInteger("1"));

		GregorianCalendar datumTemp = new GregorianCalendar();
		datumTemp.setTime(new Date());
		XMLGregorianCalendar datum;
		try {
			datum = DatatypeFactory.newInstance().newXMLGregorianCalendar(
					datumTemp);

			zahtev.setDatum(datum);

		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}

		try {
			banka.zahtevZaIzvod(new NalogWrapper());
		} catch (NotificationMessage e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
