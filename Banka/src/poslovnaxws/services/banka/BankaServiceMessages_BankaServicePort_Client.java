
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
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.6.5
 * 2015-06-19T00:21:24.136+02:00
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
        System.out.println("Invoking receiveMT103...");
        poslovnaxws.poruke.MT103 _receiveMT103_mt103 = new poslovnaxws.poruke.MT103();
        poslovnaxws.common.Status _receiveMT103__return = port.receiveMT103(_receiveMT103_mt103);
        System.out.println("receiveMT103.result=" + _receiveMT103__return);


        }
        {
        System.out.println("Invoking receiveMT102...");
        poslovnaxws.poruke.MT102 _receiveMT102_mt102 = new poslovnaxws.poruke.MT102();
        poslovnaxws.common.Status _receiveMT102__return = port.receiveMT102(_receiveMT102_mt102);
        System.out.println("receiveMT102.result=" + _receiveMT102__return);


        }
        {
        System.out.println("Invoking receiveMT900...");
        poslovnaxws.poruke.MT900 _receiveMT900_mt900 = new poslovnaxws.poruke.MT900();
        poslovnaxws.common.Status _receiveMT900__return = port.receiveMT900(_receiveMT900_mt900);
        System.out.println("receiveMT900.result=" + _receiveMT900__return);


        }
        {
        System.out.println("Invoking receiveMT910...");
        poslovnaxws.poruke.MT910 _receiveMT910_mt910 = new poslovnaxws.poruke.MT910();
        poslovnaxws.common.Status _receiveMT910__return = port.receiveMT910(_receiveMT910_mt910);
        System.out.println("receiveMT910.result=" + _receiveMT910__return);


        }
        {
        System.out.println("Invoking zahtevZaIzvod...");
        java.lang.String _zahtevZaIzvod_brojRacuna = "";
        javax.xml.datatype.XMLGregorianCalendar _zahtevZaIzvod_datum = null;
        java.math.BigInteger _zahtevZaIzvod_redniBrojPreseka = new java.math.BigInteger("0");
        //javax.xml.ws.Holder<poslovnaxws.banke.Zaglavlje> _zahtevZaIzvod_zaglavlje = new javax.xml.ws.Holder<poslovnaxws.banke.Zaglavlje>();
        //javax.xml.ws.Holder<poslovnaxws.banke.StavkePreseka> _zahtevZaIzvod_stavkePreseka = new javax.xml.ws.Holder<poslovnaxws.banke.StavkePreseka>();
        //System.out.println("zahtevZaIzvod._zahtevZaIzvod_zaglavlje=" + _zahtevZaIzvod_zaglavlje.value);
		//System.out.println("zahtevZaIzvod._zahtevZaIzvod_stavkePreseka=" + _zahtevZaIzvod_stavkePreseka.value);
            }

        System.exit(0);
    }

}
