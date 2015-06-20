package util;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "json", namespace="")
public class MyJsonNode extends ObjectNode{

	public MyJsonNode(JsonNodeFactory arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
