package wrappers;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import util.EntityInfoUtil;
import util.MetaData;
import entity.RacunBanke;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "wrapper", namespace="")
public class RacunBankeWrapper {

	@XmlElement(name = "data")
	private List<RacunBanke> wrappedElement;
	
	@XmlElement(name = "meta")
	private List<MetaData> meta = new ArrayList<MetaData>();


	public List<RacunBanke> getWrappedParameter() {
		return wrappedElement;
	}

	public void setWrappedParameter(List<RacunBanke> wrappedElement) {
		this.wrappedElement = wrappedElement;
	}

	public void setWrappedElement(List<RacunBanke> wrappedElement) {
		this.wrappedElement = wrappedElement;
		meta = EntityInfoUtil.getFields(RacunBanke.class);
	}

}
