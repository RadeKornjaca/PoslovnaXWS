package wrappers;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import entity.RacunBanke;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "wrapper", namespace="")
public class RacunBankeWrapper {

	@XmlElement(name = "data")
	private List<RacunBanke> wrappedElement;

	public List<RacunBanke> getWrappedParameter() {
		return wrappedElement;
	}

	public void setWrappedParameter(List<RacunBanke> wrappedElement) {
		this.wrappedElement = wrappedElement;
	}

}
