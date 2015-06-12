package wrappers;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import util.EntityInfoUtil;
import util.MetaData;
import entity.StavkaDnevnogRacuna;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "wrapper", namespace="")
public class StavkaDnevnogRacunaWrapper {

	@XmlElement(name = "data")
	private List<StavkaDnevnogRacuna> wrappedElement;

	@XmlElement(name = "meta")
	private List<MetaData> meta = new ArrayList<MetaData>();
	
	public List<StavkaDnevnogRacuna> getWrappedParameter() {
		return wrappedElement;
	}

	public void setWrappedParameter(List<StavkaDnevnogRacuna> wrappedElement) {
		this.wrappedElement = wrappedElement;
	}

	public void setWrappedElement(List<StavkaDnevnogRacuna> wrappedElement) {
		// TODO Auto-generated method stub
		this.wrappedElement = wrappedElement;
		meta = EntityInfoUtil.getFields(StavkaDnevnogRacuna.class);
	}

}
