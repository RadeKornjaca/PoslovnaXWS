
package poslovnaxws.banke;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import poslovnaxws.common.TNalog;
import wrapper.UplataResponse;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
@XmlType(name = "", propOrder = {
    "nalog"
})
@XmlRootElement(name = "uplata", namespace="PoslovnaXWS/Banke")
public class Uplata {

    @XmlElement(required = true)
    protected TNalog nalog;
    
    public Uplata(){
    	
    }

    public Uplata(UplataResponse uplataResponse) {
		nalog = uplataResponse.getNalog();
	}

	/**
     * Gets the value of the nalog property.
     * 
     * @return
     *     possible object is
     *     {@link TNalog }
     *     
     */
    public TNalog getNalog() {
        return nalog;
    }

    /**
     * Sets the value of the nalog property.
     * 
     * @param value
     *     allowed object is
     *     {@link TNalog }
     *     
     */
    public void setNalog(TNalog value) {
        this.nalog = value;
    }

}
