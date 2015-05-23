/***********************************************************************
 * Module:  Nalog.java
 * Author:  Nenad
 * Purpose: Defines the Class Nalog
 ***********************************************************************/

package entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/** @pdOid 8b4e0f96-2ad2-4d40-88eb-e2c4a5cd282d */
@Entity
@Table(name = "nalog")
public class Nalog {
	/** @pdOid f319aa07-d806-46da-ba81-1b7afa9db2a7 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_naloga", unique = true, nullable = false)
	private long idNaloga;
	/** @pdOid 47e4ae67-7a54-4548-927f-827e4d918138 */
	@Column(name = "svrha_placanja", unique = false, nullable = false)
	private java.lang.String svrhaPlacanja;
	/** @pdOid fd9816ec-0b8d-4917-86da-3d52fd024f27 */
	@Column(name = "datum_naloga", unique = false, nullable = false)
	private java.util.Date datumNaloga;
	/** @pdOid 7a60adbc-0eaf-43f8-bfe8-0db41642070c */
	@Column(name = "model_zaduzenja", unique = false, nullable = false)
	private java.lang.String modelZaduzenja;
	/** @pdOid acf95a68-12ef-4a7c-897a-1322c0fd439b */
	@Column(name = "model_odobrenja", unique = false, nullable = false)
	private java.lang.String modelOdobrenja;
	/** @pdOid 19dea6be-10fa-4545-9713-32c7af3f7338 */
	@Column(name = "poziv_na_broj_zaduzenja", unique = false, nullable = false)
	private java.lang.String pozivNaBrojZaduzenja;
	/** @pdOid 2efa1e99-fca1-4e57-9d3e-8352ec653ca2 */
	@Column(name = "broj_racuna_duznika", unique = false, nullable = false)
	private double brojRacunaDuznika;
	/** @pdOid 5f436594-cd01-4441-8ad8-89d0362e6bdc */
	@Column(name = "poziv_na_broj", unique = false, nullable = false)
	private java.lang.String pozivNaBrojOdobrenja;
	/** @pdOid d4c35616-57fc-4c62-87ac-89784b0ab1ba */
	@Column(name = "broj_racuna_poverioca", unique = false, nullable = false)
	private double brojRacunaPoverioca;
	/** @pdOid 37e37ec0-9c5b-466b-8345-7284758251d8 */
	@Column(name = "iznos", unique = false, nullable = false)
	private double iznos;
	/** @pdOid d636adc5-4d03-4e8c-bd1f-4525b63de81e */
	@Column(name = "hitno", unique = false, nullable = false)
	private boolean hitno;
	/** @pdOid b04e0679-6d34-4344-88ef-3808d8645cf1 */
	@Column(name = "status", unique = false, nullable = false)
	private double status = 1;
	/** @pdOid 09519481-e108-432a-b102-0e713e7cda1f */
	@Column(name = "adresa_poverioca", unique = false, nullable = false)
	private java.lang.String adresaPoverioca;
	/** @pdOid c65398b5-ad69-4dd4-8372-fc317d8de05f */
	@Column(name = "adresa_duznika", unique = false, nullable = false)
	private java.lang.String adresaDuznika;
	/** @pdOid fd564d5f-1313-4db9-8d11-266fb8a1a50c */
	@Column(name = "naziv_duznika", unique = false, nullable = false)
	private java.lang.String nazivDuznika;
	/** @pdOid eab39464-9276-4c8c-a3c3-1835bc1a4bf7 */
	@Column(name = "naziv_poverioca", unique = false, nullable = false)
	private java.lang.String nazivPoverioca;
	/** @pdOid ef18144c-af42-4499-aa07-99b797bda692 */
	@Column(name = "sifra_poverioca", unique = false, nullable = false)
	private java.lang.String sifraValute;

	@ManyToOne
	@JoinColumn(name = "id_mesta", referencedColumnName = "id_mesta", nullable = false)
	private NaseljenoMesto naseljenoMesto;
	/**
	 * @pdRoleInfo migr=no name=StavkaDnevnogRacuna assc=naloziDnevnogRacuna
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 *             side=A
	 */
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "nalog")
	private java.util.Collection<StavkaDnevnogRacuna> stavkaDnevnogRacuna;
	/**
	 * @pdRoleInfo migr=no name=StavkaPoruke assc=naloziStavke
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 *             side=A
	 */
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "nalog")
	private java.util.Collection<StavkaPoruke> stavkaPoruke;
	
	public long getIdNaloga() {
		return idNaloga;
	}

	public void setIdNaloga(long idNaloga) {
		this.idNaloga = idNaloga;
	}

	public java.lang.String getSvrhaPlacanja() {
		return svrhaPlacanja;
	}

	public void setSvrhaPlacanja(java.lang.String svrhaPlacanja) {
		this.svrhaPlacanja = svrhaPlacanja;
	}

	public java.util.Date getDatumNaloga() {
		return datumNaloga;
	}

	public void setDatumNaloga(java.util.Date datumNaloga) {
		this.datumNaloga = datumNaloga;
	}

	public java.lang.String getModelZaduzenja() {
		return modelZaduzenja;
	}

	public void setModelZaduzenja(java.lang.String modelZaduzenja) {
		this.modelZaduzenja = modelZaduzenja;
	}

	public java.lang.String getModelOdobrenja() {
		return modelOdobrenja;
	}

	public void setModelOdobrenja(java.lang.String modelOdobrenja) {
		this.modelOdobrenja = modelOdobrenja;
	}

	public java.lang.String getPozivNaBrojZaduzenja() {
		return pozivNaBrojZaduzenja;
	}

	public void setPozivNaBrojZaduzenja(java.lang.String pozivNaBrojZaduzenja) {
		this.pozivNaBrojZaduzenja = pozivNaBrojZaduzenja;
	}

	public double getBrojRacunaDuznika() {
		return brojRacunaDuznika;
	}

	public void setBrojRacunaDuznika(double brojRacunaDuznika) {
		this.brojRacunaDuznika = brojRacunaDuznika;
	}

	public java.lang.String getPozivNaBrojOdobrenja() {
		return pozivNaBrojOdobrenja;
	}

	public void setPozivNaBrojOdobrenja(java.lang.String pozivNaBrojOdobrenja) {
		this.pozivNaBrojOdobrenja = pozivNaBrojOdobrenja;
	}

	public double getBrojRacunaPoverioca() {
		return brojRacunaPoverioca;
	}

	public void setBrojRacunaPoverioca(double brojRacunaPoverioca) {
		this.brojRacunaPoverioca = brojRacunaPoverioca;
	}

	public double getIznos() {
		return iznos;
	}

	public void setIznos(double iznos) {
		this.iznos = iznos;
	}

	public boolean isHitno() {
		return hitno;
	}

	public void setHitno(boolean hitno) {
		this.hitno = hitno;
	}

	public double getStatus() {
		return status;
	}

	public void setStatus(double status) {
		this.status = status;
	}

	public java.lang.String getAdresaPoverioca() {
		return adresaPoverioca;
	}

	public void setAdresaPoverioca(java.lang.String adresaPoverioca) {
		this.adresaPoverioca = adresaPoverioca;
	}

	public java.lang.String getAdresaDuznika() {
		return adresaDuznika;
	}

	public void setAdresaDuznika(java.lang.String adresaDuznika) {
		this.adresaDuznika = adresaDuznika;
	}

	public java.lang.String getNazivDuznika() {
		return nazivDuznika;
	}

	public void setNazivDuznika(java.lang.String nazivDuznika) {
		this.nazivDuznika = nazivDuznika;
	}

	public java.lang.String getNazivPoverioca() {
		return nazivPoverioca;
	}

	public void setNazivPoverioca(java.lang.String nazivPoverioca) {
		this.nazivPoverioca = nazivPoverioca;
	}

	public java.lang.String getSifraValute() {
		return sifraValute;
	}

	public void setSifraValute(java.lang.String sifraValute) {
		this.sifraValute = sifraValute;
	}

	public NaseljenoMesto getNaseljenoMesto() {
		return naseljenoMesto;
	}

	public void setNaseljenoMesto(NaseljenoMesto naseljenoMesto) {
		this.naseljenoMesto = naseljenoMesto;
	}

	/** @pdGenerated default getter */
	public java.util.Collection<StavkaDnevnogRacuna> getStavkaDnevnogRacuna() {
		if (stavkaDnevnogRacuna == null)
			stavkaDnevnogRacuna = new java.util.HashSet<StavkaDnevnogRacuna>();
		return stavkaDnevnogRacuna;
	}

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

	/** @pdGenerated default getter */
	public java.util.Collection<StavkaPoruke> getStavkaPoruke() {
		if (stavkaPoruke == null)
			stavkaPoruke = new java.util.HashSet<StavkaPoruke>();
		return stavkaPoruke;
	}

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

}