package poslovnaxws.banke;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "presekWrapper", namespace = "PoslovnaXWS/Banke")
public class PresekWrapper {

	@XmlElement(name = "presek")
	private Presek presek;

	public Presek getWrappedParameter() {
		return presek;
	}

	public void setWrappedParameter(Presek wrappedParameter) {
		this.presek = wrappedParameter;
	}

}
