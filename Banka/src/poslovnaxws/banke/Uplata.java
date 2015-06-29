package poslovnaxws.banke;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import entity.iface.Identifiable;
import poslovnaxws.common.TNalog;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nalog" type="{PoslovnaXWS/Common}TNalog"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "nalog" })
@XmlRootElement(name = "uplata", namespace = "PoslovnaXWS/Banke")
public class Uplata implements Identifiable {

	@XmlAttribute(required = false, name = "id")
	protected Long id;

	@XmlAttribute(required = false, name = "settled")
	protected boolean settled;

	@XmlElement(required = true)
	protected TNalog nalog;

	/**
	 * Gets the value of the nalog property.
	 * 
	 * @return possible object is {@link TNalog }
	 * 
	 */
	public TNalog getNalog() {
		return nalog;
	}

	/**
	 * Sets the value of the nalog property.
	 * 
	 * @param value
	 *            allowed object is {@link TNalog }
	 * 
	 */
	public void setNalog(TNalog value) {
		this.nalog = value;
	}

	@Override
	public String getId() {
		if (id != null)
			return id.toString();
		else
			return null;
	}

	@Override
	public void setId(String value) {
		if (value != null)
			id = Long.parseLong(value);
		else
			id = null;

	}

	public boolean isSettled() {
		return settled;
	}

	public void setSettled(boolean settled) {
		this.settled = settled;
	}

}
