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

import poslovnaxws.common.TBanka;

/** @pdOid 7de48eda-71c8-407f-bdb7-62fd83310efd */
@Entity
@Table(name="racunBanke")
public class RacunBanke {
	/** @pdOid c725a61b-9fa6-4298-8db6-3e5bd6931f67 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_banke", unique = true, nullable = false)
	private long idBanke;
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
		return idBanke;
	}

	public void setIdBanke(long idBanke) {
		this.idBanke = idBanke;
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

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorDnevnoStanjeRacuna() {
		if (dnevnoStanjeRacuna == null)
			dnevnoStanjeRacuna = new java.util.HashSet<DnevnoStanjeRacuna>();
		return dnevnoStanjeRacuna.iterator();
	}

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

	/** @pdGenerated default getter */
	/*public java.util.Collection<Mt9xy> getMt9xy() {
		if (mt9xy == null)
			mt9xy = new java.util.HashSet<Mt9xy>();
		return mt9xy;
	}

	/** @pdGenerated default iterator getter */
	/*public java.util.Iterator getIteratorMt9xy() {
		if (mt9xy == null)
			mt9xy = new java.util.HashSet<Mt9xy>();
		return mt9xy.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newMt9xy
	 */
	/*public void setMt9xy(java.util.Collection<Mt9xy> newMt9xy) {
		removeAllMt9xy();
		for (java.util.Iterator iter = newMt9xy.iterator(); iter.hasNext();)
			addMt9xy((Mt9xy) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newMt9xy
	 */
	/*public void addMt9xy(Mt9xy newMt9xy) {
		if (newMt9xy == null)
			return;
		if (this.mt9xy == null)
			this.mt9xy = new java.util.HashSet<Mt9xy>();
		if (!this.mt9xy.contains(newMt9xy))
			this.mt9xy.add(newMt9xy);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldMt9xy
	 */
	/*public void removeMt9xy(Mt9xy oldMt9xy) {
		if (oldMt9xy == null)
			return;
		if (this.mt9xy != null)
			if (this.mt9xy.contains(oldMt9xy))
				this.mt9xy.remove(oldMt9xy);
	}

	/** @pdGenerated default removeAll */
	/*public void removeAllMt9xy() {
		if (mt9xy != null)
			mt9xy.clear();
	}

	/** @pdGenerated default getter */
	/*public java.util.Collection<Mt10x> getMt10x() {
		if (mt10x == null)
			mt10x = new java.util.HashSet<Mt10x>();
		return mt10x;
	}

	/** @pdGenerated default iterator getter */
	/*public java.util.Iterator getIteratorMt10x() {
		if (mt10x == null)
			mt10x = new java.util.HashSet<Mt10x>();
		return mt10x.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newMt10x
	 */
	/*public void setMt10x(java.util.Collection<Mt10x> newMt10x) {
		removeAllMt10x();
		for (java.util.Iterator iter = newMt10x.iterator(); iter.hasNext();)
			addMt10x((Mt10x) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newMt10x
	 */
	/*public void addMt10x(Mt10x newMt10x) {
		if (newMt10x == null)
			return;
		if (this.mt10x == null)
			this.mt10x = new java.util.HashSet<Mt10x>();
		if (!this.mt10x.contains(newMt10x))
			this.mt10x.add(newMt10x);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldMt10x
	 */
	/*public void removeMt10x(Mt10x oldMt10x) {
		if (oldMt10x == null)
			return;
		if (this.mt10x != null)
			if (this.mt10x.contains(oldMt10x))
				this.mt10x.remove(oldMt10x);
	}

	/** @pdGenerated default removeAll */
	/*public void removeAllMt10x() {
		if (mt10x != null)
			mt10x.clear();
	}
	/** @pdGenerated default getter */

}