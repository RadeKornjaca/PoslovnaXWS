package wrappers;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import poslovnaxws.banke.ZahtevZaIzvod;
import util.MetaData;

import com.fasterxml.jackson.databind.node.ObjectNode;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "wrapper", namespace = "")
public class Wrapper {

	@XmlElement(name = "data")
	private List<ObjectNode> data = new ArrayList<ObjectNode>();

	@XmlElement(name = "meta")
	private List<MetaData> meta = new ArrayList<MetaData>();

	public List<MetaData> getMeta() {
		return meta;
	}

	public void setMeta(List<MetaData> meta) {
		this.meta = meta;
	}

	public List<ObjectNode> getData() {
		return data;
	}

	public void setData(List<ObjectNode> data) {
		this.data = data;
	}

	public void addData(ObjectNode data) {
		this.data.add(data);
	}
}
