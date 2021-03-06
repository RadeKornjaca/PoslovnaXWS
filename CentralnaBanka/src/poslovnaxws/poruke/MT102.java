
package poslovnaxws.poruke;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import entity.Mt10x;
import entity.Mt9xy;
import entity.Nalog;
import entity.StavkaPoruke;
import poslovnaxws.common.TBanka;
import poslovnaxws.common.TNalog;


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
 *         &lt;element name="id">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
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
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "bankaDuznik",
    "bankaPoverioc",
    "ukupanIznos",
    "sifraValute",
    "datumValute",
    "datum",
    "uplate"
})
@XmlRootElement(name = "MT102")
public class MT102 {

    @XmlElement(required = true)
    protected String id;
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

    public MT102(){
    	super();
    }
    
    public MT102(Mt10x mt10x) {
		// TODO Auto-generated constructor stub
    	StavkaPoruke[] sp = ((StavkaPoruke[]) mt10x.getStavkaPoruke().toArray());
    	
    	this.bankaDuznik = new TBanka(mt10x.getRacunBankeDuznika(),Integer.valueOf(sp[0].getNalog().getModelZaduzenja()), sp[0].getNalog().getPozivNaBrojZaduzenja());
    	this.bankaPoverioc = new TBanka(mt10x.getRacunBankePoverioca(),Integer.valueOf(sp[0].getNalog().getModelOdobrenja()), sp[0].getNalog().getPozivNaBrojOdobrenja());
    	
    	Date datumTemp = mt10x.getDatumPoruke();
		XMLGregorianCalendar datum;
		try {
			
			datum = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(
					datumTemp.getYear(), datumTemp.getMonth(),
					datumTemp.getDay(), DatatypeConstants.FIELD_UNDEFINED);
			this.datum = datum;
			datumTemp = new Date();
			datum = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(
					datumTemp.getYear(), datumTemp.getMonth(),
					datumTemp.getDay(), DatatypeConstants.FIELD_UNDEFINED);
			this.datumValute = datum;
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
    	this.id = mt10x.getIdPoruke().toString();
    	this.sifraValute = mt10x.getSifraValutePoruke();
    	this.ukupanIznos = new BigDecimal(mt10x.getUkupanIznos());
    	List<TNalog> naloziZaUplate = new ArrayList<TNalog>();
    	TNalog tnalog;
    	for(int i =0; i<sp.length; i++){
    		tnalog = new TNalog(sp[i].getNalog());
    		naloziZaUplate.add(tnalog);
    	}
    	this.uplate.uplata = naloziZaUplate;
    	
	}

	/**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
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
