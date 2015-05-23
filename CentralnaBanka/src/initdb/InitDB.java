package initdb;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class InitDB {
	
	public static void main(String[] args) {
		
		try {
			Context ctx = new InitialContext();
			Init init = (Init) ctx.lookup("InitBeanRemote");
			init.init();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		/*InitBean init = new InitBean();
		init.init();*/
	}

}
