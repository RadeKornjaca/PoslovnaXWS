
package poslovnaxws.common;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TDrzava complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TDrzava">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sifraDrzave" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nazivDrzave" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="naseljenaMesta">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *                   &lt;element name="naseljenoMesto" type="{PoslovnaXWS/Common}TNaseljenoMesto"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TDrzava", propOrder = {
    "sifraDrzave",
    "nazivDrzave",
    "naseljenaMesta"
})
public class TDrzava {

    @XmlElement(required = true)
    protected String sifraDrzave;
    @XmlElement(required = true)
    protected String nazivDrzave;
    @XmlElement(required = true)
    protected TDrzava.NaseljenaMesta naseljenaMesta;

    /**
     * Gets the value of the sifraDrzave property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSifraDrzave() {
        return sifraDrzave;
    }

    /**
     * Sets the value of the sifraDrzave property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSifraDrzave(String value) {
        this.sifraDrzave = value;
    }

    /**
     * Gets the value of the nazivDrzave property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNazivDrzave() {
        return nazivDrzave;
    }

    /**
     * Sets the value of the nazivDrzave property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNazivDrzave(String value) {
        this.nazivDrzave = value;
    }

    /**
     * Gets the value of the naseljenaMesta property.
     * 
     * @return
     *     possible object is
     *     {@link TDrzava.NaseljenaMesta }
     *     
     */
    public TDrzava.NaseljenaMesta getNaseljenaMesta() {
        return naseljenaMesta;
    }

    /**
     * Sets the value of the naseljenaMesta property.
     * 
     * @param value
     *     allowed object is
     *     {@link TDrzava.NaseljenaMesta }
     *     
     */
    public void setNaseljenaMesta(TDrzava.NaseljenaMesta value) {
        this.naseljenaMesta = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
     *         &lt;element name="naseljenoMesto" type="{PoslovnaXWS/Common}TNaseljenoMesto"/>
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
        "naseljenoMesto"
    })
    public static class NaseljenaMesta {

        protected List<TNaseljenoMesto> naseljenoMesto;

        /**
         * Gets the value of the naseljenoMesto property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the naseljenoMesto property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getNaseljenoMesto().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TNaseljenoMesto }
         * 
         * 
         */
        public List<TNaseljenoMesto> getNaseljenoMesto() {
            if (naseljenoMesto == null) {
                naseljenoMesto = new ArrayList<TNaseljenoMesto>();
            }
            return this.naseljenoMesto;
        }

    }

}
