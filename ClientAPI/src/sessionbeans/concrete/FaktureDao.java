package sessionbeans.concrete;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.xml.bind.JAXBException;

import sessionbeans.common.GenericDao;
import entity.fakture.Faktura;
import entity.fakture.Fakture;

@Stateless
@Local(FaktureDaoLocal.class)
public class FaktureDao extends GenericDao<Fakture, Long> implements
		FaktureDaoLocal {

	public static final String contextPath = "entity.fakture";
	
	public static final String schemaName = "fakture";
	
	@EJB
	private FakturaDaoLocal fakturaDao;
	
	public FaktureDao() {
		super(contextPath, schemaName);
	}

	@Override
	public Fakture findAllById(String id) throws IOException, JAXBException {
		List<Faktura> invoices = fakturaDao.findAll();
		Fakture result = new Fakture();
		
		
		for(Faktura invoice : invoices) {
			if(invoice.getZaglavlje().getDobavljac().getPib().equals(id)) {
				result.getFaktura().add(invoice);
			}
		}
		
		
		return result;
	}

}
