package sessionbeans.concrete;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import poslovnaxws.banke.Preseci;
import poslovnaxws.banke.Presek;
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


	@Override
	public Presek getPresek(int index, String id) throws IOException, JAXBException {
		InputStream in = em.executeQuery("(//*:preseci[datum="+id+"]//*:stavka)[position() = "+index+"]", false);
		
		context = JAXBContext.newInstance(contextPath);

		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		Presek stavka = (Presek) unmarshaller.unmarshal(in);
		
		return stavka;
	}

}
