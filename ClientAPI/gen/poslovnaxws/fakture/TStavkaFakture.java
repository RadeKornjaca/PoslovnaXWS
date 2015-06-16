//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.06.15 at 07:34:30 PM CEST 
//


package poslovnaxws.fakture;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TStavkaFakture complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TStavkaFakture">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RedniBroj">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger">
 *               &lt;totalDigits value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="NazivUsluge">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="120"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Kolicina">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;totalDigits value="10"/>
 *               &lt;fractionDigits value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="JedinicaMere">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="[a-z]{1,6}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="JedinicnaCena">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;totalDigits value="10"/>
 *               &lt;fractionDigits value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Vrednost">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;totalDigits value="12"/>
 *               &lt;fractionDigits value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ProcenatRabata">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;totalDigits value="5"/>
 *               &lt;fractionDigits value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="IznosRabata">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="2"/>
 *               &lt;totalDigits value="12"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="UmanjenoZarabat">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;totalDigits value="12"/>
 *               &lt;fractionDigits value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="UkupanPorez">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;totalDigits value="12"/>
 *               &lt;fractionDigits value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
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
@XmlType(name = "TStavkaFakture", propOrder = {
    "redniBroj",
    "nazivUsluge",
    "kolicina",
    "jedinicaMere",
    "jedinicnaCena",
    "vrednost",
    "procenatRabata",
    "iznosRabata",
    "umanjenoZarabat",
    "ukupanPorez"
})
public class TStavkaFakture {

    @XmlElement(name = "RedniBroj", required = true)
    protected BigInteger redniBroj;
    @XmlElement(name = "NazivUsluge", required = true)
    protected String nazivUsluge;
    @XmlElement(name = "Kolicina", required = true)
    protected BigDecimal kolicina;
    @XmlElement(name = "JedinicaMere", required = true)
    protected String jedinicaMere;
    @XmlElement(name = "JedinicnaCena", required = true)
    protected BigDecimal jedinicnaCena;
    @XmlElement(name = "Vrednost", required = true)
    protected BigDecimal vrednost;
    @XmlElement(name = "ProcenatRabata", required = true)
    protected BigDecimal procenatRabata;
    @XmlElement(name = "IznosRabata", required = true)
    protected BigDecimal iznosRabata;
    @XmlElement(name = "UmanjenoZarabat", required = true)
    protected BigDecimal umanjenoZarabat;
    @XmlElement(name = "UkupanPorez", required = true)
    protected BigDecimal ukupanPorez;

    /**
     * Gets the value of the redniBroj property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRedniBroj() {
        return redniBroj;
    }

    /**
     * Sets the value of the redniBroj property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRedniBroj(BigInteger value) {
        this.redniBroj = value;
    }

    /**
     * Gets the value of the nazivUsluge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNazivUsluge() {
        return nazivUsluge;
    }

    /**
     * Sets the value of the nazivUsluge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNazivUsluge(String value) {
        this.nazivUsluge = value;
    }

    /**
     * Gets the value of the kolicina property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getKolicina() {
        return kolicina;
    }

    /**
     * Sets the value of the kolicina property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setKolicina(BigDecimal value) {
        this.kolicina = value;
    }

    /**
     * Gets the value of the jedinicaMere property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJedinicaMere() {
        return jedinicaMere;
    }

    /**
     * Sets the value of the jedinicaMere property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJedinicaMere(String value) {
        this.jedinicaMere = value;
    }

    /**
     * Gets the value of the jedinicnaCena property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getJedinicnaCena() {
        return jedinicnaCena;
    }

    /**
     * Sets the value of the jedinicnaCena property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setJedinicnaCena(BigDecimal value) {
        this.jedinicnaCena = value;
    }

    /**
     * Gets the value of the vrednost property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVrednost() {
        return vrednost;
    }

    /**
     * Sets the value of the vrednost property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVrednost(BigDecimal value) {
        this.vrednost = value;
    }

    /**
     * Gets the value of the procenatRabata property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getProcenatRabata() {
        return procenatRabata;
    }

    /**
     * Sets the value of the procenatRabata property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setProcenatRabata(BigDecimal value) {
        this.procenatRabata = value;
    }

    /**
     * Gets the value of the iznosRabata property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIznosRabata() {
        return iznosRabata;
    }

    /**
     * Sets the value of the iznosRabata property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIznosRabata(BigDecimal value) {
        this.iznosRabata = value;
    }

    /**
     * Gets the value of the umanjenoZarabat property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUmanjenoZarabat() {
        return umanjenoZarabat;
    }

    /**
     * Sets the value of the umanjenoZarabat property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUmanjenoZarabat(BigDecimal value) {
        this.umanjenoZarabat = value;
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

}
