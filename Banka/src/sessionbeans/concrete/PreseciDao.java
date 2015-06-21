package sessionbeans.concrete;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.xml.bind.JAXBException;

import poslovnaxws.banke.Preseci;
import sessionbeans.common.GenericDao;

@Stateless
@Local(PreseciDaoLocal.class)
public class PreseciDao extends GenericDao<Preseci, String> implements
		PreseciDaoLocal {

	public static final String contextPath = "poslovnaxws.banke";
	
	public static final String schemaName = "preseci";
	
	
	public PreseciDao() {
		super(contextPath, schemaName);
	}


	@Override
	public List<Preseci> findAllById(String id) throws IOException, JAXBException {
		List<Preseci> nalozi = em.findAll();
		List<Preseci> result = new ArrayList<Preseci>();
		
		for(Preseci nalog : nalozi) {
			if(nalog.getId().toString().equals(id)) {
				result.add(nalog);
			}
		}
		
		return result;
	}
	
	
	//Po datumu, ne po id-u
	@Override
	public Preseci persist(Preseci entity) throws JAXBException, IOException {
		em.persist(entity, entity.getId());
		return entity;
	}

}
