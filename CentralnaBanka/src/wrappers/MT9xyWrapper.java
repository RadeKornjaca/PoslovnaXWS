package wrappers;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import entity.Mt9xy;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "wrapper", namespace="")
public class MT9xyWrapper {

	@XmlElement(name = "data")
	private List<Mt9xy> wrappedElement;

	public List<Mt9xy> getWrappedParameter() {
		return wrappedElement;
	}

	public void setWrappedParameter(List<Mt9xy> wrappedElement) {
		this.wrappedElement = wrappedElement;
	}

}
