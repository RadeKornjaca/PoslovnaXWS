package wrappers;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import entity.Mt10x;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "wrapper", namespace="")
public class MT10xWrapper {

	@XmlElement(name = "data")
	private List<Mt10x> wrappedElement;

	public List<Mt10x> getWrappedParameter() {
		return wrappedElement;
	}

	public void setWrappedParameter(List<Mt10x> wrappedElement) {
		this.wrappedElement = wrappedElement;
	}

}
