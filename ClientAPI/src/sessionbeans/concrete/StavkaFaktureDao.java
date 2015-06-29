package sessionbeans.concrete;

import java.io.IOException;
import java.math.BigInteger;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.xml.bind.JAXBException;

import sessionbeans.common.GenericDao;
import entity.fakture.Faktura;
import entity.fakture.StavkaFakture;

@Stateless
@Local(StavkaFaktureDaoLocal.class)
public class StavkaFaktureDao extends GenericDao<StavkaFakture, Long> implements
		StavkaFaktureDaoLocal {

	public static final String contextPath = "entity.fakture";
	
	public static final String schemaName = "stavkaFakture";

	@EJB
	private FakturaDaoLocal fakturaDao;
	
	public StavkaFaktureDao() {
		super(contextPath, schemaName);
	}

	
	@Override
	public StavkaFakture findByIdInFaktura(String idDobavljaca, Long idFakture, BigInteger redBr) {
		Faktura faktura = null;
		StavkaFakture stavka = null;
		
		try {
			faktura = fakturaDao.findById(idFakture);
			int index = redBr.intValue() - 1;
			
			if(index < faktura.getStavkeFakture().getStavkaFakture().size()) {
				stavka = faktura.getStavkeFakture().getStavkaFakture().get(index);		//indeksiranje pocinje od nule
			}
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return stavka;
	}

}
