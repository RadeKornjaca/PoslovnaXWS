package wrappers;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import entity.Nalog;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "wrapper", namespace="")
public class NalogWrapper {

	@XmlElement(name = "data")
	private List<Nalog> wrappedElement;

	public List<Nalog> getWrappedParameter() {
		return wrappedElement;
	}

	public void setWrappedParameter(List<Nalog> wrappedElement) {
		this.wrappedElement = wrappedElement;
	}

}
