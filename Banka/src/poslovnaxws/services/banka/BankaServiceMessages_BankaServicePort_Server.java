
package poslovnaxws.services.banka;

import javax.xml.ws.Endpoint;

/**
 * This class was generated by Apache CXF 2.6.5
 * 2015-05-21T17:44:10.709+02:00
 * Generated source version: 2.6.5
 * 
 */
 
public class BankaServiceMessages_BankaServicePort_Server{

    protected BankaServiceMessages_BankaServicePort_Server() throws java.lang.Exception {
        System.out.println("Starting Server");
        Object implementor = new BankaServiceMessagesImpl();
        String address = "http://localhost:8080/BankaService";
        Endpoint.publish(address, implementor);
    }
    
    public static void main(String args[]) throws java.lang.Exception { 
        new BankaServiceMessages_BankaServicePort_Server();
        System.out.println("Server ready..."); 
        
        Thread.sleep(5 * 60 * 1000); 
        System.out.println("Server exiting");
        System.exit(0);
    }
}