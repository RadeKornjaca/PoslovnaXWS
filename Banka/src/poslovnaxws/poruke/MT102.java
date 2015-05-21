
package poslovnaxws.poruke;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import poslovnaxws.common.TBanka;
import poslovnaxws.common.TNalog;


/**
 * <p>Java class for MT102 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MT102">
 *   &lt;complexContent>
 *     &lt;extension base="{PoslovnaXWS/Poruke}TPoruka">
 *       &lt;sequence>
 *         &lt;element name="bankaDuznik" type="{PoslovnaXWS/Common}TBanka"/>
 *         &lt;element name="bankaPoverioc" type="{PoslovnaXWS/Common}TBanka"/>
 *         &lt;element name="ukupanIznos">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;totalDigits value="15"/>
 *               &lt;fractionDigits value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="sifraValute">
 *           &lt;simpleType>
 *             &lt;restriction base="{PoslovnaXWS/Common}TOznakaValute">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="datumValute" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="uplate">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence maxOccurs="unbounded">
 *                   &lt;element name="uplata" type="{PoslovnaXWS/Common}TNalog"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
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
@XmlType(name = "MT102", propOrder = {
    "bankaDuznik",
    "bankaPoverioc",
    "ukupanIznos",
    "sifraValute",
    "datumValute",
    "datum",
    "uplate"
})
public class MT102
    extends TPoruka
{

    @XmlElement(required = true)
    protected TBanka bankaDuznik;
    @XmlElement(required = true)
    protected TBanka bankaPoverioc;
    @XmlElement(required = true)
    protected BigDecimal ukupanIznos;
    @XmlElement(required = true)
    protected String sifraValute;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datumValute;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datum;
    @XmlElement(required = true)
    protected MT102 .Uplate uplate;

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

    /**
     * Gets the value of the ukupanIznos property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUkupanIznos() {
        return ukupanIznos;
    }

    /**
     * Sets the value of the ukupanIznos property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUkupanIznos(BigDecimal value) {
        this.ukupanIznos = value;
    }

    /**
     * Gets the value of the sifraValute property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSifraValute() {
        return sifraValute;
    }

    /**
     * Sets the value of the sifraValute property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSifraValute(String value) {
        this.sifraValute = value;
    }

    /**
     * Gets the value of the datumValute property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumValute() {
        return datumValute;
    }

    /**
     * Sets the value of the datumValute property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumValute(XMLGregorianCalendar value) {
        this.datumValute = value;
    }

    /**
     * Gets the value of the datum property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatum(XMLGregorianCalendar value) {
        this.datum = value;
    }

    /**
     * Gets the value of the uplate property.
     * 
     * @return
     *     possible object is
     *     {@link MT102 .Uplate }
     *     
     */
    public MT102 .Uplate getUplate() {
        return uplate;
    }

    /**
     * Sets the value of the uplate property.
     * 
     * @param value
     *     allowed object is
     *     {@link MT102 .Uplate }
     *     
     */
    public void setUplate(MT102 .Uplate value) {
        this.uplate = value;
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
     *       &lt;sequence maxOccurs="unbounded">
     *         &lt;element name="uplata" type="{PoslovnaXWS/Common}TNalog"/>
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
        "uplata"
    })
    public static class Uplate {

        @XmlElement(required = true)
        protected List<TNalog> uplata;

        /**
         * Gets the value of the uplata property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the uplata property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getUplata().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TNalog }
         * 
         * 
         */
        public List<TNalog> getUplata() {
            if (uplata == null) {
                uplata = new ArrayList<TNalog>();
            }
            return this.uplata;
        }

    }

}
