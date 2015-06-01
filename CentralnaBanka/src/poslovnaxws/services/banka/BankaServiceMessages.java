package poslovnaxws.services.banka;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import poslovnaxws.banke.NotificationMessage;

/**
 * This class was generated by Apache CXF 2.6.5 2015-05-21T17:44:10.699+02:00
 * Generated source version: 2.6.5
 * 
 */
@WebService(targetNamespace = "PoslovnaXWS/services/banka", name = "BankaServiceMessages")
@XmlSeeAlso({ poslovnaxws.banke.ObjectFactory.class,
		poslovnaxws.poruke.ObjectFactory.class,
		poslovnaxws.common.ObjectFactory.class,
		poslovnaxws.fakture.ObjectFactory.class })
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface BankaServiceMessages {

	@RequestWrapper(className = "poslovnaxws.poruke.MT103Wrapper")
	@ResponseWrapper(className = "poslovnaxws.common.StatusWrapper")
	@WebMethod
	@WebResult(name = "status", targetNamespace = "PoslovnaXWS/Common", partName = "notification")
	public poslovnaxws.common.StatusWrapper receiveMT103(
			@WebParam(partName = "mt103", name = "MT103", targetNamespace = "PoslovnaXWS/Poruke") poslovnaxws.poruke.MT103Wrapper mt103Wrapper);

	@RequestWrapper(className = "poslovnaxws.poruke.MT102Wrapper")
	@ResponseWrapper(className = "poslovnaxws.common.StatusWrapper")
	@WebMethod
	@WebResult(name = "status", targetNamespace = "PoslovnaXWS/Common", partName = "notification")
	public poslovnaxws.common.StatusWrapper receiveMT102(
			@WebParam(partName = "mt102", name = "MT102", targetNamespace = "PoslovnaXWS/Poruke") poslovnaxws.poruke.MT102Wrapper mt102Wrapper);

	@RequestWrapper(className = "poslovnaxws.poruke.MT900Wrapper")
	@ResponseWrapper(className = "poslovnaxws.common.StatusWrapper")
	@WebMethod
	@WebResult(name = "status", targetNamespace = "PoslovnaXWS/Common", partName = "notification")
	public poslovnaxws.common.StatusWrapper receiveMT900(
			@WebParam(partName = "mt900", name = "MT900", targetNamespace = "PoslovnaXWS/Poruke") poslovnaxws.poruke.MT900Wrapper mt900Wrapper);

	@RequestWrapper(className = "poslovnaxws.poruke.MT102Wrapper")
	@ResponseWrapper(className = "poslovnaxws.common.StatusWrapper")
	@WebMethod
	@WebResult(name = "status", targetNamespace = "PoslovnaXWS/Common", partName = "notification")
	public poslovnaxws.common.StatusWrapper receiveMT910(
			@WebParam(partName = "mt910", name = "MT910", targetNamespace = "PoslovnaXWS/Poruke") poslovnaxws.poruke.MT910Wrapper mt910Wrapper);

	@RequestWrapper(className = "poslovnaxws.common.NalogWrapper")
	@ResponseWrapper(className = "poslovnaxws.banke.PresekWrapper")
	@WebMethod
	@WebResult(name = "zahtevZaIzvod", targetNamespace = "PoslovnaXWS/Banke", partName = "zahtevZaIzvod")
	public poslovnaxws.banke.PresekWrapper zahtevZaIzvod(
			@WebParam(partName = "nalog", name = "Nalog", targetNamespace = "PoslovnaXWS/Common") poslovnaxws.common.NalogWrapper nalog)
			throws NotificationMessage;
}