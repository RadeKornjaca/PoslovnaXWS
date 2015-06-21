package sessionbeans.concrete;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.xml.bind.JAXBException;

import sessionbeans.common.GenericDao;
import entity.fakture.Faktura;
import entity.fakture.Fakture;


@Stateless
@Local(FakturaDaoLocal.class)
public class FakturaDao extends GenericDao<Faktura, Long> implements
		FakturaDaoLocal {

	public static final String contextPath = "entity.fakture";
	
	public static final String schemaName = "fakture";
	
	
	public FakturaDao() {
		super(contextPath, schemaName);
	}


	@Override
	public Faktura findFakturaById(String idDobavljaca, Long idFakture) {
		Faktura result = null;
		
		try {
			result = this.findById(idFakture);
			if(result != null) {
				boolean isHis = result.getZaglavlje().getDobavljac().getPib().equals(idDobavljaca);
				
				return isHis ? result : null;
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}




}
