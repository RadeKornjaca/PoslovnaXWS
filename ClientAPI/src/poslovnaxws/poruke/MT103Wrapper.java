package poslovnaxws.poruke;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "mt103Wrapper", namespace = "PoslovnaXWS/Poruke")
public class MT103Wrapper {

	@XmlElement(name = "mt103")
	private MT103 mt103;

	public MT103 getWrappedParameter() {
		return mt103;
	}

	public void setWrappedParameter(MT103 wrappedParameter) {
		this.mt103 = wrappedParameter;
	}

}
