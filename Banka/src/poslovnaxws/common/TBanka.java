
package poslovnaxws.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TBanka complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TBanka">
 *   &lt;complexContent>
 *     &lt;extension base="{PoslovnaXWS/Common}TKlijent">
 *       &lt;sequence>
 *         &lt;element name="swiftKod" type="{PoslovnaXWS/Common}\u0422SWIFTKod"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TBanka", propOrder = {
    "swiftKod"
})
public class TBanka
    extends TKlijent
{

    @XmlElement(required = true)
    protected String swiftKod;

    /**
     * Gets the value of the swiftKod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSwiftKod() {
        return swiftKod;
    }

    /**
     * Sets the value of the swiftKod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSwiftKod(String value) {
        this.swiftKod = value;
    }

}
