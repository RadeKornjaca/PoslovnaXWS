
package poslovnaxws.services.centralnabanka;

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

/**
 * This class was generated by Apache CXF 2.6.5
 * 2015-05-26T01:29:42.473+02:00
 * Generated source version: 2.6.5
 * 
 */
public final class CBRTGS_CBRTGSPort_Client {

    private static final QName SERVICE_NAME = new QName("PoslovnaXWS/services/centralnaBanka", "CBService");

    private CBRTGS_CBRTGSPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = CBService.WSDL_LOCATION;
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
      
        CBService ss = new CBService(wsdlURL, SERVICE_NAME);
        CBRTGS port = ss.getCBRTGSPort();  
        
        {
        System.out.println("Invoking receiveMT103RTGS...");
        poslovnaxws.poruke.MT103 _receiveMT103RTGS_mt103 = new poslovnaxws.poruke.MT103();
        poslovnaxws.common.Status _receiveMT103RTGS__return = port.receiveMT103RTGS(_receiveMT103RTGS_mt103);
        System.out.println("receiveMT103RTGS.result=" + _receiveMT103RTGS__return);


        }
        {
        System.out.println("Invoking receiveMT102RTGS...");
        poslovnaxws.poruke.MT102 _receiveMT102RTGS_mt102 = new poslovnaxws.poruke.MT102();
        poslovnaxws.common.Status _receiveMT102RTGS__return = port.receiveMT102RTGS(_receiveMT102RTGS_mt102);
        System.out.println("receiveMT102RTGS.result=" + _receiveMT102RTGS__return);


        }

        System.exit(0);
    }

}
