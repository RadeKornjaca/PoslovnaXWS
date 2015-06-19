package wrappers;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import util.EntityInfoUtil;
import util.MetaData;
import entity.Drzava;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "wrapper", namespace="")
public class DrzavaWrapper {

	@XmlElement(name = "data")
	private List<Drzava> wrappedElement = new ArrayList<Drzava>();
	
	@XmlElement(name = "meta")
	private List<MetaData> meta = new ArrayList<MetaData>();
	
	public DrzavaWrapper(){
		meta = EntityInfoUtil.getFields(Drzava.class);
	}

	public List<MetaData> getMeta() {
		return meta;
	}
	public List<Drzava> getWrappedElement() {
		return wrappedElement;
	}

	public void setWrappedElement(List<Drzava> wrappedElement) {
		this.wrappedElement = wrappedElement;
	}

	public void setMeta(List<MetaData> meta) {
		this.meta = meta;
	}

}
