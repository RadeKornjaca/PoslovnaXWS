package wrappers;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import entity.Banka;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "wrapper", namespace="")
public class BankaWrapper {

	@XmlElement(name = "data")
	private List<Banka> wrappedElement;

	public List<Banka> getWrappedParameter() {
		return wrappedElement;
	}

	public void setWrappedParameter(List<Banka> wrappedElement) {
		this.wrappedElement = wrappedElement;
	}

}
