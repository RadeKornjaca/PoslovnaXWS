package poslovnaxws.poruke;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "mt102Wrapper", namespace = "PoslovnaXWS/Poruke")
public class MT102Wrapper {

	@XmlElement(name = "mt102")
	private MT102 mt102;

	public MT102 getWrappedParameter() {
		return mt102;
	}

	public void setWrappedParameter(MT102 wrappedParameter) {
		this.mt102 = wrappedParameter;
	}

}
