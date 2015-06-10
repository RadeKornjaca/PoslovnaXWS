package wrappers;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import entity.StavkaDnevnogRacuna;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "wrapper", namespace="")
public class StavkaDnevnogRacunaWrapper {

	@XmlElement(name = "data")
	private List<StavkaDnevnogRacuna> wrappedElement;

	public List<StavkaDnevnogRacuna> getWrappedParameter() {
		return wrappedElement;
	}

	public void setWrappedParameter(List<StavkaDnevnogRacuna> wrappedElement) {
		this.wrappedElement = wrappedElement;
	}

}
