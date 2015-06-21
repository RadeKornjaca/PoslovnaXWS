/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package poslovnaxws.services.banka;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.namespace.QName;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.ws.Service;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import poslovnaxws.banke.Preseci;
import poslovnaxws.banke.Presek;
import poslovnaxws.banke.Presek.StavkePreseka;
import poslovnaxws.banke.Presek.Zaglavlje;
import poslovnaxws.banke.Uplata;
import poslovnaxws.banke.ZahtevZaIzvod;
import poslovnaxws.common.Status;
import poslovnaxws.common.TBanka;
import poslovnaxws.common.TNalog;
import poslovnaxws.common.TStavkaPreseka;
import poslovnaxws.poruke.MT103;
import poslovnaxws.services.centralnabanka.CentralnaBanka;
import sessionbeans.concrete.MT102DaoLocal;
import sessionbeans.concrete.MT103DaoLocal;
import sessionbeans.concrete.MT900DaoLocal;
import sessionbeans.concrete.MT910DaoLocal;
import sessionbeans.concrete.PreseciDaoLocal;
import util.JndiUtils;

/**
 * This class was generated by Apache CXF 2.6.5 2015-06-19T00:21:24.525+02:00
 * Generated source version: 2.6.5
 * 
 */

@javax.jws.WebService(serviceName = "BankaService", portName = "BankaServicePort", targetNamespace = "PoslovnaXWS/services/banka", wsdlLocation = "file:/E:/Za faks/Projekti/PoslovnaXWS/Banka/WEB-INF/wsdl/Banka.wsdl", endpointInterface = "poslovnaxws.services.banka.BankaServiceMessages")
public class BankaServiceMessagesImpl implements BankaServiceMessages {

	private static String PORUKE_XSD = "../webapps/banka/WEB-INF/xsd/Poruke.xsd";
	private static String BANKE_XSD = "../webapps/banka/WEB-INF/xsd/Banke.xsd";
	private static String COMMON_XSD = "../webapps/banka/WEB-INF/xsd/Common.xsd";

	@EJB
	private PreseciDaoLocal presekDao = JndiUtils
			.getLocalEJB(JndiUtils.PRESECI_DAO);

	@EJB
	private MT900DaoLocal mt900Dao = JndiUtils.getLocalEJB(JndiUtils.MT900_DAO);

	@EJB
	private MT910DaoLocal mt910Dao = JndiUtils.getLocalEJB(JndiUtils.MT910_DAO);

	@EJB
	private MT102DaoLocal mt102Dao = JndiUtils.getLocalEJB(JndiUtils.MT102_DAO);

	@EJB
	private MT103DaoLocal mt103Dao = JndiUtils.getLocalEJB(JndiUtils.MT103_DAO);

	private static final Logger LOG = Logger
			.getLogger(BankaServiceMessagesImpl.class.getName());

	public static final String BANKA_WSDL = "http://localhost:8080/CentralnaBanka/services/CBClearing?wsdl";

	public poslovnaxws.common.Status receiveMT103(poslovnaxws.poruke.MT103 mt103) {
		LOG.info("Executing operation receiveMT103");
		System.out.println(mt103);

		poslovnaxws.common.Status status = validate(mt103, PORUKE_XSD);

		if (status.getKod() != 0)
			return status;

		try {
			mt103Dao.persist(mt103);

			Uplata uplata = new Uplata();
			uplata.setNalog(mt103.getUplata());
			status = createPresek(uplata);

			if (status.getKod() != 0)
				return status;

		} catch (JAXBException e1) {
			status.setKod(4);
			status.setOpis("BANKE exception :JAXB: Couldn't save to database.");
			LOG.warning(e1.getMessage());
			e1.printStackTrace();
			return status;
		} catch (IOException e1) {
			status.setKod(4);
			status.setOpis("BANKE exception :IOException: Couldn't save to database.");
			LOG.warning(e1.getMessage());
			e1.printStackTrace();
			return status;
		}

		return status;
	}

	public poslovnaxws.common.Status receiveMT102(poslovnaxws.poruke.MT102 mt102) {
		LOG.info("Executing operation receiveMT102");

		poslovnaxws.common.Status status = validate(mt102, PORUKE_XSD);

		if (status.getKod() != 0)
			return status;

		try {
			mt102Dao.persist(mt102);

			for (int i = 0; i < mt102.getUplate().getUplata().size(); i++) {
				Uplata uplata = new Uplata();
				uplata.setNalog(mt102.getUplate().getUplata().get(i));
				status = createPresek(uplata);

				if (status.getKod() != 0)
					return status;

			}

		} catch (JAXBException e1) {
			status.setKod(4);
			status.setOpis("BANKE exception :JAXB: Couldn't save to database.");
			LOG.warning(e1.getMessage());
			e1.printStackTrace();
			return status;
		} catch (IOException e1) {
			status.setKod(4);
			status.setOpis("BANKE exception :IOException: Couldn't save to database.");
			LOG.warning(e1.getMessage());
			e1.printStackTrace();
			return status;
		}

		return status;

	}

	public poslovnaxws.common.Status receiveMT900(poslovnaxws.poruke.MT900 mt900) {
		LOG.info("Executing operation receiveMT900");
		System.out.println(mt900);

		Status status = validate(mt900, PORUKE_XSD);

		if (status.getKod() != 0)
			return status;
		
		try {
			mt900Dao.persist(mt900);
		} catch (JAXBException e1) {
			status.setKod(4);
			status.setOpis("BANKE exception :JAXB: Couldn't save to database.");
			LOG.warning(e1.getMessage());
			e1.printStackTrace();
			return status;
		} catch (IOException e1) {
			status.setKod(4);
			status.setOpis("BANKE exception :IOException: Couldn't save to database.");
			LOG.warning(e1.getMessage());
			e1.printStackTrace();
			return status;
		}

		return status;
	}

	public poslovnaxws.common.Status receiveMT910(poslovnaxws.poruke.MT910 mt910) {
		LOG.info("Executing operation receiveMT910");

			poslovnaxws.common.Status status = validate(mt910, PORUKE_XSD);
			
			if (status.getKod() != 0)
				return status;
			
			try {
				mt910Dao.persist(mt910);
			} catch (JAXBException e1) {
				status.setKod(4);
				status.setOpis("BANKE exception :JAXB: Couldn't save to database.");
				LOG.warning(e1.getMessage());
				e1.printStackTrace();
				return status;
			} catch (IOException e1) {
				status.setKod(4);
				status.setOpis("BANKE exception :IOException: Couldn't save to database.");
				LOG.warning(e1.getMessage());
				e1.printStackTrace();
				return status;
			}
			
			return status;
	}

	@Override
	public Presek zahtevZaIzvod(ZahtevZaIzvod zahtevZaIzvod)
			throws NotificationMessage {
		System.out.println("Executing operation zahtevZaIzvod");
		Preseci preseci = null;

		poslovnaxws.common.Status status = validate(zahtevZaIzvod, BANKE_XSD);

		// 0 = OK
		if (status.getKod() != 0) {
			NotificationMessage e = new NotificationMessage(status.getOpis(),
					status);
			throw e;
		}

		try {

			preseci = presekDao.findById(zahtevZaIzvod.getDatum().toString());

			// Počinje od 1
			int redniBroj = zahtevZaIzvod.getRedniBrojPreseka().intValue() - 1;

			// Ako nema više, javi se exception-om (mora tako)
			// Kod je 0 jer je sve ok.
			if (redniBroj >= preseci.getPresek().size()) {
				status.setKod(0);
				status.setOpis("Ne postoji presek broj " + (redniBroj + 1)
						+ " za datum: " + zahtevZaIzvod.getDatum().toString()
						+ "; broj preseka: " + preseci.getPresek().size());
				throw new NotificationMessage(status.getOpis(), status);
			} else
				return preseci.getPresek().get(redniBroj);

		} catch (NullPointerException e) {
			status.setKod(5);
			status.setOpis("Banka : Presek nije pronađen za datum: "
					+ zahtevZaIzvod.getDatum().toString());
			NotificationMessage ex = new NotificationMessage(status.getOpis(),
					status);
			throw ex;
		} catch (NotificationMessage e) {
			throw e;
		} catch (Exception e) {
			status.setKod(5);
			status.setOpis("Banka : Greška na serveru.");
			NotificationMessage ex = new NotificationMessage(status.getOpis(),
					status);
			throw ex;
		}
	}

	@Override
	public Status receiveUplata(Uplata uplata) {
		System.out.println("Executing operation receiveUplata");

		poslovnaxws.common.Status status = validate(uplata, BANKE_XSD);

		if (status.getKod() != 0) {
			return status;
		}

		status = createPresek(uplata);

		if (status.getKod() != 0) {
			return status;
		}

		TNalog nalog = uplata.getNalog();

		MT103 mt103 = new MT103();

		mt103.setUplata(nalog);

		mt103.setBankaDuznik((TBanka) nalog.getDuznik());
		mt103.setBankaPoverioc((TBanka) nalog.getPrimalac());

		CentralnaBanka centralnaBanka = createBankaService();
		status = centralnaBanka.receiveMT103(mt103);

		return status;
	}

	private Status validate(Object message, String xsdLocation) {
		Status _return = new Status();
		try {
			JAXBContext jc = JAXBContext.newInstance(message.getClass());
			JAXBSource source = new JAXBSource(jc, message);

			SchemaFactory sf = SchemaFactory
					.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = sf.newSchema(new File(xsdLocation));
			System.out.println(schema);

			javax.xml.validation.Validator validator = schema.newValidator();
			validator.validate(source);

			_return.setKod(0);
			_return.setOpis("OK");

		} catch (JAXBException e) {
			_return.setKod(1);
			_return.setOpis("BANKE exception :JAXB exception");
			LOG.warning(e.getMessage());
			e.printStackTrace();
		} catch (SAXParseException e) {
			_return.setKod(2);
			_return.setOpis("BANKE exception :Invalid XML");
			LOG.warning(e.getMessage());
			e.printStackTrace();
		} catch (SAXException e) {
			_return.setKod(3);
			_return.setOpis("BANKE exception :SAX exception");
			LOG.warning(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			_return.setKod(4);
			_return.setOpis("BANKE exception :IO exception");
			LOG.warning(e.getMessage());
		} catch (Exception e) {
			_return.setKod(5);
			_return.setOpis("BANKE exception :Internal server error");
			e.printStackTrace();
		}
		return _return;
	}

	private CentralnaBanka createBankaService() {
		URL wsdl;
		try {
			wsdl = new URL(
					"http://localhost:8080/CentralnaBanka/services/CBService?wsdl");

			QName serviceName = new QName(
					"PoslovnaXWS/services/centralnaBanka", "CBService");
			QName portName = new QName("PoslovnaXWS/services/centralnaBanka",
					"CentralnaBankaPort");

			Service service = Service.create(wsdl, serviceName);

			return service.getPort(portName, CentralnaBanka.class);

		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}

		return null;

	}

	private Status createPresek(Uplata uplata) {
		Preseci preseci = null;
		Presek presek = new Presek();

		Status status = new Status();

		TNalog nalog = uplata.getNalog();

		System.out.println(nalog.getDatumNaloga());
		try {

			// Pripremi presek

			// TODO: Banke iz baze

			StavkePreseka stavke = new StavkePreseka();

			TStavkaPreseka stavkaUKorist = new TStavkaPreseka(nalog);
			stavkaUKorist.setSmer("K");
			TStavkaPreseka stavkaNaTeret = new TStavkaPreseka(nalog);
			stavkaNaTeret.setSmer("T");

			stavke.getStavka().add(stavkaUKorist);
			stavke.getStavka().add(stavkaNaTeret);

			presek.setZaglavlje(new Zaglavlje());

			presek.setStavkePreseka(stavke);

			preseci = presekDao.findById(uplata.getNalog().getDatumNaloga()
					.toString());

			preseci.getPresek().add(presek);
			presekDao.merge(preseci, preseci.getId());

		} catch (JAXBException e) {
			// Ako ne nadje nista, vratice nesto sto
			// parser ne ume da prepozna.
			preseci = new Preseci();
			preseci.setDatum(uplata.getNalog().getDatumNaloga());
			preseci.getPresek().add(presek);

			try {
				presekDao.persist(preseci);
			} catch (JAXBException e1) {
				status.setKod(4);
				status.setOpis("BANKE exception :JAXB: Couldn't save to database.");
				LOG.warning(e1.getMessage());
				e1.printStackTrace();

				return status;
			} catch (IOException e1) {
				status.setKod(4);
				status.setOpis("BANKE exception :IOException: Couldn't save to database.");
				LOG.warning(e1.getMessage());
				e1.printStackTrace();

				return status;
			}

		} catch (IOException e) {
			status.setKod(4);
			status.setOpis("BANKE exception :IOException: Couldn't fetch data from database.");
			LOG.warning(e.getMessage());
			e.printStackTrace();

			return status;
		}
		
		status.setKod(0);
		status.setOpis("OK");

		return status;
	}

}
