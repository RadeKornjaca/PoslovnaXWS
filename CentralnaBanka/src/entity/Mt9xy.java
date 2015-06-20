/***********************************************************************
 * Module:  Mt9xy.java
 * Author:  Nenad
 * Purpose: Defines the Class Mt9xy
 ***********************************************************************/

package entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import poslovnaxws.poruke.MT900;
import poslovnaxws.poruke.MT910;
import poslovnaxws.services.centralnabanka.CBRestService;
import util.Restifyable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/** @pdOid 928b7313-3d67-4770-99f2-90dc6a721a77 */
@Entity
@DiscriminatorValue("mt9xy")
@Table(name = "mt9xy")
public class Mt9xy extends Poruka {
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_poruke", referencedColumnName = "id_poruke", nullable = false)
	private Mt10x mt10x;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_banke_duznika", referencedColumnName = "id_racuna", nullable = true)
	private RacunBanke racunBankeDuznika;

	public Mt10x getMt10x() {
		return mt10x;
	}

	public void setMt10x(Mt10x mt10x) {
		this.mt10x = mt10x;
	}

	public RacunBanke getRacunBankeDuznika() {
		return racunBankeDuznika;
	}

	public void setRacunBankeDuznika(RacunBanke racunBankeDuznika) {
		this.racunBankeDuznika = racunBankeDuznika;
		racunBankePoverioca = null;
	}

	public RacunBanke getRacunBankePoverioca() {
		return racunBankePoverioca;
	}

	public void setRacunBankePoverioca(RacunBanke racunBankePoverioca) {
		this.racunBankePoverioca = racunBankePoverioca;
		racunBankeDuznika = null;
	}

	@ManyToOne
	@JoinColumn(name = "id_banke_poverioca", referencedColumnName = "id_racuna", nullable = true)
	private RacunBanke racunBankePoverioca;

	public Mt9xy() {

	}

	public Mt9xy(MT900 mt900) {
		this.setDatumPoruke(mt900.getDatumValute().toGregorianCalendar()
				.getTime());
		this.setVrsta(900);
		racunBankeDuznika = new RacunBanke(mt900.getBanka());

	}

	public Mt9xy(MT910 mt910) {
		this.setDatumPoruke(mt910.getDatumValute().toGregorianCalendar()
				.getTime());
		this.setVrsta(910);
		racunBankeDuznika = new RacunBanke(mt910.getBanka());
	}

	@Override
	public ObjectNode restify() {

		ObjectMapper objectMapper = new ObjectMapper();

		ObjectNode json = objectMapper.valueToTree(this);

		if (racunBankeDuznika != null)
			json.put("racunBankeDuznika", racunBankeDuznika.resourceURL());
		if (racunBankePoverioca != null)
			json.put("racunBankePoverioca", racunBankePoverioca.resourceURL());

		return json;
	}

	@Override
	public String resourceURL() {
		return CBRestService.REST_URL + "/" + idPoruke + "/" + vrsta;
	}

	@Override
	public String tableURL() {
		return CBRestService.REST_URL + "/" + vrsta;
	}
}