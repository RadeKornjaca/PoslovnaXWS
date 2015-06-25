package poslovnaxws.poruke;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "mt910Wrapper", namespace = "PoslovnaXWS/Poruke")
public class MT910Wrapper {

	@XmlElement(name = "mt910")
	private MT910 mt910;

	public MT910 getWrappedParameter() {
		return mt910;
	}

	public void setWrappedParameter(MT910 wrappedParameter) {
		this.mt910 = wrappedParameter;
	}

}
