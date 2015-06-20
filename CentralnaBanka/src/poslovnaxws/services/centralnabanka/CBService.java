package poslovnaxws.services.centralnabanka;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.6.5
 * 2015-06-14T16:24:55.846+02:00
 * Generated source version: 2.6.5
 * 
 */
@WebServiceClient(name = "CBService", 
                  wsdlLocation = "file:/E:/Za faks/Projekti/PoslovnaXWS/Banka/WEB-INF/wsdl/CentralnaBanka.wsdl",
                  targetNamespace = "PoslovnaXWS/services/centralnaBanka") 
public class CBService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("PoslovnaXWS/services/centralnaBanka", "CBService");
    public final static QName CentralnaBankaPort = new QName("PoslovnaXWS/services/centralnaBanka", "CentralnaBankaPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/E:/Za faks/Projekti/PoslovnaXWS/Banka/WEB-INF/wsdl/CentralnaBanka.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(CBService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/E:/Za faks/Projekti/PoslovnaXWS/Banka/WEB-INF/wsdl/CentralnaBanka.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public CBService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CBService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CBService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public CBService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public CBService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public CBService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns CentralnaBanka
     */
    @WebEndpoint(name = "CentralnaBankaPort")
    public CentralnaBanka getCentralnaBankaPort() {
        return super.getPort(CentralnaBankaPort, CentralnaBanka.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CentralnaBanka
     */
    @WebEndpoint(name = "CentralnaBankaPort")
    public CentralnaBanka getCentralnaBankaPort(WebServiceFeature... features) {
        return super.getPort(CentralnaBankaPort, CentralnaBanka.class, features);
    }

}
