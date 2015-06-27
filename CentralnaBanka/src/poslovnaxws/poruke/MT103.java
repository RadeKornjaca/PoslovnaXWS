
package poslovnaxws.poruke;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import entity.Mt10x;
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
 *         &lt;element name="uplata" type="{PoslovnaXWS/Common}TNalog"/>
 *         &lt;element name="bankaDuznik" type="{PoslovnaXWS/Common}TBanka"/>
 *         &lt;element name="bankaPoverioc" type="{PoslovnaXWS/Common}TBanka"/>
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
    "uplata",
    "bankaDuznik",
    "bankaPoverioc"
})
@XmlRootElement(name = "MT103")
public class MT103 {

    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected TNalog uplata;
    @XmlElement(required = true)
    protected TBanka bankaDuznik;
    @XmlElement(required = true)
    protected TBanka bankaPoverioc;

    public MT103(){
    	super();
    }
    
    public MT103(Mt10x mt10x) {
    	StavkaPoruke[] sp = ((StavkaPoruke[]) mt10x.getStavkaPoruke().toArray());
    	
    	this.bankaDuznik = new TBanka(mt10x.getRacunBankeDuznika(),Integer.valueOf(sp[0].getNalog().getModelZaduzenja()), sp[0].getNalog().getPozivNaBrojZaduzenja());
    	this.bankaPoverioc = new TBanka(mt10x.getRacunBankePoverioca(),Integer.valueOf(sp[0].getNalog().getModelOdobrenja()), sp[0].getNalog().getPozivNaBrojOdobrenja());
    	this.id = mt10x.getIdPoruke().toString();
    	List<TNalog> naloziZaUplate = new ArrayList<TNalog>();
    	TNalog tnalog;
    	for(int i =0; i<sp.length; i++){
    		tnalog = new TNalog(sp[i].getNalog());
    		naloziZaUplate.add(tnalog);
    	}
    	this.uplata = new TNalog(sp[0].getNalog());
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
