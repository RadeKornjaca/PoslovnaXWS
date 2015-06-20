package sessionbeans.concrete;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.xml.bind.JAXBException;

import sessionbeans.common.GenericDao;
import entity.fakture.Faktura;


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
	public List<Faktura> findAllById(String id) throws IOException, JAXBException {
		List<Faktura> invoices = em.findAll();
		List<Faktura> result = new ArrayList<Faktura>(invoices);
		
		
		for(Faktura invoice : invoices) {
			if(invoice.getZaglavlje().getDobavljac().getPib().equals(id)) {
				result.remove(invoice);
			}
		}
		
		return result;
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
