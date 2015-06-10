package wrappers;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import entity.StavkaPoruke;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "wrapper", namespace="")
public class StavkaPorukeWrapper {

	@XmlElement(name = "data")
	private List<StavkaPoruke> wrappedElement;

	public List<StavkaPoruke> getWrappedParameter() {
		return wrappedElement;
	}

	public void setWrappedParameter(List<StavkaPoruke> wrappedElement) {
		this.wrappedElement = wrappedElement;
	}

}
