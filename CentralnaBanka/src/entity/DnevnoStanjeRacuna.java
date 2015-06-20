/***********************************************************************
 * Module:  DnevnoStanjeRacuna.java
 * Author:  Nenad
 * Purpose: Defines the Class DnevnoStanjeRacuna
 ***********************************************************************/

package entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import poslovnaxws.services.centralnabanka.CBClientService;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import util.EntityInfoUtil;
import util.Restifyable;

/** @pdOid 4e03db37-cf8e-49d4-a795-92a43c20cb39 */
@Entity
@Table(name = "dnevnoStanjeRacuna")
@NamedQuery(name = "findDnevnoStanjeRacuna", query = "Select d from DnevnoStanjeRacuna d where d.datum like :datum")
public class DnevnoStanjeRacuna implements Restifyable {
	/** @pdOid 61879e33-25d4-4972-85e1-0acd180d8b91 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_dnevnog_stanja", unique = true, nullable = false)
	private long idDnevnogStanja;
	/** @pdOid f6ae9a45-461d-435b-b637-760be32bad50 */
	@Column(name = "datum", unique = false, nullable = false)
	private java.util.Date datum;
	/** @pdOid f8c84bd5-466e-4a30-abb2-adc38b8d6fe1 */
	@Column(name = "dnevni_promet_u_korist", unique = false, nullable = false)
	private double dnevniPrometUKorist;
	/** @pdOid 353919ea-4e69-4f4b-856f-a871bea8e16f */
	@Column(name = "dnevni_promet_na_teret", unique = false, nullable = false)
	private double dnevniPrometNaTeret;
	/** @pdOid 18ad2f0d-a4d7-492c-852a-b428f273a621 */
	@Column(name = "predhodno_stanje", unique = false, nullable = false)
	private double prethodnoStanje;
	/** @pdOid 33f0870c-18aa-4376-b0cb-3769d6026cb5 */
	@Column(name = "trenutno_stanje", unique = false, nullable = false)
	private double trenutnoStanje;

	@ManyToOne
	@JoinColumn(name = "id_racuna", referencedColumnName = "id_racuna", nullable = false)
	private RacunBanke racunBanke;
	/**
	 * @pdRoleInfo migr=no name=StavkaDnevnogRacuna assc=stavke
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 */
	@JsonIgnore
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "dnevnoStanjeRacuna")
	private java.util.Collection<StavkaDnevnogRacuna> stavkaDnevnogRacuna;

	public DnevnoStanjeRacuna() {

	}

	public long getIdDnevnogStanja() {
		return idDnevnogStanja;
	}

	public void setIdDnevnogStanja(long idDnevnogStanja) {
		this.idDnevnogStanja = idDnevnogStanja;
	}

	public java.util.Date getDatum() {
		return datum;
	}

	public void setDatum(java.util.Date datum) {
		this.datum = datum;
	}

	public double getDnevniPrometUKorist() {
		return dnevniPrometUKorist;
	}

	public void setDnevniPrometUKorist(double dnevniPrometUKorist) {
		this.dnevniPrometUKorist = dnevniPrometUKorist;
	}

	public double getDnevniPrometNaTeret() {
		return dnevniPrometNaTeret;
	}

	public void setDnevniPrometNaTeret(double dnevniPrometNaTeret) {
		this.dnevniPrometNaTeret = dnevniPrometNaTeret;
	}

	public double getPrethodnoStanje() {
		return prethodnoStanje;
	}

	public void setPrethodnoStanje(double prethodnoStanje) {
		this.prethodnoStanje = prethodnoStanje;
	}

	public double getTrenutnoStanje() {
		return trenutnoStanje;
	}

	public void setTrenutnoStanje(double trenutnoStanje) {
		this.trenutnoStanje = trenutnoStanje;
	}

	public RacunBanke getRacunBanke() {
		return racunBanke;
	}

	public void setRacunBanke(RacunBanke racunBanke) {
		this.racunBanke = racunBanke;
	}


	/** @pdGenerated default getter */
	public java.util.Collection<StavkaDnevnogRacuna> getStavkaDnevnogRacuna() {
		if (stavkaDnevnogRacuna == null)
			stavkaDnevnogRacuna = new java.util.HashSet<StavkaDnevnogRacuna>();
		return stavkaDnevnogRacuna;
	}
	@JsonIgnore
	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorStavkaDnevnogRacuna() {
		if (stavkaDnevnogRacuna == null)
			stavkaDnevnogRacuna = new java.util.HashSet<StavkaDnevnogRacuna>();
		return stavkaDnevnogRacuna.iterator();
	}
	
	/**
	 * @pdGenerated default setter
	 * @param newStavkaDnevnogRacuna
	 */
	public void setStavkaDnevnogRacuna(
			java.util.Collection<StavkaDnevnogRacuna> newStavkaDnevnogRacuna) {
		removeAllStavkaDnevnogRacuna();
		for (java.util.Iterator iter = newStavkaDnevnogRacuna.iterator(); iter
				.hasNext();)
			addStavkaDnevnogRacuna((StavkaDnevnogRacuna) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newStavkaDnevnogRacuna
	 */
	public void addStavkaDnevnogRacuna(
			StavkaDnevnogRacuna newStavkaDnevnogRacuna) {
		if (newStavkaDnevnogRacuna == null)
			return;
		if (this.stavkaDnevnogRacuna == null)
			this.stavkaDnevnogRacuna = new java.util.HashSet<StavkaDnevnogRacuna>();
		if (!this.stavkaDnevnogRacuna.contains(newStavkaDnevnogRacuna))
			this.stavkaDnevnogRacuna.add(newStavkaDnevnogRacuna);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldStavkaDnevnogRacuna
	 */
	public void removeStavkaDnevnogRacuna(
			StavkaDnevnogRacuna oldStavkaDnevnogRacuna) {
		if (oldStavkaDnevnogRacuna == null)
			return;
		if (this.stavkaDnevnogRacuna != null)
			if (this.stavkaDnevnogRacuna.contains(oldStavkaDnevnogRacuna))
				this.stavkaDnevnogRacuna.remove(oldStavkaDnevnogRacuna);
	}

	/** @pdGenerated default removeAll */
	public void removeAllStavkaDnevnogRacuna() {
		if (stavkaDnevnogRacuna != null)
			stavkaDnevnogRacuna.clear();
	}

	@Override
	public ObjectNode restify() {

		ObjectMapper objectMapper = new ObjectMapper();

		ObjectNode json = objectMapper.valueToTree(this);

		// Daje link cak i ako nije ucitan zbog lazy fetch-a
		json.put(
				"stavkaDnevnogRacuna",
				resourceURL()
						+ EntityInfoUtil.getTableName(StavkaDnevnogRacuna.class));

		return json;
	}

	@Override
	public String resourceURL() {
		return CBClientService.REST_URL + "/" + idDnevnogStanja + "/dnevnoStanjeRacuna";
	}

	@Override
	public String tableURL() {
		return CBClientService.REST_URL + "/dnevnoStanjeRacuna";
	}

}