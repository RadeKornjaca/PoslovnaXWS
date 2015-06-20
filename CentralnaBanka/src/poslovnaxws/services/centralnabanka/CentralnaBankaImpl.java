
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package poslovnaxws.services.centralnabanka;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import poslovnaxws.common.Status;
import session.dao.BankaDaoLocal;
import session.dao.DnevnoStanjeRacunaDaoLocal;
import session.dao.Mt10xDaoLocal;
import session.dao.NalogDaoLocal;
import session.dao.NaseljenoMestoDaoLocal;
import session.dao.RacunBankeDaoLocal;
import session.dao.StavkaDnevnogRacunaDaoLocal;
import session.dao.StavkaPorukeDaoLocal;
import util.JndiUtils;
import entity.Banka;
import entity.DnevnoStanjeRacuna;
import entity.Mt10x;
import entity.Nalog;
import entity.NaseljenoMesto;
import entity.RacunBanke;
import entity.StavkaDnevnogRacuna;
import entity.StavkaPoruke;

/**
 * This class was generated by Apache CXF 2.6.5
 * 2015-06-14T16:24:55.752+02:00
 * Generated source version: 2.6.5
 * 
 */

@javax.jws.WebService(
                      serviceName = "CBService",
                      portName = "CentralnaBankaPort",
                      targetNamespace = "PoslovnaXWS/services/centralnaBanka",
                      wsdlLocation = "file:/E:/Za faks/Projekti/PoslovnaXWS/Banka/WEB-INF/wsdl/CentralnaBanka.wsdl",
                      endpointInterface = "poslovnaxws.services.centralnabanka.CentralnaBanka")
                      
public class CentralnaBankaImpl implements CentralnaBanka {

    private static final Logger LOG = Logger.getLogger(CentralnaBankaImpl.class.getName());
    
	private static String PORUKE_XSD = "../webapps/banka/WEB-INF/xsd/Poruke.xsd";
	private static String BANKE_XSD = "../webapps/banka/WEB-INF/xsd/Banke.xsd";
	private static String COMMON_XSD = "../webapps/banka/WEB-INF/xsd/Common.xsd";
    
    @EJB
	private NalogDaoLocal nalogDao = JndiUtils.getLocalEJB(JndiUtils.NALOG_EJB);
   
    @EJB
	private NaseljenoMestoDaoLocal naseljenoMestoDao = JndiUtils.getLocalEJB(JndiUtils.NASELJENO_MESTO_EJB);
    
    @EJB
    BankaDaoLocal bankaDao = JndiUtils.getLocalEJB(JndiUtils.BANKA_EJB);
    
    @EJB
    RacunBankeDaoLocal racunBankeDao = JndiUtils.getLocalEJB(JndiUtils.RACUN_BANKE_EJB);
    
    @EJB
    DnevnoStanjeRacunaDaoLocal dnevnoStanjeRacunaDao = JndiUtils.getLocalEJB(JndiUtils.DNEVNO_STANJE_RACUNA_EJB);
    
    @EJB
    StavkaDnevnogRacunaDaoLocal stavkaDnevnogRacunaDao = JndiUtils.getLocalEJB(JndiUtils.STAVKA_DNEVNOG_RACUNA_EJB);
    
    @EJB
    Mt10xDaoLocal mt10xDao = JndiUtils.getLocalEJB(JndiUtils.MT10X_EJB);
    
    @EJB
    StavkaPorukeDaoLocal stavkaPorukeDao = JndiUtils.getLocalEJB(JndiUtils.STAVKA_PORUKE_EJB);
    
    /* (non-Javadoc)
     * @see poslovnaxws.services.centralnabanka.CentralnaBanka#receiveMT103(poslovnaxws.poruke.MT103  mt103 )*
     */
    public poslovnaxws.common.Status receiveMT103(poslovnaxws.poruke.MT103 mt103) { 
        LOG.info("Executing operation receiveMT103");
        
        Status status = validate(mt103, PORUKE_XSD);
        
        //0 = OK
        if (status.getKod() != 0)
        	return status;
        /*Source xmlFile = new StreamSource(new File("E:/Za faks/XML TESTOVI/testMT103Valid.xml"));
        System.out.println("stigo do ovde, napravio source");
        JAXBContext context;
        System.out.println("Prazan context");
        try {
        	context = JAXBContext.newInstance(MT103.class);
        	System.out.println("inicijalizovan context");
        	Marshaller marshaller = context.createMarshaller();
        	System.out.println("kreiran marshaller");
        	File XMLFile = new File("E:/Za faks/apache-tomee-plus-1.5.1/temp/xmlForValidatin.xml");
        	System.out.println("kreiran temp xml");
        	System.out.println(XMLFile.toString());
        	marshaller.marshal(mt103, XMLFile);
        	System.out.println("odradjen marshal");
        	System.out.println(XMLFile.toString());
        	URL schemaFile = new URL("file:///E:/Za faks/apache-tomee-plus-1.5.1/webapps/CentralnaBanka/CentralnaBanka/WEB-INF/xsd/Poruke.xsd");
        	SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	        Schema schema = schemaFactory.newSchema(schemaFile);
	        Validator validator = schema.newValidator();
	        validator.validate(xmlFile);
	        System.out.println(xmlFile.getSystemId() + " is valid");
        } catch (SAXException | IOException e) {
	        System.out.println(xmlFile.getSystemId() + " is NOT valid");
	        System.out.println("Reason: " + e.getLocalizedMessage());
	        e.printStackTrace();
	        System.out.println("usao u SAXException");
	        status = new Status();
	        status.setKod(2);
	        status.setOpis("Invalid XML");
	        return status;
        } catch (JAXBException e) {
			// TODO Auto-generated catch block
        	System.out.println("usao u JAXBException");
			e.printStackTrace();
        } catch (Exception e){
        	e.printStackTrace();
        }*/
        //return null;
		Mt10x mt103Base = new Mt10x(mt103);
		Object[] ob = mt103Base.getStavkaPoruke().toArray();
	    Nalog nalog = ((StavkaPoruke) ob[0]).getNalog();
	    return doHardJob(nalog, mt103Base, true, "RTGS");
        
    }

    /* (non-Javadoc)
     * @see poslovnaxws.services.centralnabanka.CentralnaBanka#receiveMT102(poslovnaxws.poruke.MT102  mt102 )*
     */
    public poslovnaxws.common.Status receiveMT102(poslovnaxws.poruke.MT102 mt102) { 
    	
    	Mt10x mt102Base = new Mt10x(mt102);
    	boolean porukaUBazu = true;
    	Status status = validate(mt102, PORUKE_XSD);
    	
    	//0 == OK
    	if (status.getKod() != 0)
    		return status;
    	
    	for (StavkaPoruke stavkaPoruke : mt102Base.getStavkaPoruke()) {
			Nalog nalog = stavkaPoruke.getNalog();
			status = doHardJob(nalog, mt102Base, porukaUBazu, "Clearing");
			porukaUBazu = false;
			if(status.getKod() != 0)
				break;
		}
    	return status;
    }
    
    public poslovnaxws.common.Status doHardJob(Nalog nalog, Mt10x mt10xBase, boolean upisiPorukuUBazu, String typeOfService){
    	try {
	    	NaseljenoMesto nm = naseljenoMestoDao.findNaseljenoMesto(nalog.getNaseljenoMesto().getNazivMesta());
	    	Calendar cal = Calendar.getInstance();
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MINUTE, 0);
			Date date = cal.getTime();
            mt10xBase.setDatumPoruke(date);
			nalog.setAdresaDuznika("ulica");
            nalog.setAdresaPoverioca("ulica");
	    	Banka bankaDuznika = bankaDao.findBanka(nalog.getNazivDuznika());	
	        Banka bankaPoverioca = bankaDao.findBanka(nalog.getNazivPoverioca());
	        bankaDuznika = bankaDao.getAllCollections(bankaDuznika.getBankaId());
	        bankaPoverioca = bankaDao.getAllCollections(bankaPoverioca.getBankaId());
	        RacunBanke racunBankeDuznika = racunBankeDao.findByBrojRacuna(nalog.getBrojRacunaDuznika());
	        if(racunBankeDuznika.getBanka().getBankaId() == bankaDuznika.getBankaId() && racunBankeDuznika.isLikvidan()){
	        	if(racunBankeDuznika.getStanjeRacuna()>= nalog.getIznos()){
	            	RacunBanke racunBankePoverioca = racunBankeDao.findByBrojRacuna(nalog.getBrojRacunaPoverioca());
	            	if(racunBankePoverioca.getBanka().getBankaId() == bankaPoverioca.getBankaId()){
	            		naseljenoMestoDao.merge(nm);
	                    nalog.setNaseljenoMesto(nm);
	                    nalogDao.persist(nalog);
	                    //System.out.println(mt103Base.getIdPoruke());
	                    mt10xBase.setStavkaPoruke(new HashSet<StavkaPoruke>());
	                    //mt103Base.setMt9xy(new HashSet<Mt9xy>());
	                    mt10xBase.setRacunBankeDuznika(racunBankeDuznika);
	                    mt10xBase.setRacunBankePoverioca(racunBankePoverioca);
	                    mt10xBase.setVrsta(103);
	                    
	                    mt10xDao.persist(mt10xBase);
	                    StavkaPoruke stavkaPoruke = new StavkaPoruke();
	            		stavkaPoruke.setMt10x(mt10xBase);
	            		stavkaPoruke.setNalog(nalog);
	            		stavkaPoruke.setRedniBrojStavke(1);
	            		stavkaPorukeDao.persist(stavkaPoruke);
	            		//System.out.println(sp.getIdStavkePoruke());
	            		//mt103Base.getStavkaPoruke().add(stavkaPoruke);	            		
	            		if(typeOfService.equals("RTGS")){
	            			racunBankeDuznika.setStanjeRacuna(racunBankeDuznika.getStanjeRacuna() - nalog.getIznos());
	            			racunBankePoverioca.setStanjeRacuna(racunBankePoverioca.getStanjeRacuna() + nalog.getIznos());
	            		}
	            		
	        			System.out.println(date);
	        			SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
	        			String dateS = dt.format(date);
	        			//izvlacenje dnevnog stanja racuna duznika i poverioca i podesavanje parametara
	        			//podesavanje za duznika
	        			List<DnevnoStanjeRacuna> dnevnoStanjeRacunaDuznikaLista = dnevnoStanjeRacunaDao.findDnevnoStanjeRacuna(dateS, racunBankeDuznika.getIdRacuna());
	        			if(dnevnoStanjeRacunaDuznikaLista.isEmpty()){
	        				DnevnoStanjeRacuna dnevnoStanjeRacunaDuznika = new DnevnoStanjeRacuna();
	        				dnevnoStanjeRacunaDuznika.setDatum(date);
	        				dnevnoStanjeRacunaDuznika.setDnevniPrometNaTeret(nalog.getIznos());
	        				dnevnoStanjeRacunaDuznika.setDnevniPrometUKorist(0);
	        				dnevnoStanjeRacunaDuznika.setPrethodnoStanje(racunBankeDuznika.getStanjeRacuna() + nalog.getIznos());
	        				dnevnoStanjeRacunaDuznika.setRacunBanke(racunBankeDuznika);
	        				dnevnoStanjeRacunaDuznika.setTrenutnoStanje(racunBankeDuznika.getStanjeRacuna());
	        				dnevnoStanjeRacunaDao.persist(dnevnoStanjeRacunaDuznika);
	        				StavkaDnevnogRacuna stavkaDnevnogRacunaDuznika = new StavkaDnevnogRacuna();
	        				stavkaDnevnogRacunaDuznika.setDnevnoStanjeRacuna(dnevnoStanjeRacunaDuznika);
	        				stavkaDnevnogRacunaDuznika.setNalog(nalog);
	        				stavkaDnevnogRacunaDuznika.setPrometNaTeret(nalog.getIznos());
	        				stavkaDnevnogRacunaDuznika.setPrometUKorist(0);
	        				stavkaDnevnogRacunaDao.persist(stavkaDnevnogRacunaDuznika);
	        				dnevnoStanjeRacunaDuznika.getStavkaDnevnogRacuna().add(stavkaDnevnogRacunaDuznika);
	        				dnevnoStanjeRacunaDao.merge(dnevnoStanjeRacunaDuznika);
	        				
	        			}
	        			else{
	        				DnevnoStanjeRacuna dnevnoStanjeRacunaDuznika = dnevnoStanjeRacunaDao.getAllCollections(dnevnoStanjeRacunaDuznikaLista.get(0).getIdDnevnogStanja());
	        				dnevnoStanjeRacunaDuznika.setPrethodnoStanje(dnevnoStanjeRacunaDuznika.getTrenutnoStanje());
	        				dnevnoStanjeRacunaDuznika.setDnevniPrometNaTeret(dnevnoStanjeRacunaDuznika.getDnevniPrometNaTeret() + nalog.getIznos());
	        				dnevnoStanjeRacunaDuznika.setTrenutnoStanje(dnevnoStanjeRacunaDuznika.getTrenutnoStanje() - nalog.getIznos());
	        				StavkaDnevnogRacuna stavkaDnevnogRacunaDuznika = new StavkaDnevnogRacuna();
	        				stavkaDnevnogRacunaDuznika.setDnevnoStanjeRacuna(dnevnoStanjeRacunaDuznika);
	        				stavkaDnevnogRacunaDuznika.setNalog(nalog);
	        				stavkaDnevnogRacunaDuznika.setPrometNaTeret(nalog.getIznos());
	        				stavkaDnevnogRacunaDuznika.setPrometUKorist(0);
	        				stavkaDnevnogRacunaDao.persist(stavkaDnevnogRacunaDuznika);
	        				dnevnoStanjeRacunaDuznika.getStavkaDnevnogRacuna().add(stavkaDnevnogRacunaDuznika);
	        				dnevnoStanjeRacunaDao.merge(dnevnoStanjeRacunaDuznika);
	        			}
	        			
	        			//Podesavanja za poverilaca
	        			List<DnevnoStanjeRacuna> dnevnoStanjeRacunaPoveriocaLista = dnevnoStanjeRacunaDao.findDnevnoStanjeRacuna(dateS, racunBankePoverioca.getIdRacuna());
	        			if(dnevnoStanjeRacunaPoveriocaLista.isEmpty()){
	        				/*naseljenoMestoDao.merge(nm);
		                    nalog.setNaseljenoMesto(nm);
		                    nalogDao.persist(nalog);*/
	        				DnevnoStanjeRacuna dnevnoStanjeRacunaPoverioca = new DnevnoStanjeRacuna();
	        				dnevnoStanjeRacunaPoverioca.setDatum(date);
	        				dnevnoStanjeRacunaPoverioca.setDnevniPrometNaTeret(0);
	        				dnevnoStanjeRacunaPoverioca.setDnevniPrometUKorist(nalog.getIznos());
	        				dnevnoStanjeRacunaPoverioca.setPrethodnoStanje(racunBankePoverioca.getStanjeRacuna() - nalog.getIznos());
	        				dnevnoStanjeRacunaPoverioca.setRacunBanke(racunBankePoverioca);
	        				dnevnoStanjeRacunaPoverioca.setTrenutnoStanje(racunBankePoverioca.getStanjeRacuna());
	        				dnevnoStanjeRacunaDao.persist(dnevnoStanjeRacunaPoverioca);
	        				StavkaDnevnogRacuna stavkaDnevnogRacunaPoverioca = new StavkaDnevnogRacuna();
	        				stavkaDnevnogRacunaPoverioca.setDnevnoStanjeRacuna(dnevnoStanjeRacunaPoverioca);
	        				stavkaDnevnogRacunaPoverioca.setNalog(nalog);
	        				stavkaDnevnogRacunaPoverioca.setPrometNaTeret(0);
	        				stavkaDnevnogRacunaPoverioca.setPrometUKorist(nalog.getIznos());
	        				stavkaDnevnogRacunaDao.persist(stavkaDnevnogRacunaPoverioca);
	        				dnevnoStanjeRacunaPoverioca.getStavkaDnevnogRacuna().add(stavkaDnevnogRacunaPoverioca);
	        				dnevnoStanjeRacunaDao.merge(dnevnoStanjeRacunaPoverioca);
	        				
	        			}
	        			else{
	        				/*naseljenoMestoDao.merge(nm);
		                    nalog.setNaseljenoMesto(nm);
		                    nalogDao.persist(nalog);*/
	        				DnevnoStanjeRacuna dnevnoStanjeRacunaPoverioca = dnevnoStanjeRacunaDao.getAllCollections(dnevnoStanjeRacunaPoveriocaLista.get(0).getIdDnevnogStanja());
	        				dnevnoStanjeRacunaPoverioca.setPrethodnoStanje(dnevnoStanjeRacunaPoverioca.getTrenutnoStanje());
	        				dnevnoStanjeRacunaPoverioca.setDnevniPrometUKorist(dnevnoStanjeRacunaPoverioca.getDnevniPrometUKorist() + nalog.getIznos());
	        				dnevnoStanjeRacunaPoverioca.setTrenutnoStanje(dnevnoStanjeRacunaPoverioca.getTrenutnoStanje() + nalog.getIznos());
	        				StavkaDnevnogRacuna stavkaDnevnogRacunaPoverioca = new StavkaDnevnogRacuna();
	        				stavkaDnevnogRacunaPoverioca.setDnevnoStanjeRacuna(dnevnoStanjeRacunaPoverioca);
	        				stavkaDnevnogRacunaPoverioca.setNalog(nalog);
	        				stavkaDnevnogRacunaPoverioca.setPrometNaTeret(0);
	        				stavkaDnevnogRacunaPoverioca.setPrometUKorist(nalog.getIznos());
	        				stavkaDnevnogRacunaDao.persist(stavkaDnevnogRacunaPoverioca);
	        				dnevnoStanjeRacunaPoverioca.getStavkaDnevnogRacuna().add(stavkaDnevnogRacunaPoverioca);
	        				dnevnoStanjeRacunaDao.merge(dnevnoStanjeRacunaPoverioca);
	        			}
	        			
	        			
	            		racunBankeDao.merge(racunBankePoverioca);
	            		racunBankeDao.merge(racunBankeDuznika);
	            		
	            		
	            		
	            		//podesavanje statusa
	            		poslovnaxws.common.Status status = new Status();
	                    status.setKod(0);
	                    status.setOpis("Sve ok!");
	                    return status;
	            	}
	            	else{
	            		poslovnaxws.common.Status status = new Status();
	                    status.setKod(7);
	                    status.setOpis("Racun poverioca ne pripada odgovarajucoj banci!");
	                    return status;
	            	}
	        	}
	        	else{            		
	        		poslovnaxws.common.Status status = new Status();
	                status.setKod(8);
	                status.setOpis("Racun duznika nema dovoljno sredstava da se odradi RTGS servis!");
	                return status;
	        	}
	        }
	        else{
	        	poslovnaxws.common.Status status = new Status();
	            status.setKod(6);
	            status.setOpis("Racun duznika ne pripada odgovarajucoj banci!");
	            return status;
	        }
    	} catch (EJBException e){
        	poslovnaxws.common.Status status = new Status();
            status.setKod(9);
            status.setOpis("Jedna od  banaka ili njihovi racuni ne postoje u bazi");
            e.printStackTrace();
            System.out.println("-------------------EJBException---------------------");
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
		return _return;
	}

}
