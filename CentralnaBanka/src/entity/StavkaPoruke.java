/***********************************************************************
 * Module:  StavkaPoruke.java
 * Author:  Nenad
 * Purpose: Defines the Class StavkaPoruke
 ***********************************************************************/

package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/** @pdOid 5d29b62b-f62a-47c9-a2ad-d2b49071a6ff */
@Entity
@Table(name = "stavka_poruke")
public class StavkaPoruke {
	/** @pdOid 3a9484bd-861e-46c6-a48e-d9f6b40b49e2 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_stavke_poruke", unique = true, nullable = false)
	public long idStavkePoruke;
	/** @pdOid fa0457c0-a16f-4efe-ba23-c1c65c64976a */

	@Column(name = "redni_broj_stavke", unique = true, nullable = false)
	public double redniBrojStavke;
	
	@ManyToOne
	@JoinColumn(name = "id_poruke", referencedColumnName = "id_poruke", nullable = false)
	private Mt10x mt10x;
	
	@ManyToOne
	@JoinColumn(name = "id_naloga", referencedColumnName = "id_naloga", nullable = false)
	private Nalog nalog;
	
	public long getIdStavkePoruke() {
		return idStavkePoruke;
	}
	public void setIdStavkePoruke(long idStavkePoruke) {
		this.idStavkePoruke = idStavkePoruke;
	}
	public double getRedniBrojStavke() {
		return redniBrojStavke;
	}
	public void setRedniBrojStavke(double redniBrojStavke) {
		this.redniBrojStavke = redniBrojStavke;
	}
	public Mt10x getMt10x() {
		return mt10x;
	}
	public void setMt10x(Mt10x mt10x) {
		this.mt10x = mt10x;
	}
	public Nalog getNalog() {
		return nalog;
	}
	public void setNalog(Nalog nalog) {
		this.nalog = nalog;
	}

}