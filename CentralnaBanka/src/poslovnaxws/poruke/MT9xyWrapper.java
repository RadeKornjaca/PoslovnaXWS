package poslovnaxws.poruke;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import util.EntityInfoUtil;
import util.MetaData;
import entity.DnevnoStanjeRacuna;
import entity.Mt9xy;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "wrapper", namespace = "PoslovnaXWS/Poruke")
public class MT9xyWrapper {

	@XmlElement(name = "data")
	private List<Mt9xy> wrappedElement;
	
	@XmlElement(name = "meta")
	private List<MetaData> meta = new ArrayList<MetaData>();

	public List<Mt9xy> getWrappedParameter() {
		return wrappedElement;
	}

	public void setWrappedParameter(List<Mt9xy> wrappedElement) {
		this.wrappedElement = wrappedElement;
		meta = EntityInfoUtil.getFields(Mt9xy.class);
	}

	public void setWrappedElement(List<Mt9xy> wrappedElement) {
		this.wrappedElement = wrappedElement;
		meta = EntityInfoUtil.getFields(Mt9xy.class);
		
	}

}
