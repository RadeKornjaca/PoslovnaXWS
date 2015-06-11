package wrappers;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import util.EntityInfoUtil;
import util.MetaData;
import entity.StavkaPoruke;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "wrapper", namespace="")
public class StavkaPorukeWrapper {

	@XmlElement(name = "data")
	private List<StavkaPoruke> wrappedElement;

	@XmlElement(name = "meta")
	private List<MetaData> meta = new ArrayList<MetaData>();
	
	public List<StavkaPoruke> getWrappedParameter() {
		return wrappedElement;
	}

	public void setWrappedParameter(List<StavkaPoruke> wrappedElement) {
		this.wrappedElement = wrappedElement;
	}

	public void setWrappedElement(List<StavkaPoruke> wrappedElement) {
		// TODO Auto-generated method stub
		this.wrappedElement = wrappedElement;
		meta = EntityInfoUtil.getFields(StavkaPoruke.class);
	}

}
