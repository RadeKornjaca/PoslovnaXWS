package wrappers;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import util.EntityInfoUtil;
import util.MetaData;
import entity.Poruka;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "wrapper", namespace="")
public class PorukaWrapper {

	@XmlElement(name = "data")
	private List<Poruka> wrappedElement;
	@XmlElement(name = "meta")
	private List<MetaData> meta = new ArrayList<MetaData>();


	public List<Poruka> getWrappedParameter() {
		return wrappedElement;
	}

	public void setWrappedParameter(List<Poruka> wrappedElement) {
		this.wrappedElement = wrappedElement;
		meta = EntityInfoUtil.getFields(Poruka.class);
	}

	public void setWrappedElement(List<Poruka> wrappedElement) {
		// TODO Auto-generated method stub
		this.wrappedElement = wrappedElement;
		meta = EntityInfoUtil.getFields(Poruka.class);
	}

}
