package poslovnaxws.poruke;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import entity.iface.Identifiable;


/**
 * JAX bean koji postoji jer odlična XML baza ne ume generiše id ključevima koji
 * nisu broj.
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "any"
})
@XmlRootElement(name = "poruka")
public class Poruka implements Identifiable{
	
	@XmlAttribute(name="id",required=true)
	protected Long id;
	
	public Poruka(){
		
	}
	
	public Poruka(Object any){
		this.any = any;
	}

    public String getId() {
		return String.valueOf(id);
	}

	public void setId(String id) {
		this.id = Long.parseLong(id);
	}

	@XmlAnyElement(lax = true)
    protected Object any;

    /**
     * Gets the value of the any property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getAny() {
        return any;
    }

    /**
     * Sets the value of the any property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setAny(Object value) {
        this.any = value;
    }

}
