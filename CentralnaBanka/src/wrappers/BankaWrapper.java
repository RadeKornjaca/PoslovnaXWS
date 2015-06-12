package wrappers;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import util.EntityInfoUtil;
import util.MetaData;
import entity.Banka;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "wrapper", namespace="")
public class BankaWrapper {

	@XmlElement(name = "data")
	private List<Banka> wrappedElement;
	
	@XmlElement(name = "meta")
	private List<MetaData> meta = new ArrayList<MetaData>();

	public List<Banka> getWrappedParameter() {
		return wrappedElement;
	}

	public void setWrappedParameter(List<Banka> wrappedElement) {
		this.wrappedElement = wrappedElement;
		meta = EntityInfoUtil.getFields(Banka.class);
	}
	
	public void setWrappedElement(List<Banka> wrappedElement) {
		this.wrappedElement = wrappedElement;
		meta = EntityInfoUtil.getFields(Banka.class);
		
	}

}
