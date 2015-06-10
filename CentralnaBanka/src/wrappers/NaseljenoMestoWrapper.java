package wrappers;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import entity.NaseljenoMesto;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "wrapper", namespace="")
public class NaseljenoMestoWrapper {

	@XmlElement(name = "data")
	private List<NaseljenoMesto> wrappedElement;

	public List<NaseljenoMesto> getWrappedParameter() {
		return wrappedElement;
	}

	public void setWrappedParameter(List<NaseljenoMesto> wrappedElement) {
		this.wrappedElement = wrappedElement;
	}

}
