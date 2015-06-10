package wrappers;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import entity.Poruka;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "wrapper", namespace="")
public class PorukaWrapper {

	@XmlElement(name = "data")
	private List<Poruka> wrappedElement;

	public List<Poruka> getWrappedParameter() {
		return wrappedElement;
	}

	public void setWrappedParameter(List<Poruka> wrappedElement) {
		this.wrappedElement = wrappedElement;
	}

}
