package sessionbeans.concrete;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.xml.bind.JAXBException;

import poslovnaxws.banke.Presek;
import poslovnaxws.common.TNalog;
import sessionbeans.common.GenericDao;

@Stateless
@Local(PresekDaoLocal.class)
public class PresekDao extends GenericDao<Presek, String> implements
		PresekDaoLocal {

	public static final String contextPath = "poslovnaxws.banke";
	
	public static final String schemaName = "stavke";
	
	
	public PresekDao() {
		super(contextPath, schemaName);
	}


	@Override
	public List<Presek> findAllById(String id) throws IOException, JAXBException {
		List<Presek> nalozi = em.findAll();
		List<Presek> result = new ArrayList<Presek>();
		
		for(Presek nalog : nalozi) {
			if(nalog.getId().toString().equals(id)) {
				result.add(nalog);
			}
		}
		
		return result;
	}

}
