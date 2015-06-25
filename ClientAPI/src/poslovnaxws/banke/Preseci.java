package poslovnaxws.banke;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import entity.iface.Identifiable;

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
 *         &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;sequence maxOccurs="unbounded">
 *           &lt;element ref="{PoslovnaXWS/Banke}presek"/>
 *         &lt;/sequence>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "datum", "presek" })
@XmlRootElement(name = "preseci", namespace = "PoslovnaXWS/Banke")
public class Preseci{

	@XmlElement(required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar datum;
	@XmlElement(required = true)
	protected List<Presek> presek = new ArrayList<Presek>();

	/**
	 * Gets the value of the datum property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getDatum() {
		return datum;
	}

	/**
	 * Sets the value of the datum property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setDatum(XMLGregorianCalendar value) {
		this.datum = value;
	}

	/**
	 * Gets the value of the presek property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the presek property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getPresek().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Presek }
	 * 
	 * 
	 */
	public List<Presek> getPresek() {
		if (presek == null) {
			presek = new ArrayList<Presek>();
		}
		return this.presek;
	}

	public String getId() {
		return datum.toString();
	}

	public void setId(String value) {
		// TODO Auto-generated method stub

	}

}
