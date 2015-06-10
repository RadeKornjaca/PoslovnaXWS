package wrappers;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import entity.Drzava;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "wrapper", namespace="")
public class DrzavaWrapper {

	@XmlElement(name = "data")
	private List<Drzava> wrappedElement;

	public List<Drzava> getWrappedParameter() {
		return wrappedElement;
	}

	public void setWrappedParameter(List<Drzava> wrappedElement) {
		this.wrappedElement = wrappedElement;
	}

}
