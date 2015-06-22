package poslovnaxws.poruke;

import java.math.BigDecimal;
import java.util.Date;

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

import poslovnaxws.common.TBanka;
import entity.Mt9xy;
import entity.Nalog;
import entity.StavkaPoruke;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
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
 *         &lt;element name="banka" type="{PoslovnaXWS/Common}TBanka"/>
 *         &lt;element name="idPorukeNaloga">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="datumValute" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="iznos">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="2"/>
 *               &lt;totalDigits value="15"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="sifraValute" type="{PoslovnaXWS/Common}TOznakaValute"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "id", "banka", "idPorukeNaloga",
		"datumValute", "iznos", "sifraValute" })
@XmlRootElement(name = "MT900")
public class MT900 {

	@XmlElement(required = true)
	protected String id;
	@XmlElement(required = true)
	protected TBanka banka;
	@XmlElement(required = true)
	protected String idPorukeNaloga;
	@XmlElement(required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar datumValute;
	@XmlElement(required = true)
	protected BigDecimal iznos;
	@XmlElement(required = true)
	protected String sifraValute;

	public MT900() {

	}

	@SuppressWarnings("deprecation")
	public MT900(Mt9xy mt9xy, Nalog nalog) {
		if (mt9xy.getVrsta() != 900)
			return;
		
		this.banka = new TBanka(mt9xy.getRacunBankeDuznika(),
				Integer.parseInt(nalog.getModelZaduzenja()),
				nalog.getPozivNaBrojZaduzenja());
		
		if (mt9xy.getMt10x().getIdPoruke() != null)
			this.idPorukeNaloga = mt9xy.getMt10x().getIdPoruke().toString();
		this.iznos = new BigDecimal(mt9xy.getMt10x().getUkupanIznos());
		this.sifraValute = mt9xy.getMt10x().getSifraValutePoruke();
		Date datumTemp = mt9xy.getDatumPoruke();
		XMLGregorianCalendar datum;
		try {
			datum = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(
					datumTemp.getYear(), datumTemp.getMonth(),
					datumTemp.getDay(), DatatypeConstants.FIELD_UNDEFINED);

			this.datumValute = datum;
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
	}

	public MT900(MT102 mt102) {
		banka = mt102.getBankaDuznik();
		idPorukeNaloga = mt102.getId();
		datumValute = mt102.getDatumValute();
		iznos = mt102.getUkupanIznos();
		sifraValute = mt102.getSifraValute();
	}

	public MT900(MT103 mt103) {
		banka = mt103.getBankaDuznik();
		idPorukeNaloga = mt103.getId();
		datumValute = mt103.getUplata().getDatumValute();
		iznos = mt103.getUplata().getIznos();
		sifraValute = mt103.getUplata().getOznakaValute();
	}

	/**
	 * Gets the value of the id property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setId(String value) {
		this.id = value;
	}

	/**
	 * Gets the value of the banka property.
	 * 
	 * @return possible object is {@link TBanka }
	 * 
	 */
	public TBanka getBanka() {
		return banka;
	}

	/**
	 * Sets the value of the banka property.
	 * 
	 * @param value
	 *            allowed object is {@link TBanka }
	 * 
	 */
	public void setBanka(TBanka value) {
		this.banka = value;
	}

	/**
	 * Gets the value of the idPorukeNaloga property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getIdPorukeNaloga() {
		return idPorukeNaloga;
	}

	/**
	 * Sets the value of the idPorukeNaloga property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setIdPorukeNaloga(String value) {
		this.idPorukeNaloga = value;
	}

	/**
	 * Gets the value of the datumValute property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getDatumValute() {
		return datumValute;
	}

	/**
	 * Sets the value of the datumValute property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setDatumValute(XMLGregorianCalendar value) {
		this.datumValute = value;
	}

	/**
	 * Gets the value of the iznos property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getIznos() {
		return iznos;
	}

	/**
	 * Sets the value of the iznos property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setIznos(BigDecimal value) {
		this.iznos = value;
	}

	/**
	 * Gets the value of the sifraValute property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSifraValute() {
		return sifraValute;
	}

	/**
	 * Sets the value of the sifraValute property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSifraValute(String value) {
		this.sifraValute = value;
	}

}
