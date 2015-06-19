package wrappers;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import util.EntityInfoUtil;
import util.MetaData;
import entity.Mt9xy;
import entity.NaseljenoMesto;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "wrapper", namespace="")
public class MT9xyWrapper {

	@XmlElement(name = "data")
	private List<Mt9xy> wrappedElement = new ArrayList<Mt9xy>();
	
	@XmlElement(name = "meta")
	private List<MetaData> meta = new ArrayList<MetaData>();

	public List<Mt9xy> getWrappedElement() {
		return wrappedElement;
	}


	public List<MetaData> getMeta() {
		return meta;
	}

	public void setMeta(List<MetaData> meta) {
		this.meta = meta;
	}

	public List<Mt9xy> getWrappedParameter() {
		return wrappedElement;
	}

	public void setWrappedElement(List<Mt9xy> wrappedElement) {
		this.wrappedElement = wrappedElement;
		meta = EntityInfoUtil.getFields(Mt9xy.class);
		
	}

}
