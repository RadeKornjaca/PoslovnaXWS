package poslovnaxws.test;

import java.io.IOException;
import java.math.BigDecimal;

import javax.xml.bind.JAXBException;

import poslovnaxws.poruke.MT900;
import poslovnaxws.poruke.Poruka;
import sessionbeans.concrete.MT900Dao;

public class BazaTest {
	public static void main(String[] args) throws JAXBException, IOException {
		MT900Dao dao = new MT900Dao();
		MT900 mt900 = new MT900();
		mt900.setIznos(new BigDecimal(123123.15));
		Poruka poruka = new Poruka();
		
		poruka.setAny(mt900);
		//mt900.setId(4L);
		dao.persist(poruka);
		
		
		System.out.println();
	}
}
