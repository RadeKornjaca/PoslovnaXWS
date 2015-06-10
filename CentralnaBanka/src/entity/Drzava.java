/***********************************************************************
 * Module:  Drzava.java
 * Author:  Nenad
 * Purpose: Defines the Class Drzava
 ***********************************************************************/

package entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import poslovnaxws.common.TDrzava;
import poslovnaxws.common.TNaseljenoMesto;

/** @pdOid d66bf4c9-7b74-47ab-ae68-713217add753 */

@Entity
@Table(name = "drzava")
@NamedQuery(name = "findBanka", query = "Select d from Drzava d where d.nazivDrzave like :naziv")
public class Drzava {
	/** @pdOid a55cf1cc-a239-4b44-8263-5ccf47261c30 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_drzave", unique = true, nullable = false)
	private long idDrzave;
	/** @pdOid bf16e7af-a44e-4777-8693-676d9c1efd6c */
	@Column(name = "sifra_drzave", unique = true, nullable = false)
	private java.lang.String sifraDrzave;
	/** @pdOid 71d0d54c-a123-4e5e-8452-8844f7551592 */
	@Column(name = "naziv_drzave", unique = true, nullable = false)
	private java.lang.String nazivDrzave;

	/**
	 * @pdRoleInfo migr=no name=NaseljenoMesto assc=deoDrzave
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 */
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "drzava")
	private java.util.Collection<NaseljenoMesto> naseljenoMesto;

	public Drzava() {

	}

	public Drzava(TDrzava drzava) {
		this.nazivDrzave = drzava.getNazivDrzave();
		this.sifraDrzave = drzava.getSifraDrzave();
		for (TNaseljenoMesto naseljenoMesto2 : drzava.getNaseljenaMesta()
				.getNaseljenoMesto()) {
			naseljenoMesto.add(new NaseljenoMesto(naseljenoMesto2));
		}
	}

	public long getIdDrzave() {
		return idDrzave;
	}

	public void setIdDrzave(long idDrzave) {
		this.idDrzave = idDrzave;
	}

	public java.lang.String getSifraDrzave() {
		return sifraDrzave;
	}

	public void setSifraDrzave(java.lang.String sifraDrzave) {
		this.sifraDrzave = sifraDrzave;
	}

	public java.lang.String getNazivDrzave() {
		return nazivDrzave;
	}

	public void setNazivDrzave(java.lang.String nazivDrzave) {
		this.nazivDrzave = nazivDrzave;
	}

	/** @pdGenerated default getter */
	public java.util.Collection<NaseljenoMesto> getNaseljenoMesto() {
		if (naseljenoMesto == null)
			naseljenoMesto = new java.util.HashSet<NaseljenoMesto>();
		return naseljenoMesto;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorNaseljenoMesto() {
		if (naseljenoMesto == null)
			naseljenoMesto = new java.util.HashSet<NaseljenoMesto>();
		return naseljenoMesto.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newNaseljenoMesto
	 */
	public void setNaseljenoMesto(
			java.util.Collection<NaseljenoMesto> newNaseljenoMesto) {
		removeAllNaseljenoMesto();
		for (java.util.Iterator iter = newNaseljenoMesto.iterator(); iter
				.hasNext();)
			addNaseljenoMesto((NaseljenoMesto) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newNaseljenoMesto
	 */
	public void addNaseljenoMesto(NaseljenoMesto newNaseljenoMesto) {
		if (newNaseljenoMesto == null)
			return;
		if (this.naseljenoMesto == null)
			this.naseljenoMesto = new java.util.HashSet<NaseljenoMesto>();
		if (!this.naseljenoMesto.contains(newNaseljenoMesto))
			this.naseljenoMesto.add(newNaseljenoMesto);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldNaseljenoMesto
	 */
	public void removeNaseljenoMesto(NaseljenoMesto oldNaseljenoMesto) {
		if (oldNaseljenoMesto == null)
			return;
		if (this.naseljenoMesto != null)
			if (this.naseljenoMesto.contains(oldNaseljenoMesto))
				this.naseljenoMesto.remove(oldNaseljenoMesto);
	}

	/** @pdGenerated default removeAll */
	public void removeAllNaseljenoMesto() {
		if (naseljenoMesto != null)
			naseljenoMesto.clear();
	}



}