package xmldb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.BindException;

import org.basex.BaseXHTTP;

/**
 * Klasa sluzi za pokretanje BaseX standalone servera.
 * 
 * @author Igor Cverdelj-Fogarasi
 *
 */
public class BaseXStart {
	
	private static BaseXHTTP http;

	private static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		System.out.println("Recognized commands (case-insensitive): START|STOP|EXIT");
		System.out.print(">");
		
		for (String command; (command = keyboard.readLine()) != null;) {
			if (command.equalsIgnoreCase("exit")) 
				System.exit(0);
			else if (command.equalsIgnoreCase("start") && http == null) 
				try {
					http = new BaseXHTTP("-Uadmin", "-Padmin");
				}
				catch(Exception e) {
					System.out.println("There was a problem with starting the database. Try again.");
					System.exit(1);
				}
			else if (command.equalsIgnoreCase("stop") && http != null) {
				http.stop();
				System.exit(0);
			}
			else if(command.equalsIgnoreCase("init")) {
				if(http instanceof BaseXHTTP) {
					InitDatabase.init();
				}
			}
			System.out.print(">");
		}
	}
}
