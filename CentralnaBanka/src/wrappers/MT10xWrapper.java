package wrappers;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import util.EntityInfoUtil;
import util.MetaData;
import entity.Mt10x;
import entity.NaseljenoMesto;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "wrapper", namespace="")
public class MT10xWrapper {

	@XmlElement(name = "data")
	private List<Mt10x> wrappedElement = new ArrayList<Mt10x>();
	
	@XmlElement(name = "meta")
	private List<MetaData> meta = new ArrayList<MetaData>();

	public List<Mt10x> getWrappedElement() {
		return wrappedElement;
	}

	public void setWrappedElement(List<Mt10x> wrappedElement) {
		if (wrappedElement != null)
			this.wrappedElement = wrappedElement;
		meta = EntityInfoUtil.getFields(Mt10x.class);
	}

	public List<MetaData> getMeta() {
		return meta;
	}

	public void setMeta(List<MetaData> meta) {
		this.meta = meta;
	}

	public List<Mt10x> getWrappedParameter() {
		return wrappedElement;
	}


}
