/***********************************************************************
 * Module:  Mt10x.java
 * Author:  Nenad
 * Purpose: Defines the Class Mt10x
 ***********************************************************************/

package entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.util.HashSet;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import poslovnaxws.common.TBanka;
import poslovnaxws.common.TNalog;
import poslovnaxws.poruke.MT102;
import poslovnaxws.poruke.MT103;
import poslovnaxws.services.centralnabanka.CBClientService;
import util.EntityInfoUtil;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/** @pdOid f45025a4-1a2c-4311-a8d2-60cc9bf412bf */
@Entity
@DiscriminatorValue("mt10x")
@Table(name = "mt10x")
@NamedQuery(name="findByMessageStatus", query="Select p from Mt10x p where p.statusPoruke like :status")
public class Mt10x extends Poruka {
	/** @pdOid bd899746-12b5-41d7-956d-fdb8787e9355 */
	@Column(name = "svrha_placanja", unique = false, nullable = false)
	private java.lang.String svrhaPlacanja;
	/** @pdOid e00116a7-eda8-410e-8962-d43a138f862d */
	@Column(name = "ukupan_iznos", unique = false, nullable = false)
	private double ukupanIznos;
	/** @pdOid 918256ae-fef0-47ca-bc55-cc79afb29f9e */
	@Column(name = "status_poruke", unique = false, nullable = false)
	private double statusPoruke = 1;
	/** @pdOid 9c05cd27-3468-4e63-bec5-64702c9c18f8 */
	@Column(name = "datum_valute_poruke", unique = false, nullable = false)
	private java.util.Date datumValutePoruke;
	/** @pdOid cab74cb7-3e05-424f-a85d-207ef1157270 */
	@Column(name = "sifra_valute_poruke", unique = false, nullable = false)
	private java.lang.String sifraValutePoruke;

	@JsonIgnore
	/**
	 * @pdRoleInfo migr=no name=StavkaPoruke assc=naloziPoruke
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 */
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "mt10x")
	private java.util.Collection<StavkaPoruke> stavkaPoruke = new HashSet<StavkaPoruke>();
	/**
	 * @pdRoleInfo migr=no name=Mt9xy assc=porukaNaloga
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 *             side=A
	 */
	@JsonIgnore
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "mt10x")
	private java.util.Collection<Mt9xy> mt9xy = new HashSet<Mt9xy>();

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_banke_poverioca", referencedColumnName = "id_racuna", nullable = false)
	private RacunBanke racunBankePoverioca;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_banke_duznika", referencedColumnName = "id_racuna", nullable = false)
	private RacunBanke racunBankeDuznika;

	public Mt10x() {

	}
	
	public Mt10x(Mt10x mt10x){
		this.datumValutePoruke = mt10x.getDatumValutePoruke();
		this.racunBankeDuznika = mt10x.getRacunBankeDuznika();
		this.racunBankePoverioca = mt10x.getRacunBankePoverioca();
		this.sifraValutePoruke = mt10x.getSifraValutePoruke();
		this.statusPoruke = mt10x.getStatusPoruke();
		this.svrhaPlacanja = mt10x.getSvrhaPlacanja();
		this.ukupanIznos = mt10x.getUkupanIznos();
		this.stavkaPoruke = mt10x.getStavkaPoruke();
	}
	
	public Mt10x(MT102 mt102) {
		TBanka duznik = mt102.getBankaDuznik();
		TBanka poverioc = mt102.getBankaPoverioc();
		List<TNalog> uplate = mt102.getUplate().getUplata();
		this.setVrsta(102);
		this.datumValutePoruke = mt102.getDatumValute().toGregorianCalendar()
				.getTime();
		this.racunBankeDuznika = new RacunBanke(duznik);
		this.racunBankePoverioca = new RacunBanke(poverioc);

		this.sifraValutePoruke = mt102.getSifraValute();
		this.statusPoruke = 1; // Na cekanju
		this.svrhaPlacanja = mt102.getUplate().getUplata().get(0)
				.getSvrhaPlacanja();
		
		int i = 0;
		for (TNalog tNalog : uplate) {
			Nalog nalog = new Nalog(tNalog);
			this.stavkaPoruke.add(new StavkaPoruke(i++, this, nalog));
		}
		this.ukupanIznos = mt102.getUkupanIznos().doubleValue();
		duznik.getRacun();

	}

	public Mt10x(MT103 mt103) {
		TBanka duznik = mt103.getBankaDuznik();
		TBanka poverioc = mt103.getBankaPoverioc();
		TNalog uplata = mt103.getUplata();
		this.setVrsta(103);
		this.datumValutePoruke = mt103.getUplata().getDatumValute()
				.toGregorianCalendar().getTime();
		this.racunBankeDuznika = new RacunBanke(duznik);
		this.racunBankePoverioca = new RacunBanke(poverioc);
		this.sifraValutePoruke = uplata.getOznakaValute();
		this.svrhaPlacanja = uplata.getSvrhaPlacanja();
		this.ukupanIznos = uplata.getIznos().doubleValue();
		this.stavkaPoruke.add(new StavkaPoruke(1, this, new Nalog(mt103
				.getUplata())));
	}

	public java.lang.String getSvrhaPlacanja() {
		return svrhaPlacanja;
	}

	public void setSvrhaPlacanja(java.lang.String svrhaPlacanja) {
		this.svrhaPlacanja = svrhaPlacanja;
	}

	public double getUkupanIznos() {
		return ukupanIznos;
	}

	public void setUkupanIznos(double ukupanIznos) {
		this.ukupanIznos = ukupanIznos;
	}

	public double getStatusPoruke() {
		return statusPoruke;
	}

	public void setStatusPoruke(double statusPoruke) {
		this.statusPoruke = statusPoruke;
	}

	public java.util.Date getDatumValutePoruke() {
		return datumValutePoruke;
	}

	public void setDatumValutePoruke(java.util.Date datumValutePoruke) {
		this.datumValutePoruke = datumValutePoruke;
	}

	public java.lang.String getSifraValutePoruke() {
		return sifraValutePoruke;
	}

	public void setSifraValutePoruke(java.lang.String sifraValutePoruke) {
		this.sifraValutePoruke = sifraValutePoruke;
	}

	public RacunBanke getRacunBankePoverioca() {
		return racunBankePoverioca;
	}

	public void setRacunBankePoverioca(RacunBanke racunBankePoverioca) {
		this.racunBankePoverioca = racunBankePoverioca;
	}

	public RacunBanke getRacunBankeDuznika() {
		return racunBankeDuznika;
	}

	public void setRacunBankeDuznika(RacunBanke racunBankeDuznika) {
		this.racunBankeDuznika = racunBankeDuznika;
	}

	/** @pdGenerated default getter */
	public java.util.Collection<StavkaPoruke> getStavkaPoruke() {
		if (stavkaPoruke == null)
			stavkaPoruke = new java.util.HashSet<StavkaPoruke>();
		return stavkaPoruke;
	}

	@JsonIgnore
	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorStavkaPoruke() {
		if (stavkaPoruke == null)
			stavkaPoruke = new java.util.HashSet<StavkaPoruke>();
		return stavkaPoruke.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newStavkaPoruke
	 */
	public void setStavkaPoruke(
			java.util.Collection<StavkaPoruke> newStavkaPoruke) {
		removeAllStavkaPoruke();
		for (java.util.Iterator iter = newStavkaPoruke.iterator(); iter
				.hasNext();)
			addStavkaPoruke((StavkaPoruke) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newStavkaPoruke
	 */
	public void addStavkaPoruke(StavkaPoruke newStavkaPoruke) {
		if (newStavkaPoruke == null)
			return;
		if (this.stavkaPoruke == null)
			this.stavkaPoruke = new java.util.HashSet<StavkaPoruke>();
		if (!this.stavkaPoruke.contains(newStavkaPoruke))
			this.stavkaPoruke.add(newStavkaPoruke);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldStavkaPoruke
	 */
	public void removeStavkaPoruke(StavkaPoruke oldStavkaPoruke) {
		if (oldStavkaPoruke == null)
			return;
		if (this.stavkaPoruke != null)
			if (this.stavkaPoruke.contains(oldStavkaPoruke))
				this.stavkaPoruke.remove(oldStavkaPoruke);
	}

	/** @pdGenerated default removeAll */
	public void removeAllStavkaPoruke() {
		if (stavkaPoruke != null)
			stavkaPoruke.clear();
	}

	/** @pdGenerated default getter */
/*	public java.util.Collection<Mt9xy> getMt9xy() {
		if (mt9xy == null)
			mt9xy = new java.util.HashSet<Mt9xy>();
		return mt9xy;
	}*/

	@JsonIgnore
	/** @pdGenerated default iterator getter */
	/*public java.util.Iterator getIteratorMt9xy() {
		if (mt9xy == null)
			mt9xy = new java.util.HashSet<Mt9xy>();
		return mt9xy.iterator();
	}*/

	/**
	 * @pdGenerated default setter
	 * @param newMt9xy
	 */
	/*public void setMt9xy(java.util.Collection<Mt9xy> newMt9xy) {
		removeAllMt9xy();
		for (java.util.Iterator iter = newMt9xy.iterator(); iter.hasNext();)
			addMt9xy((Mt9xy) iter.next());
	}
*/
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
	}*/

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
	}*/

	/** @pdGenerated default removeAll */
	/*public void removeAllMt9xy() {
		if (mt9xy != null)
			mt9xy.clear();
	}*/
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		}
		if(idPoruke == ((Mt10x)obj).getIdPoruke()){
			return true;
		}
		return false;
	}
	
	/*@Override
	public int hashCode() {
		return idPoruke;
	}*/

	@Override
	public ObjectNode restify() {

		ObjectMapper objectMapper = new ObjectMapper();

		ObjectNode json = objectMapper.valueToTree(this);
		if (racunBankeDuznika != null)
			json.put("racunBankeDuznika", racunBankeDuznika.resourceURL());
		if (racunBankePoverioca != null)
		json.put("racunBankePoverioca", racunBankePoverioca.resourceURL());

		// Daje link cak i ako nije ucitan zbog lazy fetch-a
		json.put("stavkaPoruke",
				resourceURL() + EntityInfoUtil.getTableName(StavkaPoruke.class));

		return json;
	}

	@Override
	public String resourceURL() {
		return CBClientService.REST_URL + "/" + idPoruke + "/mt10x";
	}

	@Override
	public String tableURL() {
		return CBClientService.REST_URL + "/mt10x" ;
	}


}