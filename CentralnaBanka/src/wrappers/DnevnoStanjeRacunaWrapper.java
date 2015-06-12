package wrappers;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import util.EntityInfoUtil;
import util.MetaData;
import entity.DnevnoStanjeRacuna;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "wrapper", namespace="")
public class DnevnoStanjeRacunaWrapper {

	@XmlElement(name = "data")
	private List<DnevnoStanjeRacuna> wrappedElement;
	
	@XmlElement(name = "meta")
	private List<MetaData> meta = new ArrayList<MetaData>();

	public List<DnevnoStanjeRacuna> getWrappedParameter() {
		return wrappedElement;
	}

	public void setWrappedParameter(List<DnevnoStanjeRacuna> wrappedElement) {
		this.wrappedElement = wrappedElement;
		meta = EntityInfoUtil.getFields(DnevnoStanjeRacuna.class);
	}

	public void setWrappedElement(List<DnevnoStanjeRacuna> wrappedElement) {
		this.wrappedElement = wrappedElement;
		meta = EntityInfoUtil.getFields(DnevnoStanjeRacuna.class);
		
	}
	
}
