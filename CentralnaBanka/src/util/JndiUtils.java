package util;

import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Klasa za dobavljanje EJB preko JNDI lookup-a.
 * 
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

	public static final String BANKA_EJB = JAVA_GLOBAL + APP_NAME + APP_EJB
			+ "BankaDaoBean!session.dao.BankaDaoLocal";
	
	public static final String DNEVNO_STANJE_RACUNA_EJB = JAVA_GLOBAL + APP_NAME + APP_EJB
			+ "DnevnoStanjeRacunaDaoBean!session.dao.DnevnoStanjeRacunaDaoLocal";
	
	public static final String NALOG_EJB = JAVA_GLOBAL + APP_NAME + APP_EJB
			+ "NalogDaoBean!session.dao.NalogDaoLocal";
	
	public static final String NASELJENO_MESTO_EJB = JAVA_GLOBAL + APP_NAME + APP_EJB
			+ "NaseljenoMestoDaoBean!session.dao.NaseljenoMestoDaoLocal";

	public static final String PORUKA_EJB = JAVA_GLOBAL + APP_NAME + APP_EJB
			+ "PorukaDaoBean!session.dao.PorukaDaoLocal";
	
	public static final String RACUN_BANKE_EJB = JAVA_GLOBAL + APP_NAME + APP_EJB
			+ "RacunBankeDaoBean!session.dao.RacunBankeDaoLocal";
	
	public static final String STAVKA_DNEVNOG_RACUNA_EJB = JAVA_GLOBAL + APP_NAME + APP_EJB
			+ "StavkaDnevnogRacunaDaoBean!session.dao.StavkaDnevnogRacunaDaoLocal";
	
	public static final String STAVKA_PORUKE_EJB = JAVA_GLOBAL + APP_NAME + APP_EJB
			+ "StavkaPorukeDaoBean!session.dao.StavkaPorukeDaoLocal";
	
	public static final String MT9xy_EJB = JAVA_GLOBAL + APP_NAME + APP_EJB
			+ "Mt9xyDaoBean!session.dao.Mt9xyDaoLocal";
	/**
	 * Gets local EJB from JNDI.
	 *
	 * @param jndiName
	 *            JNDI constant name to look up for EJB
	 * @param <T>
	 *            generic object
	 * @return local EJB object loaded from JNDI
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getLocalEJB(String jndiName) {
		try {
			InitialContext context = new InitialContext();
			return (T) context.lookup(jndiName);
		} catch (NamingException e) {
			System.out
					.println("Naming exception occurred while trying to load EJB from JNDI with JNDI name: "
							+ jndiName);
			throw new RuntimeException(
					"Naming exception occurred while trying to load EJB from JNDI with JNDI name: "
							+ jndiName, e);
		}
	}
}
