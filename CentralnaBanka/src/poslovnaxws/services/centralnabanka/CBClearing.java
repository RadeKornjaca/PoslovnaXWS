package poslovnaxws.services.centralnabanka;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.6.5
 * 2015-05-26T01:29:42.623+02:00
 * Generated source version: 2.6.5
 * 
 */
@WebService(targetNamespace = "PoslovnaXWS/services/centralnaBanka", name = "CBClearing")
@XmlSeeAlso({poslovnaxws.banke.ObjectFactory.class, poslovnaxws.poruke.ObjectFactory.class, poslovnaxws.common.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface CBClearing {

    @WebMethod(operationName = "receiveMT102_Clearing")
    @WebResult(name = "status", targetNamespace = "PoslovnaXWS/Common", partName = "mt102Response")
    public poslovnaxws.common.Status receiveMT102Clearing(
        @WebParam(partName = "mt102", name = "MT102", targetNamespace = "PoslovnaXWS/Poruke")
        poslovnaxws.poruke.MT102 mt102
    );

    @WebMethod(operationName = "receiveMT103_Clearing")
    @WebResult(name = "status", targetNamespace = "PoslovnaXWS/Common", partName = "mt103Response")
    public poslovnaxws.common.Status receiveMT103Clearing(
        @WebParam(partName = "mt103", name = "MT103", targetNamespace = "PoslovnaXWS/Poruke")
        poslovnaxws.poruke.MT103 mt103
    );
}
