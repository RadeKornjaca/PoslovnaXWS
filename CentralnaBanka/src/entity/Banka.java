/***********************************************************************
 * Module:  Banka.java
 * Author:  Nenad
 * Purpose: Defines the Class Banka
 ***********************************************************************/

package entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import initdb.InitBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/** @pdOid 116f65c3-5b1e-4bfc-8fa0-6ea419919fd8 */
@Entity
@Table(name = "banka")
public class Banka {
	/** @pdOid 8a3e2bdd-c487-4f49-a63a-9f19b52e9ff9 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "banka_id", unique = true, nullable = false)
	private long bankaId;
	
	@Column(name = "swift_kod", unique = true, nullable = false)
	private java.lang.String swiftKod;
	/** @pdOid 1fd5a2b8-3ac6-4397-b62c-a1d65abf8884 */
	@Column(name = "naziv", unique = true, nullable = false)
	private java.lang.String naziv;
	/** @pdOid 41926a48-af5b-49d3-8d34-e616f01423b5 */
	@Column(name = "sifra", unique = true, nullable = false)
	private double sifra;

	/**
	 * @pdRoleInfo migr=no name=RacunBanke assc=racunBanke
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 *             side=A
	 */
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "banka")
	private java.util.Collection<RacunBanke> racunBanke;

	
	
	public long getBankaId() {
		return bankaId;
	}

	public void setBankaId(long bankaId) {
		this.bankaId = bankaId;
	}

	public java.lang.String getSwiftKod() {
		return swiftKod;
	}

	public void setSwiftKod(java.lang.String swiftKod) {
		this.swiftKod = swiftKod;
	}

	public java.lang.String getNaziv() {
		return naziv;
	}

	public void setNaziv(java.lang.String naziv) {
		this.naziv = naziv;
	}

	public double getSifra() {
		return sifra;
	}

	public void setSifra(double sifra) {
		this.sifra = sifra;
	}

	/** @pdGenerated default getter */
	public java.util.Collection<RacunBanke> getRacunBanke() {
		if (racunBanke == null)
			racunBanke = new java.util.HashSet<RacunBanke>();
		return racunBanke;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorRacunBanke() {
		if (racunBanke == null)
			racunBanke = new java.util.HashSet<RacunBanke>();
		return racunBanke.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newRacunBanke
	 */
	public void setRacunBanke(java.util.Collection<RacunBanke> newRacunBanke) {
		removeAllRacunBanke();
		for (java.util.Iterator iter = newRacunBanke.iterator(); iter.hasNext();)
			addRacunBanke((RacunBanke) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newRacunBanke
	 */
	public void addRacunBanke(RacunBanke newRacunBanke) {
		if (newRacunBanke == null)
			return;
		if (this.racunBanke == null)
			this.racunBanke = new java.util.HashSet<RacunBanke>();
		if (!this.racunBanke.contains(newRacunBanke))
			this.racunBanke.add(newRacunBanke);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldRacunBanke
	 */
	public void removeRacunBanke(RacunBanke oldRacunBanke) {
		if (oldRacunBanke == null)
			return;
		if (this.racunBanke != null)
			if (this.racunBanke.contains(oldRacunBanke))
				this.racunBanke.remove(oldRacunBanke);
	}

	/** @pdGenerated default removeAll */
	public void removeAllRacunBanke() {
		if (racunBanke != null)
			racunBanke.clear();
	}

}