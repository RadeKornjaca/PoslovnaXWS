/***********************************************************************
 * Module:  RacunBanke.java
 * Author:  Nenad
 * Purpose: Defines the Class RacunBanke
 ***********************************************************************/

package entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import poslovnaxws.common.TBanka;
import poslovnaxws.services.centralnabanka.CBClientService;
import util.EntityInfoUtil;
import util.Restifyable;

/** @pdOid 7de48eda-71c8-407f-bdb7-62fd83310efd */
@Entity
@Table(name="racunBanke")
public class RacunBanke implements Restifyable{
	/** @pdOid c725a61b-9fa6-4298-8db6-3e5bd6931f67 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_racuna", unique = true, nullable = false)
	private long idRacuna;
	/** @pdOid 4c7e74ea-9624-4762-a948-70298323f533 */
	@Column(name = "broj_racuna", unique = true, nullable = false)
	private java.lang.String brojRacuna;
	/** @pdOid 3722d46c-458c-400e-a869-b166180d7cae */
	@Column(name = "aktivan", unique = false, nullable = false)
	private boolean aktivan;
	/** @pdOid 3c930bb2-6e2a-4aa4-9149-b19ee6cd120d */
	@Column(name = "datum_otvaranja", unique = false, nullable = false)
	private java.util.Date datumOtvaranja;
	/** @pdOid a17685ec-3851-4a11-9771-58002089e1cb */
	@Column(name = "likvidan", unique = false, nullable = false)
	private boolean likvidan;
	
	@ManyToOne
	@JoinColumn(name = "banka_id", referencedColumnName = "banka_id", nullable = false)
	private Banka banka;

	/**
	 * @pdRoleInfo migr=no name=DnevnoStanjeRacuna assc=dnevnoStanjeRacuna
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 */
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "racunBanke")
	private java.util.Collection<DnevnoStanjeRacuna> dnevnoStanjeRacuna
	 = new HashSet<DnevnoStanjeRacuna>();
	
	@OneToMany
	private java.util.Collection<Mt9xy> mt9xy = new HashSet<Mt9xy>();
	/**
	 * @pdRoleInfo migr=no name=Mt9xy assc=obracunskiRacun
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 */
	/*@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "racunBanke")
	private java.util.Collection<Mt9xy> mt9xy;
	/**
	 * @pdRoleInfo migr=no name=Mt10x assc=obracunskiRacunBankeDuznika
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 *             side=A
	 */
	/*@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "racunBanke")
	private java.util.Collection<Mt10x> mt10x;

	/**
	 * @pdRoleInfo migr=no name=Mt10x assc=obracunskiRacunBankePoverioca
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 *             side=A
	 */
	
	/** @pdGenerated default getter */
	public java.util.Collection<DnevnoStanjeRacuna> getDnevnoStanjeRacuna() {
		if (dnevnoStanjeRacuna == null)
			dnevnoStanjeRacuna = new java.util.HashSet<DnevnoStanjeRacuna>();
		return dnevnoStanjeRacuna;
	}
	
	public RacunBanke(){
		
	}
	
	public RacunBanke(TBanka banka){
		this.aktivan = true;
		this.banka = new Banka(banka);
		this.brojRacuna = banka.getRacun();
		this.datumOtvaranja = new Date();
		this.likvidan = true;
		this.banka.addRacunBanke(this);
	}

	public long getIdBanke() {
		return idRacuna;
	}

	public void setIdBanke(long idBanke) {
		this.idRacuna = idBanke;
	}

	public java.lang.String getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(java.lang.String brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public boolean isAktivan() {
		return aktivan;
	}

	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}

	public java.util.Date getDatumOtvaranja() {
		return datumOtvaranja;
	}

	public void setDatumOtvaranja(java.util.Date datumOtvaranja) {
		this.datumOtvaranja = datumOtvaranja;
	}

	public boolean isLikvidan() {
		return likvidan;
	}

	public void setLikvidan(boolean likvidan) {
		this.likvidan = likvidan;
	}

	public Banka getBanka() {
		return banka;
	}

	public void setBanka(Banka banka) {
		this.banka = banka;
	}

	@JsonIgnore
	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorDnevnoStanjeRacuna() {
		if (dnevnoStanjeRacuna == null)
			dnevnoStanjeRacuna = new java.util.HashSet<DnevnoStanjeRacuna>();
		return dnevnoStanjeRacuna.iterator();
	}
	
	@JsonIgnore
	/**
	 * @pdGenerated default setter
	 * @param newDnevnoStanjeRacuna
	 */
	public void setDnevnoStanjeRacuna(
			java.util.Collection<DnevnoStanjeRacuna> newDnevnoStanjeRacuna) {
		removeAllDnevnoStanjeRacuna();
		for (java.util.Iterator iter = newDnevnoStanjeRacuna.iterator(); iter
				.hasNext();)
			addDnevnoStanjeRacuna((DnevnoStanjeRacuna) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newDnevnoStanjeRacuna
	 */
	public void addDnevnoStanjeRacuna(DnevnoStanjeRacuna newDnevnoStanjeRacuna) {
		if (newDnevnoStanjeRacuna == null)
			return;
		if (this.dnevnoStanjeRacuna == null)
			this.dnevnoStanjeRacuna = new java.util.HashSet<DnevnoStanjeRacuna>();
		if (!this.dnevnoStanjeRacuna.contains(newDnevnoStanjeRacuna))
			this.dnevnoStanjeRacuna.add(newDnevnoStanjeRacuna);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldDnevnoStanjeRacuna
	 */
	public void removeDnevnoStanjeRacuna(
			DnevnoStanjeRacuna oldDnevnoStanjeRacuna) {
		if (oldDnevnoStanjeRacuna == null)
			return;
		if (this.dnevnoStanjeRacuna != null)
			if (this.dnevnoStanjeRacuna.contains(oldDnevnoStanjeRacuna))
				this.dnevnoStanjeRacuna.remove(oldDnevnoStanjeRacuna);
	}

	/** @pdGenerated default removeAll */
	public void removeAllDnevnoStanjeRacuna() {
		if (dnevnoStanjeRacuna != null)
			dnevnoStanjeRacuna.clear();
	}

	@Override
	public ObjectNode restify() {

		ObjectMapper objectMapper = new ObjectMapper();

		ObjectNode json = objectMapper.valueToTree(this);

		json.put("banka",
				banka.resourceURL());
		
		//Daje link cak i ako nije ucitan zbog lazy fetch-a
		json.put(
				"dnevnoStanjeRacuna",
				resourceURL()
						+ EntityInfoUtil.getTableName(DnevnoStanjeRacuna.class));
		
		return json;
	}

	@Override
	public String resourceURL() {
		return CBClientService.REST_URL + "/" + idRacuna + "/racunBanke";
	}

	@Override
	public String tableURL() {
		return CBClientService.REST_URL + "/racunBanke";
	}
	
	@Override
	public boolean equals(Object obj) {
		RacunBanke that = (RacunBanke) obj;
		return this.idRacuna == that.idRacuna;
	}

}