
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package poslovnaxws.services.centralnabanka;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.6.5
 * 2015-05-26T01:29:42.555+02:00
 * Generated source version: 2.6.5
 * 
 */

@javax.jws.WebService(
                      serviceName = "CBService",
                      portName = "CBRTGSPort",
                      targetNamespace = "PoslovnaXWS/services/centralnaBanka",
                      wsdlLocation = "file:/C:/Users/Lazar/Desktop/Faks/PI/PoslovnaXWS/CentralnaBanka/web/WEB-INF/wsdl/CentralnaBanka.wsdl",
                      endpointInterface = "poslovnaxws.services.centralnabanka.CBRTGS")
                      
public class CBRTGSImpl implements CBRTGS {

    private static final Logger LOG = Logger.getLogger(CBRTGSImpl.class.getName());

    /* (non-Javadoc)
     * @see poslovnaxws.services.centralnabanka.CBRTGS#receiveMT103RTGS(poslovnaxws.poruke.MT103  mt103 )*
     */
    public poslovnaxws.common.StatusWrapper receiveMT103RTGS(poslovnaxws.poruke.MT103Wrapper mt103) { 
        LOG.info("Executing operation receiveMT103RTGS");
        System.out.println(mt103);
        try {
            poslovnaxws.common.StatusWrapper _return = new poslovnaxws.common.StatusWrapper();
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see poslovnaxws.services.centralnabanka.CBRTGS#receiveMT102RTGS(poslovnaxws.poruke.MT102  mt102 )*
     */
    public poslovnaxws.common.StatusWrapper receiveMT102RTGS(poslovnaxws.poruke.MT102Wrapper mt102) { 
        LOG.info("Executing operation receiveMT102RTGS");
        System.out.println(mt102);
        try {
            poslovnaxws.common.StatusWrapper _return = new poslovnaxws.common.StatusWrapper();
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
