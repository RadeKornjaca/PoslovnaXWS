package xmldb;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import sessionbeans.concrete.KupacDao;

public class Test {
	
	public static void main(String[] args) {
		KupacDao k = new KupacDao();
		
		try {
			k.findById(35234515422L);
		} catch (IOException | JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
