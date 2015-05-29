
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
 *         &lt;element name="sifra">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="999"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
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
    "swiftKod",
    "sifra"
})
public class TBanka
    extends TKlijent
{

    @XmlElement(required = true)
    protected String swiftKod;
    protected int sifra;

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

    /**
     * Gets the value of the sifra property.
     * 
     */
    public int getSifra() {
        return sifra;
    }

    /**
     * Sets the value of the sifra property.
     * 
     */
    public void setSifra(int value) {
        this.sifra = value;
    }

}
