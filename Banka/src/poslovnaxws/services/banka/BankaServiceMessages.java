package poslovnaxws.services.banka;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import poslovnaxws.banke.Presek;
import poslovnaxws.banke.ZahtevZaIzvod;

/**
 * This class was generated by Apache CXF 2.6.5
 * 2015-06-20T01:22:06.176+02:00
 * Generated source version: 2.6.5
 * 
 */
@WebService(targetNamespace = "PoslovnaXWS/services/banka", name = "BankaServiceMessages")
@XmlSeeAlso({poslovnaxws.banke.ObjectFactory.class, poslovnaxws.poruke.ObjectFactory.class, poslovnaxws.common.ObjectFactory.class, poslovnaxws.fakture.ObjectFactory.class})
public interface BankaServiceMessages {

    @WebMethod
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "status", targetNamespace = "PoslovnaXWS/Common", partName = "notification")
    public poslovnaxws.common.Status receiveMT103(
        @WebParam(partName = "mt103", name = "MT103", targetNamespace = "PoslovnaXWS/Poruke")
        poslovnaxws.poruke.MT103 mt103
    );

    @WebMethod
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "status", targetNamespace = "PoslovnaXWS/Common", partName = "notification")
    public poslovnaxws.common.Status receiveMT102(
        @WebParam(partName = "mt102", name = "MT102", targetNamespace = "PoslovnaXWS/Poruke")
        poslovnaxws.poruke.MT102 mt102
    );

    @WebMethod
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "status", targetNamespace = "PoslovnaXWS/Common", partName = "notification")
    public poslovnaxws.common.Status receiveMT900(
        @WebParam(partName = "mt900", name = "MT900", targetNamespace = "PoslovnaXWS/Poruke")
        poslovnaxws.poruke.MT900 mt900
    );

    @WebMethod
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "status", targetNamespace = "PoslovnaXWS/Common", partName = "notification")
    public poslovnaxws.common.Status receiveMT910(
        @WebParam(partName = "mt910", name = "MT910", targetNamespace = "PoslovnaXWS/Poruke")
        poslovnaxws.poruke.MT910 mt910
    );

    @WebMethod
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "status", targetNamespace = "PoslovnaXWS/Common", partName = "notification")
    public poslovnaxws.common.Status receiveUplata(
            @WebParam(partName = "uplata", name = "uplata", targetNamespace = "PoslovnaXWS/Banke")
            poslovnaxws.banke.Uplata uplata
    );

    @WebMethod
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "presek", targetNamespace = "PoslovnaXWS/Banke", partName = "presek")
	public poslovnaxws.banke.Presek zahtevZaIzvod(
			  @WebParam(partName = "zahtevZaIzvod", name = "zahtevZaIzvod", targetNamespace = "PoslovnaXWS/Banke")
			  poslovnaxws.banke.ZahtevZaIzvod zahtevZaIzvod)
			throws NotificationMessage;
}
