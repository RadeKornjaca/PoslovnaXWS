package util;

import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Klasa za dobavljanje EJB preko JNDI lookup-a.
 * @author Paulius Matulionis
 *
 */
public class JndiUtils {
	/**
	 * Java global JNDI.
	 */
	private static final String JAVA_GLOBAL = "java:global/";

	/**
	 * Application name in application server.
	 */
	private static final String APP_NAME = "CentralnaBanka/";

	/**
	 * Application EJB jar name.
	 */
	private static final String APP_EJB = "CentralnaBanka/";

	/**
	 * Credit EJB constant.
	 */
	public static final String MT10X_EJB = JAVA_GLOBAL + APP_NAME + APP_EJB
			+ "Mt10xDaoBean!session.dao.Mt10xDaoLocal";
	
	public static final String DRZAVA_EJB = JAVA_GLOBAL + APP_NAME + APP_EJB
			+ "DrzavaDaoBean!session.dao.DrzavaDaoLocal";

	/**
	 * Gets local EJB from JNDI.
	 *
	 * @param jndiName
	 *            JNDI constant name to look up for EJB
	 * @param <T>
	 *            generic object
	 * @return local EJB object loaded from JNDI
	 */
	public static <T> T getLocalEJB(String jndiName) {
		try {
			InitialContext context = new InitialContext();
			return (T) context.lookup(jndiName);
		} catch (NamingException e) {
			System.out.println(
					"Naming exception occurred while trying to load EJB from JNDI with JNDI name: "
							+ jndiName);
			throw new RuntimeException(
					"Naming exception occurred while trying to load EJB from JNDI with JNDI name: "
							+ jndiName, e);
		}
	}
}
