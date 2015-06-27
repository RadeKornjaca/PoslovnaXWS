package poslovnaxws.test;

import java.math.BigInteger;

import poslovnaxws.banke.Banka;
import poslovnaxws.common.TBanka;
import sessionbeans.concrete.BankaDao;

public class BazaTest {
	public static void main(String[] args) throws Exception {
		/*
		 * MT900Dao dao = new MT900Dao(); MT900 mt900 = new MT900();
		 * mt900.setIznos(new BigDecimal(123123.15)); Poruka poruka = new
		 * Poruka();
		 * 
		 * poruka.setAny(mt900); //mt900.setId(4L); dao.persist(poruka);
		 */

		// RESTGet.run("(//banka[@id='1'])");

		// RESTGet.run("(//kod_banke[@id='" + SwiftDuznika+
		// "']/stanje_racuna/text())")

		/*
		 * PreseciDao preseciDao = new PreseciDao();
		 * 
		 * System.out.println();
		 * 
		 * System.out.println();
		 * 
		 * File file = new
		 * File("C:/Users/Lazar/Desktop/Faks/testMT103Valid.xml"); JAXBContext
		 * jaxbContext = JAXBContext.newInstance(MT103.class);
		 * 
		 * Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		 * MT103 message = (MT103) jaxbUnmarshaller.unmarshal(file); Uplata
		 * uplata = new Uplata(); uplata.setNalog(message.getUplata());
		 * uplata.getNalog().setHitno(false);
		 * 
		 * UplataDao uplataDao = new UplataDao(); //uplataDao.persist(uplata);
		 * List<Uplata> uplate = uplataDao.findAll(
		 * "(//*:uplata[*:nalog/*:iznos<250000 and *:nalog/*:hitno=false()] )",
		 * true);
		 * 
		 * uplate.get(0);
		 */


	}
}
