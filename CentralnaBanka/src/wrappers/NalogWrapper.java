package wrappers;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import util.EntityInfoUtil;
import util.MetaData;
import entity.Nalog;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "wrapper", namespace="")
public class NalogWrapper {

	@XmlElement(name = "data")
	private List<Nalog> wrappedElement;

	@XmlElement(name = "meta")
	private List<MetaData> meta = new ArrayList<MetaData>();
	
	public List<Nalog> getWrappedParameter() {
		return wrappedElement;
	}

	public void setWrappedParameter(List<Nalog> wrappedElement) {
		this.wrappedElement = wrappedElement;
	}

	public void setWrappedElement(List<Nalog> wrappedElement) {
		// TODO Auto-generated method stub
		this.wrappedElement = wrappedElement;
		meta = EntityInfoUtil.getFields(Nalog.class);
	}

}
