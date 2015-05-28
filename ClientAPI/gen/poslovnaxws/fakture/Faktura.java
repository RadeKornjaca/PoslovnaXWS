//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.05.27 at 10:40:27 PM CEST 
//


package poslovnaxws.fakture;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import poslovnaxws.common.TFirma;


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
 *         &lt;element name="zaglavlje">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="id">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="50"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="dobavljac" type="{PoslovnaXWS/Common}TFirma"/>
 *                   &lt;element name="kupac" type="{PoslovnaXWS/Common}TFirma"/>
 *                   &lt;element name="brojRacuna">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger">
 *                         &lt;totalDigits value="6"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="datumRacuna" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="vrednostRobe">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                         &lt;fractionDigits value="2"/>
 *                         &lt;totalDigits value="15"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="vrednostUsluge">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                         &lt;fractionDigits value="2"/>
 *                         &lt;totalDigits value="15"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="ukupnoRobaIUsluge">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                         &lt;fractionDigits value="2"/>
 *                         &lt;totalDigits value="15"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="ukupanRabat">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                         &lt;totalDigits value="15"/>
 *                         &lt;fractionDigits value="2"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="ukupanPorez">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                         &lt;fractionDigits value="2"/>
 *                         &lt;totalDigits value="15"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="oznakaValute">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{PoslovnaXWS/Common}TOznakaValute">
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="iznosZaUplatu">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                         &lt;fractionDigits value="2"/>
 *                         &lt;totalDigits value="15"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="uplataNaRacun" type="{PoslovnaXWS/Common}TRacun"/>
 *                   &lt;element name="datumValute" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="stavkeFakture">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="stavkaFakture" type="{PoslovnaXWS/Fakture}TStavkaFakture" maxOccurs="unbounded"/>
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
    "zaglavlje",
    "stavkeFakture"
})
@XmlRootElement(name = "faktura")
public class Faktura {

    @XmlElement(required = true)
    protected Faktura.Zaglavlje zaglavlje;
    @XmlElement(required = true)
    protected Faktura.StavkeFakture stavkeFakture;

    /**
     * Gets the value of the zaglavlje property.
     * 
     * @return
     *     possible object is
     *     {@link Faktura.Zaglavlje }
     *     
     */
    public Faktura.Zaglavlje getZaglavlje() {
        return zaglavlje;
    }

    /**
     * Sets the value of the zaglavlje property.
     * 
     * @param value
     *     allowed object is
     *     {@link Faktura.Zaglavlje }
     *     
     */
    public void setZaglavlje(Faktura.Zaglavlje value) {
        this.zaglavlje = value;
    }

    /**
     * Gets the value of the stavkeFakture property.
     * 
     * @return
     *     possible object is
     *     {@link Faktura.StavkeFakture }
     *     
     */
    public Faktura.StavkeFakture getStavkeFakture() {
        return stavkeFakture;
    }

    /**
     * Sets the value of the stavkeFakture property.
     * 
     * @param value
     *     allowed object is
     *     {@link Faktura.StavkeFakture }
     *     
     */
    public void setStavkeFakture(Faktura.StavkeFakture value) {
        this.stavkeFakture = value;
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
     *       &lt;sequence>
     *         &lt;element name="stavkaFakture" type="{PoslovnaXWS/Fakture}TStavkaFakture" maxOccurs="unbounded"/>
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
        "stavkaFakture"
    })
    public static class StavkeFakture {

        @XmlElement(required = true)
        protected List<TStavkaFakture> stavkaFakture;

        /**
         * Gets the value of the stavkaFakture property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the stavkaFakture property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getStavkaFakture().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TStavkaFakture }
         * 
         * 
         */
        public List<TStavkaFakture> getStavkaFakture() {
            if (stavkaFakture == null) {
                stavkaFakture = new ArrayList<TStavkaFakture>();
            }
            return this.stavkaFakture;
        }

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
     *       &lt;sequence>
     *         &lt;element name="id">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="50"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="dobavljac" type="{PoslovnaXWS/Common}TFirma"/>
     *         &lt;element name="kupac" type="{PoslovnaXWS/Common}TFirma"/>
     *         &lt;element name="brojRacuna">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger">
     *               &lt;totalDigits value="6"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="datumRacuna" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="vrednostRobe">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *               &lt;fractionDigits value="2"/>
     *               &lt;totalDigits value="15"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="vrednostUsluge">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *               &lt;fractionDigits value="2"/>
     *               &lt;totalDigits value="15"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ukupnoRobaIUsluge">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *               &lt;fractionDigits value="2"/>
     *               &lt;totalDigits value="15"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ukupanRabat">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *               &lt;totalDigits value="15"/>
     *               &lt;fractionDigits value="2"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ukupanPorez">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *               &lt;fractionDigits value="2"/>
     *               &lt;totalDigits value="15"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="oznakaValute">
     *           &lt;simpleType>
     *             &lt;restriction base="{PoslovnaXWS/Common}TOznakaValute">
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="iznosZaUplatu">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *               &lt;fractionDigits value="2"/>
     *               &lt;totalDigits value="15"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="uplataNaRacun" type="{PoslovnaXWS/Common}TRacun"/>
     *         &lt;element name="datumValute" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
        "dobavljac",
        "kupac",
        "brojRacuna",
        "datumRacuna",
        "vrednostRobe",
        "vrednostUsluge",
        "ukupnoRobaIUsluge",
        "ukupanRabat",
        "ukupanPorez",
        "oznakaValute",
        "iznosZaUplatu",
        "uplataNaRacun",
        "datumValute"
    })
    public static class Zaglavlje {

        @XmlElement(required = true)
        protected String id;
        @XmlElement(required = true)
        protected TFirma dobavljac;
        @XmlElement(required = true)
        protected TFirma kupac;
        @XmlElement(required = true)
        protected BigInteger brojRacuna;
        @XmlElement(required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar datumRacuna;
        @XmlElement(required = true)
        protected BigDecimal vrednostRobe;
        @XmlElement(required = true)
        protected BigDecimal vrednostUsluge;
        @XmlElement(required = true)
        protected BigDecimal ukupnoRobaIUsluge;
        @XmlElement(required = true)
        protected BigDecimal ukupanRabat;
        @XmlElement(required = true)
        protected BigDecimal ukupanPorez;
        @XmlElement(required = true)
        protected String oznakaValute;
        @XmlElement(required = true)
        protected BigDecimal iznosZaUplatu;
        @XmlElement(required = true)
        protected String uplataNaRacun;
        @XmlElement(required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar datumValute;

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
         * Gets the value of the dobavljac property.
         * 
         * @return
         *     possible object is
         *     {@link TFirma }
         *     
         */
        public TFirma getDobavljac() {
            return dobavljac;
        }

        /**
         * Sets the value of the dobavljac property.
         * 
         * @param value
         *     allowed object is
         *     {@link TFirma }
         *     
         */
        public void setDobavljac(TFirma value) {
            this.dobavljac = value;
        }

        /**
         * Gets the value of the kupac property.
         * 
         * @return
         *     possible object is
         *     {@link TFirma }
         *     
         */
        public TFirma getKupac() {
            return kupac;
        }

        /**
         * Sets the value of the kupac property.
         * 
         * @param value
         *     allowed object is
         *     {@link TFirma }
         *     
         */
        public void setKupac(TFirma value) {
            this.kupac = value;
        }

        /**
         * Gets the value of the brojRacuna property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getBrojRacuna() {
            return brojRacuna;
        }

        /**
         * Sets the value of the brojRacuna property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setBrojRacuna(BigInteger value) {
            this.brojRacuna = value;
        }

        /**
         * Gets the value of the datumRacuna property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDatumRacuna() {
            return datumRacuna;
        }

        /**
         * Sets the value of the datumRacuna property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDatumRacuna(XMLGregorianCalendar value) {
            this.datumRacuna = value;
        }

        /**
         * Gets the value of the vrednostRobe property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getVrednostRobe() {
            return vrednostRobe;
        }

        /**
         * Sets the value of the vrednostRobe property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setVrednostRobe(BigDecimal value) {
            this.vrednostRobe = value;
        }

        /**
         * Gets the value of the vrednostUsluge property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getVrednostUsluge() {
            return vrednostUsluge;
        }

        /**
         * Sets the value of the vrednostUsluge property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setVrednostUsluge(BigDecimal value) {
            this.vrednostUsluge = value;
        }

        /**
         * Gets the value of the ukupnoRobaIUsluge property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getUkupnoRobaIUsluge() {
            return ukupnoRobaIUsluge;
        }

        /**
         * Sets the value of the ukupnoRobaIUsluge property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setUkupnoRobaIUsluge(BigDecimal value) {
            this.ukupnoRobaIUsluge = value;
        }

        /**
         * Gets the value of the ukupanRabat property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getUkupanRabat() {
            return ukupanRabat;
        }

        /**
         * Sets the value of the ukupanRabat property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setUkupanRabat(BigDecimal value) {
            this.ukupanRabat = value;
        }

        /**
         * Gets the value of the ukupanPorez property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getUkupanPorez() {
            return ukupanPorez;
        }

        /**
         * Sets the value of the ukupanPorez property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setUkupanPorez(BigDecimal value) {
            this.ukupanPorez = value;
        }

        /**
         * Gets the value of the oznakaValute property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOznakaValute() {
            return oznakaValute;
        }

        /**
         * Sets the value of the oznakaValute property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOznakaValute(String value) {
            this.oznakaValute = value;
        }

        /**
         * Gets the value of the iznosZaUplatu property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getIznosZaUplatu() {
            return iznosZaUplatu;
        }

        /**
         * Sets the value of the iznosZaUplatu property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setIznosZaUplatu(BigDecimal value) {
            this.iznosZaUplatu = value;
        }

        /**
         * Gets the value of the uplataNaRacun property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUplataNaRacun() {
            return uplataNaRacun;
        }

        /**
         * Sets the value of the uplataNaRacun property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUplataNaRacun(String value) {
            this.uplataNaRacun = value;
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

    }

}
