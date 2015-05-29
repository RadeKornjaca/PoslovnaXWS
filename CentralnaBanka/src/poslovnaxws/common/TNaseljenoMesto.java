
package poslovnaxws.common;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TNaseljenoMesto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TNaseljenoMesto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sifraMesta" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nazivMesta" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="drzava" type="{PoslovnaXWS/Common}TDrzava"/>
 *         &lt;element name="nalozi">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *                   &lt;element name="nalog" type="{PoslovnaXWS/Common}TNalog"/>
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
@XmlType(name = "TNaseljenoMesto", propOrder = {
    "sifraMesta",
    "nazivMesta",
    "drzava",
    "nalozi"
})
public class TNaseljenoMesto {

    @XmlElement(required = true)
    protected String sifraMesta;
    @XmlElement(required = true)
    protected String nazivMesta;
    @XmlElement(required = true)
    protected TDrzava drzava;
    @XmlElement(required = true)
    protected TNaseljenoMesto.Nalozi nalozi;

    /**
     * Gets the value of the sifraMesta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSifraMesta() {
        return sifraMesta;
    }

    /**
     * Sets the value of the sifraMesta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSifraMesta(String value) {
        this.sifraMesta = value;
    }

    /**
     * Gets the value of the nazivMesta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNazivMesta() {
        return nazivMesta;
    }

    /**
     * Sets the value of the nazivMesta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNazivMesta(String value) {
        this.nazivMesta = value;
    }

    /**
     * Gets the value of the drzava property.
     * 
     * @return
     *     possible object is
     *     {@link TDrzava }
     *     
     */
    public TDrzava getDrzava() {
        return drzava;
    }

    /**
     * Sets the value of the drzava property.
     * 
     * @param value
     *     allowed object is
     *     {@link TDrzava }
     *     
     */
    public void setDrzava(TDrzava value) {
        this.drzava = value;
    }

    /**
     * Gets the value of the nalozi property.
     * 
     * @return
     *     possible object is
     *     {@link TNaseljenoMesto.Nalozi }
     *     
     */
    public TNaseljenoMesto.Nalozi getNalozi() {
        return nalozi;
    }

    /**
     * Sets the value of the nalozi property.
     * 
     * @param value
     *     allowed object is
     *     {@link TNaseljenoMesto.Nalozi }
     *     
     */
    public void setNalozi(TNaseljenoMesto.Nalozi value) {
        this.nalozi = value;
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
    public static class Nalozi {

        protected List<TNalog> nalog;

        /**
         * Gets the value of the nalog property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the nalog property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getNalog().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TNalog }
         * 
         * 
         */
        public List<TNalog> getNalog() {
            if (nalog == null) {
                nalog = new ArrayList<TNalog>();
            }
            return this.nalog;
        }

    }

}
