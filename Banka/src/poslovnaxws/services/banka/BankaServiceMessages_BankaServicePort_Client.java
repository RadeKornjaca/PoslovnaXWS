
package poslovnaxws.services.banka;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

import poslovnaxws.common.NalogWrapper;
import poslovnaxws.common.TNalog;

/**
 * This class was generated by Apache CXF 2.6.5
 * 2015-05-21T17:44:10.436+02:00
 * Generated source version: 2.6.5
 * 
 */
public final class BankaServiceMessages_BankaServicePort_Client {

    private static final QName SERVICE_NAME = new QName("PoslovnaXWS/services/banka", "BankaService");

    private BankaServiceMessages_BankaServicePort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = BankaService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        BankaService ss = new BankaService(wsdlURL, SERVICE_NAME);
        BankaServiceMessages port = ss.getBankaServicePort();  
        
        {


        }
        {


        }
        {
        System.out.println("Invoking receiveMT103...");
        poslovnaxws.poruke.MT103Wrapper _receiveMT103_mt103 = null;
        poslovnaxws.common.StatusWrapper _receiveMT103__return = port.receiveMT103(_receiveMT103_mt103);
        System.out.println("receiveMT103.result=" + _receiveMT103__return);


        }
        {
        System.out.println("Invoking receiveMT102...");
        poslovnaxws.poruke.MT102Wrapper _receiveMT102_mt102 = null;
        poslovnaxws.common.StatusWrapper _receiveMT102__return = port.receiveMT102(_receiveMT102_mt102);
        System.out.println("receiveMT102.result=" + _receiveMT102__return);


        }
        {
        System.out.println("Invoking receiveMT900...");
        poslovnaxws.poruke.MT900Wrapper _receiveMT900_mt900 = null;
        poslovnaxws.common.StatusWrapper _receiveMT900__return = port.receiveMT900(_receiveMT900_mt900);
        System.out.println("receiveMT900.result=" + _receiveMT900__return);


        }
        {
        System.out.println("Invoking receiveMT910...");
        poslovnaxws.poruke.MT910Wrapper _receiveMT910_mt910 = null;
        poslovnaxws.common.StatusWrapper _receiveMT910__return = port.receiveMT910(_receiveMT910_mt910);
        System.out.println("receiveMT910.result=" + _receiveMT910__return);


        }
        {
        System.out.println("Invoking zahtevZaIzvod...");
        try {
            poslovnaxws.banke.PresekWrapper _zahtevZaIzvod__return = port.zahtevZaIzvod(new NalogWrapper());
            System.out.println("zahtevZaIzvod.result=" + _zahtevZaIzvod__return);

        } catch (NotificationMessage e) { 
            System.out.println("Expected exception: notificationMessage has occurred.");
            System.out.println(e.toString());
        }
            }

        System.exit(0);
    }

}
