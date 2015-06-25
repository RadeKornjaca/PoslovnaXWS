package poslovnaxws.banke;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "zahtevZaIzvodWrapper", namespace = "PoslovnaXWS/Banke")
public class ZahtevZaIzvodWrapper {

	@XmlElement(name = "zahtevZaIzvod")
	private ZahtevZaIzvod zahtevZaIzvod;

	public ZahtevZaIzvod getWrappedParameter() {
		return zahtevZaIzvod;
	}

	public void setWrappedParameter(ZahtevZaIzvod wrappedParameter) {
		this.zahtevZaIzvod = wrappedParameter;
	}

}
