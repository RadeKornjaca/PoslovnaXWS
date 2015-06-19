package poslovnaxws.test;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.ws.Service;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

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
		
		/*CentralnaBanka cbi = new CentralnaBankaImpl();

		MT103Wrapper mt103 = new MT103Wrapper();
		cbi.receiveMT103(mt103);*/
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


		
		/*MT103 message = mt103;
		poslovnaxws.common.Status _return = new poslovnaxws.common.Status();
		try {
			JAXBContext jc = JAXBContext.newInstance("poslovnaxws.poruke");
			JAXBSource source = new JAXBSource(jc, message);

			SchemaFactory sf = SchemaFactory
					.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = sf.newSchema(new File(
					"E:/Za faks/apache-tomee-plus-1.5.1/webapps/CentralnaBanka/CentralnaBanka/WEB-INF/xsd/Poruke.xsd"));
			System.out.println(schema);

			Validator validator = schema.newValidator();
			validator.validate(source);

			_return.setKod(0);
			_return.setOpis("OK");

		} catch (JAXBException e) {
			_return.setKod(1);
			_return.setOpis("JAXB exception");
			//LOG.warning(e.getMessage());
			//return _return;
		} catch (SAXParseException e) {
			_return.setKod(2);
			_return.setOpis("Invalid XML");
			e.printStackTrace();
			//LOG.warning(e.getMessage());
			//return _return;
		} catch (SAXException e) {
			_return.setKod(3);
			_return.setOpis("SAX exception");
			//LOG.warning(e.getMessage());
			e.printStackTrace();
			//return _return;
		} catch (IOException e) {
			_return.setKod(4);
			_return.setOpis("IO exception");
			//LOG.warning(e.getMessage());
			//return _return;
		} catch (Exception e) {
			_return.setKod(0);
			_return.setOpis("ok");
			e.printStackTrace();
			//LOG.warning(e.getMessage());
			System.out.println("usao ovde!!!!!!!!!!!!");
		}*/
		/*Source xmlFile = new StreamSource(new File("E:/Za faks/XML TESTOVI/testMT103Valid.xml"));
		try{
		context = JAXBContext.newInstance(MT103.class);
		System.out.println("inicijalizovan context");
    	Marshaller marshaller = context.createMarshaller();
    	System.out.println("kreiran marshaller");
    	File tempXMLFile = new File("E:/Za faks/apache-tomee-plus-1.5.1/temp/xmlForValidatin.xml");
    	System.out.println("kreiran temp xml");
    	System.out.println(tempXMLFile.toString());
    	marshaller.marshal(mt103, tempXMLFile);
    	System.out.println("odradjen marshal");
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
        	System.out.println("usao u JAXBException");
			e.printStackTrace();
        }*/

		Status response = banka.receiveMT103(mt103);
		System.out.println("response code: " + response.getKod());
		System.out.println("response: " + response.getOpis());
		
	}

}
