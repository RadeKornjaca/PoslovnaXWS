package poslovnaxws.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "nalogWrapper", namespace = "PoslovnaXWS/Common")
public class NalogWrapper {

	@XmlElement(name = "nalog")
	private TNalog nalog;

	public TNalog getWrappedParameter() {
		return nalog;
	}

	public void setWrappedParameter(TNalog wrappedParameter) {
		this.nalog = wrappedParameter;
	}

}
