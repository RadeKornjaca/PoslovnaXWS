package wrappers;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import util.EntityInfoUtil;
import util.MetaData;
import entity.NaseljenoMesto;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "wrapper", namespace="")
public class NaseljenoMestoWrapper {

	@XmlElement(name = "data")
	private List<NaseljenoMesto> wrappedElement;
	
	@XmlElement(name = "meta")
	private List<MetaData> meta = new ArrayList<MetaData>();

	public List<NaseljenoMesto> getWrappedParameter() {
		return wrappedElement;
	}

	public void setWrappedParameter(List<NaseljenoMesto> wrappedElement) {
		this.wrappedElement = wrappedElement;
	}

	public void setWrappedElement(List<NaseljenoMesto> wrappedElement) {
		// TODO Auto-generated method stub
		this.wrappedElement = wrappedElement;
		meta = EntityInfoUtil.getFields(NaseljenoMesto.class);
	}

}
