/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package poslovnaxws.services.centralnabanka;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.EJBException;
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

import poslovnaxws.common.Status;
import poslovnaxws.poruke.MT900;
import poslovnaxws.poruke.MT910;
import poslovnaxws.services.banka.BankaServiceMessages;
import session.dao.BankaDaoLocal;
import session.dao.DnevnoStanjeRacunaDaoLocal;
import session.dao.Mt10xDaoLocal;
import session.dao.Mt9xyDaoLocal;
import session.dao.NalogDaoLocal;
import session.dao.NaseljenoMestoDaoLocal;
import session.dao.RacunBankeDaoLocal;
import session.dao.StavkaDnevnogRacunaDaoLocal;
import session.dao.StavkaPorukeDaoLocal;
import util.JndiUtils;
import entity.Banka;
import entity.DnevnoStanjeRacuna;
import entity.Mt10x;
import entity.Mt9xy;
import entity.Nalog;
import entity.NaseljenoMesto;
import entity.RacunBanke;
import entity.StavkaDnevnogRacuna;
import entity.StavkaPoruke;

/**
 * This class was generated by Apache CXF 2.6.5 2015-06-14T16:24:55.752+02:00
 * Generated source version: 2.6.5
 * 
 */

@javax.jws.WebService(serviceName = "CBService", portName = "CentralnaBankaPort", targetNamespace = "PoslovnaXWS/services/centralnaBanka", wsdlLocation = "file:/E:/Za faks/Projekti/PoslovnaXWS/Banka/WEB-INF/wsdl/CentralnaBanka.wsdl", endpointInterface = "poslovnaxws.services.centralnabanka.CentralnaBanka")
public class CentralnaBankaImpl implements CentralnaBanka {

	public static QName serviceName;
	public static QName portName;
	public static Service service;
	public static BankaServiceMessages banka;

	private static final Logger LOG = Logger.getLogger(CentralnaBankaImpl.class
			.getName());

	private static String PORUKE_XSD = "../webapps/CentralnaBanka/CentralnaBanka/WEB-INF/xsd/Poruke.xsd";
	private static String BANKE_XSD = "../webapps/CentralnaBanka/CentralnaBanka/WEB-INF/xsd/Banke.xsd";
	private static String COMMON_XSD = "../webapps/CentralnaBanka/CentralnaBanka/WEB-INF/xsd/Common.xsd";

	@EJB
	private NalogDaoLocal nalogDao = JndiUtils.getLocalEJB(JndiUtils.NALOG_EJB);

	@EJB
	private NaseljenoMestoDaoLocal naseljenoMestoDao = JndiUtils
			.getLocalEJB(JndiUtils.NASELJENO_MESTO_EJB);

	@EJB
	BankaDaoLocal bankaDao = JndiUtils.getLocalEJB(JndiUtils.BANKA_EJB);

	@EJB
	RacunBankeDaoLocal racunBankeDao = JndiUtils
			.getLocalEJB(JndiUtils.RACUN_BANKE_EJB);

	@EJB
	DnevnoStanjeRacunaDaoLocal dnevnoStanjeRacunaDao = JndiUtils
			.getLocalEJB(JndiUtils.DNEVNO_STANJE_RACUNA_EJB);

	@EJB
	StavkaDnevnogRacunaDaoLocal stavkaDnevnogRacunaDao = JndiUtils
			.getLocalEJB(JndiUtils.STAVKA_DNEVNOG_RACUNA_EJB);

	@EJB
	Mt10xDaoLocal mt10xDao = JndiUtils.getLocalEJB(JndiUtils.MT10X_EJB);

	@EJB
	Mt9xyDaoLocal mt9xyDao = JndiUtils.getLocalEJB(JndiUtils.MT9xy_EJB);

	@EJB
	StavkaPorukeDaoLocal stavkaPorukeDao = JndiUtils
			.getLocalEJB(JndiUtils.STAVKA_PORUKE_EJB);

	public CentralnaBankaImpl() {

		Properties prop = new Properties();

		InputStream propInput = null;

		try {
			propInput = new FileInputStream(
					"../webapps/CentralnaBanka/CentralnaBanka/WEB-INF/config.properties");
			prop.load(propInput);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		URL url;
		try {
			url = new URL(prop.getProperty("namingUrl"));
			System.out.println(url);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);

			conn.setRequestMethod("PUT");

			conn.setRequestProperty("Content-Type", "application/json");
			String input = "cb!" + prop.getProperty("url");
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			int responseCode = conn.getResponseCode();
			String message = conn.getResponseMessage();
			System.out.println("\n* HTTP response: " + responseCode + " ("
					+ message + ')');

			conn.disconnect();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * poslovnaxws.services.centralnabanka.CentralnaBanka#receiveMT103(poslovnaxws
	 * .poruke.MT103 mt103 )*
	 */
	public poslovnaxws.common.Status receiveMT103(poslovnaxws.poruke.MT103 mt103) {
		LOG.info("Executing operation receiveMT103");

		Status status = validate(mt103, PORUKE_XSD);

		// 0 = OK
		if (status.getKod() != 0)
			return status;

		Mt10x mt103Base = new Mt10x(mt103);
		Object[] ob = mt103Base.getStavkaPoruke().toArray();
		Nalog nalog = ((StavkaPoruke) ob[0]).getNalog();
		status = doHardJob(nalog, mt103Base, true, "RTGS");

		if (status.getKod() != 0) {
			return status;
		}

		status = sendMT9xy(mt103Base, nalog);

		if (status.getKod() != 0)
			return status;

		System.out.println("response code: " + status.getKod());
		System.out.println("response: " + status.getOpis());

		return status;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * poslovnaxws.services.centralnabanka.CentralnaBanka#receiveMT102(poslovnaxws
	 * .poruke.MT102 mt102 )*
	 */
	public poslovnaxws.common.Status receiveMT102(poslovnaxws.poruke.MT102 mt102) {

		Mt10x mt102Base = new Mt10x(mt102);
		boolean porukaUBazu = true;
		Status status = validate(mt102, PORUKE_XSD);

		// 0 == OK
		if (status.getKod() != 0)
			return status;
		
		Nalog nalog = null;
		for (StavkaPoruke stavkaPoruke : mt102Base.getStavkaPoruke()) {
			nalog = stavkaPoruke.getNalog();
			Banka bankaDuznika = bankaDao.findBanka(nalog.getNazivDuznika());
			Banka bankaPoverioca = bankaDao
					.findBanka(nalog.getNazivPoverioca());
			bankaDuznika = bankaDao
					.getAllCollections(bankaDuznika.getBankaId());
			bankaPoverioca = bankaDao.getAllCollections(bankaPoverioca
					.getBankaId());
			RacunBanke racunBankeDuznika = racunBankeDao.findByBrojRacuna(nalog
					.getBrojRacunaDuznika());
			if (racunBankeDuznika.getBanka().getBankaId() == bankaDuznika
					.getBankaId() && racunBankeDuznika.isLikvidan()) {
				if (racunBankeDuznika.getStanjeRacuna() >= nalog.getIznos()) {
					RacunBanke racunBankePoverioca = racunBankeDao
							.findByBrojRacuna(nalog.getBrojRacunaPoverioca());
					if (racunBankePoverioca.getBanka().getBankaId() == bankaPoverioca
							.getBankaId()) {

					} else {
						status.setKod(7);
						status.setOpis("Racun poverioca ne pripada odgovarajucoj banci!");
						return status;
					}
				} else {
					status.setKod(8);
					status.setOpis("Racun duznika nema dovoljno sredstava da se odradi RTGS servis!");
					return status;
				}
			} else {
				status.setKod(6);
				status.setOpis("Racun duznika ne pripada odgovarajucoj banci ili je banka nelikvidna");
				return status;
			}
		}

		for (StavkaPoruke stavkaPoruke : mt102Base.getStavkaPoruke()) {
			nalog = stavkaPoruke.getNalog();
			status = doHardJob(nalog, mt102Base, porukaUBazu, "Clearing");
			porukaUBazu = false;
			if (status.getKod() != 0)
				break;
		}

		status = sendMT9xy(mt102Base, nalog);

		if (status.getKod() != 0)
			return status;

		return status;
	}

	public poslovnaxws.common.Status doHardJob(Nalog nalog, Mt10x mt10xBase,
			boolean upisiPorukuUBazu, String typeOfService) {
		try {
			NaseljenoMesto nm = naseljenoMestoDao.findNaseljenoMesto(nalog
					.getNaseljenoMesto().getNazivMesta());
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MINUTE, 0);
			Date date = cal.getTime();
			mt10xBase.setDatumPoruke(date);
			nalog.setAdresaDuznika("ulica");
			nalog.setAdresaPoverioca("ulica");
			Banka bankaDuznika = bankaDao.findBanka(nalog.getNazivDuznika());
			Banka bankaPoverioca = bankaDao
					.findBanka(nalog.getNazivPoverioca());
			bankaDuznika = bankaDao
					.getAllCollections(bankaDuznika.getBankaId());
			bankaPoverioca = bankaDao.getAllCollections(bankaPoverioca
					.getBankaId());
			RacunBanke racunBankeDuznika = racunBankeDao.findByBrojRacuna(nalog
					.getBrojRacunaDuznika());

			if (racunBankeDuznika.getBanka().getBankaId() == bankaDuznika
					.getBankaId() && racunBankeDuznika.isLikvidan()) {
				if (racunBankeDuznika.getStanjeRacuna() >= nalog.getIznos()) {
					RacunBanke racunBankePoverioca = racunBankeDao
							.findByBrojRacuna(nalog.getBrojRacunaPoverioca());
					if (racunBankePoverioca.getBanka().getBankaId() == bankaPoverioca
							.getBankaId()) {
						naseljenoMestoDao.merge(nm);
						nalog.setNaseljenoMesto(nm);
						nalogDao.persist(nalog);
						// System.out.println(mt103Base.getIdPoruke());
						mt10xBase.setStavkaPoruke(new HashSet<StavkaPoruke>());
						// mt103Base.setMt9xy(new HashSet<Mt9xy>());
						mt10xBase.setRacunBankeDuznika(racunBankeDuznika);
						mt10xBase.setRacunBankePoverioca(racunBankePoverioca);
						mt10xBase.setVrsta(103);

						mt10xDao.persist(mt10xBase);
						StavkaPoruke stavkaPoruke = new StavkaPoruke();
						stavkaPoruke.setMt10x(mt10xBase);
						stavkaPoruke.setNalog(nalog);
						stavkaPoruke.setRedniBrojStavke(1);
						stavkaPorukeDao.persist(stavkaPoruke);
						// System.out.println(sp.getIdStavkePoruke());
						// mt103Base.getStavkaPoruke().add(stavkaPoruke);
						if (typeOfService.equals("RTGS")) {
							racunBankeDuznika.setStanjeRacuna(racunBankeDuznika
									.getStanjeRacuna() - nalog.getIznos());
							racunBankePoverioca
									.setStanjeRacuna(racunBankePoverioca
											.getStanjeRacuna()
											+ nalog.getIznos());
						}

						System.out.println(date);
						SimpleDateFormat dt = new SimpleDateFormat(
								"yyyy-MM-dd 00:00:00");
						String dateS = dt.format(date);
						// izvlacenje dnevnog stanja racuna duznika i poverioca
						// i podesavanje parametara
						// podesavanje za duznika
						List<DnevnoStanjeRacuna> dnevnoStanjeRacunaDuznikaLista = dnevnoStanjeRacunaDao
								.findDnevnoStanjeRacuna(dateS,
										racunBankeDuznika.getIdRacuna());
						if (dnevnoStanjeRacunaDuznikaLista.isEmpty()) {
							DnevnoStanjeRacuna dnevnoStanjeRacunaDuznika = new DnevnoStanjeRacuna();
							dnevnoStanjeRacunaDuznika.setDatum(date);
							dnevnoStanjeRacunaDuznika
									.setDnevniPrometNaTeret(nalog.getIznos());
							dnevnoStanjeRacunaDuznika.setDnevniPrometUKorist(0);
							dnevnoStanjeRacunaDuznika
									.setPrethodnoStanje(racunBankeDuznika
											.getStanjeRacuna()
											+ nalog.getIznos());
							dnevnoStanjeRacunaDuznika
									.setRacunBanke(racunBankeDuznika);
							dnevnoStanjeRacunaDuznika
									.setTrenutnoStanje(racunBankeDuznika
											.getStanjeRacuna());
							dnevnoStanjeRacunaDao
									.persist(dnevnoStanjeRacunaDuznika);
							StavkaDnevnogRacuna stavkaDnevnogRacunaDuznika = new StavkaDnevnogRacuna();
							stavkaDnevnogRacunaDuznika
									.setDnevnoStanjeRacuna(dnevnoStanjeRacunaDuznika);
							stavkaDnevnogRacunaDuznika.setNalog(nalog);
							stavkaDnevnogRacunaDuznika.setPrometNaTeret(nalog
									.getIznos());
							stavkaDnevnogRacunaDuznika.setPrometUKorist(0);
							stavkaDnevnogRacunaDao
									.persist(stavkaDnevnogRacunaDuznika);
							dnevnoStanjeRacunaDuznika.getStavkaDnevnogRacuna()
									.add(stavkaDnevnogRacunaDuznika);
							dnevnoStanjeRacunaDao
									.merge(dnevnoStanjeRacunaDuznika);

						} else {
							DnevnoStanjeRacuna dnevnoStanjeRacunaDuznika = dnevnoStanjeRacunaDao
									.getAllCollections(dnevnoStanjeRacunaDuznikaLista
											.get(0).getIdDnevnogStanja());
							dnevnoStanjeRacunaDuznika
									.setPrethodnoStanje(dnevnoStanjeRacunaDuznika
											.getTrenutnoStanje());
							dnevnoStanjeRacunaDuznika
									.setDnevniPrometNaTeret(dnevnoStanjeRacunaDuznika
											.getDnevniPrometNaTeret()
											+ nalog.getIznos());
							dnevnoStanjeRacunaDuznika
									.setTrenutnoStanje(dnevnoStanjeRacunaDuznika
											.getTrenutnoStanje()
											- nalog.getIznos());
							StavkaDnevnogRacuna stavkaDnevnogRacunaDuznika = new StavkaDnevnogRacuna();
							stavkaDnevnogRacunaDuznika
									.setDnevnoStanjeRacuna(dnevnoStanjeRacunaDuznika);
							stavkaDnevnogRacunaDuznika.setNalog(nalog);
							stavkaDnevnogRacunaDuznika.setPrometNaTeret(nalog
									.getIznos());
							stavkaDnevnogRacunaDuznika.setPrometUKorist(0);
							stavkaDnevnogRacunaDao
									.persist(stavkaDnevnogRacunaDuznika);
							dnevnoStanjeRacunaDuznika.getStavkaDnevnogRacuna()
									.add(stavkaDnevnogRacunaDuznika);
							dnevnoStanjeRacunaDao
									.merge(dnevnoStanjeRacunaDuznika);
						}

						// Podesavanja za poverilaca
						List<DnevnoStanjeRacuna> dnevnoStanjeRacunaPoveriocaLista = dnevnoStanjeRacunaDao
								.findDnevnoStanjeRacuna(dateS,
										racunBankePoverioca.getIdRacuna());
						if (dnevnoStanjeRacunaPoveriocaLista.isEmpty()) {
							/*
							 * naseljenoMestoDao.merge(nm);
							 * nalog.setNaseljenoMesto(nm);
							 * nalogDao.persist(nalog);
							 */
							DnevnoStanjeRacuna dnevnoStanjeRacunaPoverioca = new DnevnoStanjeRacuna();
							dnevnoStanjeRacunaPoverioca.setDatum(date);
							dnevnoStanjeRacunaPoverioca
									.setDnevniPrometNaTeret(0);
							dnevnoStanjeRacunaPoverioca
									.setDnevniPrometUKorist(nalog.getIznos());
							dnevnoStanjeRacunaPoverioca
									.setPrethodnoStanje(racunBankePoverioca
											.getStanjeRacuna()
											- nalog.getIznos());
							dnevnoStanjeRacunaPoverioca
									.setRacunBanke(racunBankePoverioca);
							dnevnoStanjeRacunaPoverioca
									.setTrenutnoStanje(racunBankePoverioca
											.getStanjeRacuna());
							dnevnoStanjeRacunaDao
									.persist(dnevnoStanjeRacunaPoverioca);
							StavkaDnevnogRacuna stavkaDnevnogRacunaPoverioca = new StavkaDnevnogRacuna();
							stavkaDnevnogRacunaPoverioca
									.setDnevnoStanjeRacuna(dnevnoStanjeRacunaPoverioca);
							stavkaDnevnogRacunaPoverioca.setNalog(nalog);
							stavkaDnevnogRacunaPoverioca.setPrometNaTeret(0);
							stavkaDnevnogRacunaPoverioca.setPrometUKorist(nalog
									.getIznos());
							stavkaDnevnogRacunaDao
									.persist(stavkaDnevnogRacunaPoverioca);
							dnevnoStanjeRacunaPoverioca
									.getStavkaDnevnogRacuna().add(
											stavkaDnevnogRacunaPoverioca);
							dnevnoStanjeRacunaDao
									.merge(dnevnoStanjeRacunaPoverioca);

						} else {
							/*
							 * naseljenoMestoDao.merge(nm);
							 * nalog.setNaseljenoMesto(nm);
							 * nalogDao.persist(nalog);
							 */
							DnevnoStanjeRacuna dnevnoStanjeRacunaPoverioca = dnevnoStanjeRacunaDao
									.getAllCollections(dnevnoStanjeRacunaPoveriocaLista
											.get(0).getIdDnevnogStanja());
							dnevnoStanjeRacunaPoverioca
									.setPrethodnoStanje(dnevnoStanjeRacunaPoverioca
											.getTrenutnoStanje());
							dnevnoStanjeRacunaPoverioca
									.setDnevniPrometUKorist(dnevnoStanjeRacunaPoverioca
											.getDnevniPrometUKorist()
											+ nalog.getIznos());
							dnevnoStanjeRacunaPoverioca
									.setTrenutnoStanje(dnevnoStanjeRacunaPoverioca
											.getTrenutnoStanje()
											+ nalog.getIznos());
							StavkaDnevnogRacuna stavkaDnevnogRacunaPoverioca = new StavkaDnevnogRacuna();
							stavkaDnevnogRacunaPoverioca
									.setDnevnoStanjeRacuna(dnevnoStanjeRacunaPoverioca);
							stavkaDnevnogRacunaPoverioca.setNalog(nalog);
							stavkaDnevnogRacunaPoverioca.setPrometNaTeret(0);
							stavkaDnevnogRacunaPoverioca.setPrometUKorist(nalog
									.getIznos());
							stavkaDnevnogRacunaDao
									.persist(stavkaDnevnogRacunaPoverioca);
							dnevnoStanjeRacunaPoverioca
									.getStavkaDnevnogRacuna().add(
											stavkaDnevnogRacunaPoverioca);
							dnevnoStanjeRacunaDao
									.merge(dnevnoStanjeRacunaPoverioca);
						}

						racunBankeDao.merge(racunBankePoverioca);
						racunBankeDao.merge(racunBankeDuznika);

						// podesavanje statusa
						poslovnaxws.common.Status status = new Status();
						status.setKod(0);
						status.setOpis("Sve ok!");
						return status;
					} else {
						poslovnaxws.common.Status status = new Status();
						status.setKod(7);
						status.setOpis("Racun poverioca ne pripada odgovarajucoj banci!");
						return status;
					}
				} else {
					poslovnaxws.common.Status status = new Status();
					status.setKod(8);
					status.setOpis("Racun duznika nema dovoljno sredstava da se odradi RTGS servis!");
					return status;
				}
			} else {
				poslovnaxws.common.Status status = new Status();
				status.setKod(6);
				status.setOpis("Racun duznika ne pripada odgovarajucoj banci ili je banka nelikvidna");
				return status;
			}
		} catch (EJBException e) {
			poslovnaxws.common.Status status = new Status();
			status.setKod(9);
			status.setOpis("Jedna od  banaka ili njihovi racuni ne postoje u bazi");
			e.printStackTrace();
			System.out
					.println("-------------------EJBException---------------------");
			return status;
		} catch (java.lang.Exception ex) {
			ex.printStackTrace();
			System.out.println("Puko exception");
			throw new RuntimeException(ex);
		}
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
			_return.setOpis("JAXB exception");
			LOG.warning(e.getMessage());
			e.printStackTrace();
		} catch (SAXParseException e) {
			_return.setKod(2);
			_return.setOpis("Invalid XML");
			LOG.warning(e.getMessage());
			e.printStackTrace();
		} catch (SAXException e) {
			_return.setKod(3);
			_return.setOpis("SAX exception");
			LOG.warning(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			_return.setKod(4);
			_return.setOpis("IO exception");
			LOG.warning(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			_return.setKod(5);
			_return.setOpis("???");
			LOG.warning(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("XML is valid!");
		return _return;
	}

	private BankaServiceMessages createBankaService(String swiftKod) {

		Properties prop = new Properties();

		InputStream propInput = null;
		BufferedReader rd = null;

		try {
			propInput = new FileInputStream(
					"../webapps/banka/WEB-INF/config.properties");
			prop.load(propInput);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		URL url, wsdl;
		try {

			url = new URL(prop.getProperty("namingUrl")
					+ swiftKod.toLowerCase() + "/address");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);

			conn.setRequestMethod("GET");

			String line, wsdlString = "";
			rd = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			while ((line = rd.readLine()) != null) {
				wsdlString += line;
			}

			QName serviceName = new QName("PoslovnaXWS/services/banka",
					"BankaService");
			QName portName = new QName("PoslovnaXWS/services/banka",
					"BankaServicePort");

			wsdl = new URL(wsdlString + "banka?wsdl");

			Service service = Service.create(wsdl, serviceName);

			return service.getPort(portName, BankaServiceMessages.class);

		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	private Status sendMT9xy(Mt10x mt10x, Nalog nalog) {

		Status status = new Status();

		Mt9xy mt900 = new Mt9xy(mt10x);
		mt900.setVrsta(900);
		mt9xyDao.persist(mt900);

		Mt9xy mt910 = new Mt9xy(mt10x);
		mt910.setVrsta(910);
		mt9xyDao.persist(mt910);

		// Poverilac
		banka = createBankaService(mt10x.getRacunBankePoverioca().getBanka()
				.getSwiftKod());
		status = banka.receiveMT910(new MT910(mt910, nalog));
		
		if (status.getKod() != 0)
			return status;
		
		// Duznik
		banka = createBankaService(mt10x.getRacunBankeDuznika().getBanka()
				.getSwiftKod());
		status = banka.receiveMT900(new MT900(mt900, nalog));

		return status;

	}

}
