package wrappers;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import entity.DnevnoStanjeRacuna;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "wrapper", namespace="")
public class DnevnoStanjeRacunaWrapper {

	@XmlElement(name = "data")
	private List<DnevnoStanjeRacuna> wrappedElement;

	public List<DnevnoStanjeRacuna> getWrappedParameter() {
		return wrappedElement;
	}

	public void setWrappedParameter(List<DnevnoStanjeRacuna> wrappedElement) {
		this.wrappedElement = wrappedElement;
	}

}
