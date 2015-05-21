
package poslovnaxws.poruke;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import poslovnaxws.common.TBanka;
import poslovnaxws.common.TNalog;


/**
 * <p>Java class for MT103 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MT103">
 *   &lt;complexContent>
 *     &lt;extension base="{PoslovnaXWS/Poruke}TPoruka">
 *       &lt;sequence>
 *         &lt;element name="uplata" type="{PoslovnaXWS/Common}TNalog"/>
 *         &lt;element name="bankaDuznik" type="{PoslovnaXWS/Common}TBanka"/>
 *         &lt;element name="bankaPoverioc" type="{PoslovnaXWS/Common}TBanka"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MT103", propOrder = {
    "uplata",
    "bankaDuznik",
    "bankaPoverioc"
})
public class MT103
    extends TPoruka
{

    @XmlElement(required = true)
    protected TNalog uplata;
    @XmlElement(required = true)
    protected TBanka bankaDuznik;
    @XmlElement(required = true)
    protected TBanka bankaPoverioc;

    /**
     * Gets the value of the uplata property.
     * 
     * @return
     *     possible object is
     *     {@link TNalog }
     *     
     */
    public TNalog getUplata() {
        return uplata;
    }

    /**
     * Sets the value of the uplata property.
     * 
     * @param value
     *     allowed object is
     *     {@link TNalog }
     *     
     */
    public void setUplata(TNalog value) {
        this.uplata = value;
    }

    /**
     * Gets the value of the bankaDuznik property.
     * 
     * @return
     *     possible object is
     *     {@link TBanka }
     *     
     */
    public TBanka getBankaDuznik() {
        return bankaDuznik;
    }

    /**
     * Sets the value of the bankaDuznik property.
     * 
     * @param value
     *     allowed object is
     *     {@link TBanka }
     *     
     */
    public void setBankaDuznik(TBanka value) {
        this.bankaDuznik = value;
    }

    /**
     * Gets the value of the bankaPoverioc property.
     * 
     * @return
     *     possible object is
     *     {@link TBanka }
     *     
     */
    public TBanka getBankaPoverioc() {
        return bankaPoverioc;
    }

    /**
     * Sets the value of the bankaPoverioc property.
     * 
     * @param value
     *     allowed object is
     *     {@link TBanka }
     *     
     */
    public void setBankaPoverioc(TBanka value) {
        this.bankaPoverioc = value;
    }

}
