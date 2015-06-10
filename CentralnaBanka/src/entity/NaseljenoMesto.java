/***********************************************************************
 * Module:  NaseljenoMesto.java
 * Author:  Nenad
 * Purpose: Defines the Class NaseljenoMesto
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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import poslovnaxws.common.TNalog;
import poslovnaxws.common.TNaseljenoMesto;

/** @pdOid da2bd5ef-bcd6-474f-ba3a-4241202f87d3 */
@Entity
@Table(name = "naseljenoMesto")
@NamedQuery(name = "findNaseljenoMesto", query="Select n from NaseljenoMesto n where n.nazivMesta like :nazivMesta")
public class NaseljenoMesto {
	/** @pdOid 6af7346e-67b5-4494-91d7-95941222c0cd */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_mesta", unique = true, nullable = false)
	private long idMesta;
	/** @pdOid df0b8df9-75df-43a0-8f53-322631fc2db2 */
	@Column(name = "sifra_mesta", unique = true, nullable = false)
	private java.lang.String sifraMesta;
	/** @pdOid 34d8a4d0-b62c-41a0-94a7-e685a50a5800 */
	@Column(name = "naziv_mesta", unique = true, nullable = false)
	private java.lang.String nazivMesta;

	@ManyToOne
	@JoinColumn(name = "id_drzave", referencedColumnName = "id_drzave", nullable = false)
	private Drzava drzava;
	
	/**
	 * @pdRoleInfo migr=no name=Nalog assc=mestoPrijema coll=java.util.Collection
	 *             impl=java.util.HashSet mult=0..*
	 */
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "naseljenoMesto")
	private java.util.Collection<Nalog> nalog;
	
	public NaseljenoMesto(){
		
	}
	
	public NaseljenoMesto(TNaseljenoMesto naseljenoMesto){
		this.drzava = new Drzava(naseljenoMesto.getDrzava());
		this.nazivMesta = naseljenoMesto.getNazivMesta();
		this.sifraMesta = naseljenoMesto.getSifraMesta();
		for (TNalog nalog2 : naseljenoMesto.getNalozi().getNalog()) {
			nalog.add(new Nalog(nalog2));
		}
		
	}
	
	public long getIdMesta() {
		return idMesta;
	}

	public void setIdMesta(long idMesta) {
		this.idMesta = idMesta;
	}

	public java.lang.String getSifraMesta() {
		return sifraMesta;
	}

	public void setSifraMesta(java.lang.String sifraMesta) {
		this.sifraMesta = sifraMesta;
	}

	public java.lang.String getNazivMesta() {
		return nazivMesta;
	}

	public void setNazivMesta(java.lang.String nazivMesta) {
		this.nazivMesta = nazivMesta;
	}

	public Drzava getDrzava() {
		return drzava;
	}

	public void setDrzava(Drzava drzava) {
		this.drzava = drzava;
	}

	/** @pdGenerated default getter */
	public java.util.Collection<Nalog> getNalog() {
		if (nalog == null)
			nalog = new java.util.HashSet<Nalog>();
		return nalog;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorNalog() {
		if (nalog == null)
			nalog = new java.util.HashSet<Nalog>();
		return nalog.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newNalog
	 */
	public void setNalog(java.util.Collection<Nalog> newNalog) {
		removeAllNalog();
		for (java.util.Iterator iter = newNalog.iterator(); iter.hasNext();)
			addNalog((Nalog) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newNalog
	 */
	public void addNalog(Nalog newNalog) {
		if (newNalog == null)
			return;
		if (this.nalog == null)
			this.nalog = new java.util.HashSet<Nalog>();
		if (!this.nalog.contains(newNalog))
			this.nalog.add(newNalog);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldNalog
	 */
	public void removeNalog(Nalog oldNalog) {
		if (oldNalog == null)
			return;
		if (this.nalog != null)
			if (this.nalog.contains(oldNalog))
				this.nalog.remove(oldNalog);
	}

	/** @pdGenerated default removeAll */
	public void removeAllNalog() {
		if (nalog != null)
			nalog.clear();
	}

}