package poslovnaxws.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "statusWrapper", namespace = "PoslovnaXWS/Common")
public class StatusWrapper {

	@XmlElement(name = "status")
	private Status status;

	public Status getWrappedParameter() {
		return status;
	}

	public void setWrappedParameter(Status wrappedParameter) {
		this.status = wrappedParameter;
	}

}
