package poslovnaxws.banke;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import poslovnaxws.common.TKlijent;
import entity.iface.Identifiable;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "racunKlijenta", "klijent", "stanjeRacuna" })
@XmlRootElement(name = "racunBanke", namespace = "PoslovnaXWS/Banke")
public class RacunBanke implements Identifiable{

	@XmlElement(required = true)
	private String racunKlijenta;
	@XmlElement(required = false)
	private TKlijent klijent;
	@XmlElement(required = true)
	private BigDecimal stanjeRacuna;
	
	public RacunBanke() {
	}
	
	@Override
	public String getId() {
		return racunKlijenta;
	}

	@Override
	public void setId(String value) {
		this.racunKlijenta = value;
	}

	public String getRacunKlijenta() {
		return racunKlijenta;
	}

	public void setRacunKlijenta(String racunKlijenta) {
		this.racunKlijenta = racunKlijenta;
	}

	public TKlijent getKlijent() {
		return klijent;
	}

	public void setKlijent(TKlijent klijent) {
		this.klijent = klijent;
	}

	public BigDecimal getStanjeRacuna() {
		return stanjeRacuna;
	}

	public void setStanjeRacuna(BigDecimal stanjeRacuna) {
		this.stanjeRacuna = stanjeRacuna;
	}
	
	

}
