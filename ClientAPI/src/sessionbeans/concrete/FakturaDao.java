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
		List<Faktura> result = new ArrayList<Faktura>();
		
		for(Faktura invoice : invoices) {
			if(invoice.getZaglavlje().getDobavljac().getPib().equals(id)) {
				result.add(invoice);
			}
		}
		
		return result;
	}

}
