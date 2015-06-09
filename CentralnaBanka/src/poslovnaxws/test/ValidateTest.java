package poslovnaxws.test;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import poslovnaxws.poruke.MT102;

public class ValidateTest {
	public static void main(String[] args) throws JAXBException, SAXException, IOException {
		JAXBContext jc = JAXBContext.newInstance("poslovnaxws.poruke");
		
		
		Unmarshaller unmarshaller = jc.createUnmarshaller();

		 MT102 mt102 = (MT102) unmarshaller.unmarshal(new File(
				"C:/Users/Lazar/Desktop/Faks/test.xml"));
		 JAXBSource source = new JAXBSource(jc, mt102);

		SchemaFactory sf = SchemaFactory
				.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf
				.newSchema(new File(
						"C:/Users/Lazar/Desktop/Faks/PI/PoslovnaXWS/XMLSchemas/Poruke.xsd"));
		System.out.println(schema);

		Validator validator = schema.newValidator();
		validator.validate(source);
	}
}
