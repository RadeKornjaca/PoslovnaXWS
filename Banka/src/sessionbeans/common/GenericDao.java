package sessionbeans.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.w3c.dom.Node;

import xmldb.EntityManager;
import entity.iface.Identifiable;
import entity.result.Result;
import entity.result.Results;

public abstract class GenericDao<T extends Identifiable, ID extends Serializable>
		implements GenericDaoLocal<T, ID> {

	protected String contextPath;

	protected JAXBContext context;

	protected EntityManager<T, ID> em;

	public GenericDao(String contextPath, String schemaName) {

		try {
			context = JAXBContext.newInstance(contextPath);
			em = new EntityManager<T, ID>(schemaName, contextPath);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public T persist(T entity) throws JAXBException, IOException {

		if (entity.getId() == null || entity.getId().equals("null")) {
			Long id = em.getIdentity();
			entity.setId(id.toString());
			System.out.println("ID: " + id);
		}

		em.persist(entity, entity.getId());
		return entity;
	}

	public T findById(ID id) throws IOException, JAXBException {
		T entity;
		entity = em.find(id);
		return entity;
	}

	public InputStream findBy(String xQuery, boolean wrap) throws IOException {
		InputStream result;
		result = em.executeQuery(xQuery, wrap);
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll(String xQuery, boolean wrap) throws IOException,
			JAXBException {
		InputStream input = em.executeQuery(xQuery, wrap);
		Results wrappedResults = null;
		List<T> results = new ArrayList<T>();
		wrappedResults = (Results) em.getBasex_unmarshaller().unmarshal(input);
		for (Result result : wrappedResults.getResult())
			results.add((T) em.getUnmarshaller().unmarshal((Node) result.getAny()));
		
		return results;
	}

	public List<T> findAll() throws IOException, JAXBException {
		List<T> result;
		result = em.findAll();
		return result;
	}

	public void remove(ID id) throws IOException {
		em.delete(id);
	}

	public T merge(T entity, ID id) throws IOException, JAXBException {
		em.update(entity, id);
		return entity;
	}

}