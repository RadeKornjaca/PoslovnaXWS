package poslovnaxws.poruke;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "mt900Wrapper", namespace = "PoslovnaXWS/Poruke")
public class MT900Wrapper {

	@XmlElement(name = "mt900")
	private MT900 mt900;

	public MT900 getWrappedParameter() {
		return mt900;
	}

	public void setWrappedParameter(MT900 wrappedParameter) {
		this.mt900 = wrappedParameter;
	}

}
