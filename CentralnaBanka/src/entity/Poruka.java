/***********************************************************************
 * Module:  Poruka.java
 * Author:  Nenad
 * Purpose: Defines the Class Poruka
 ***********************************************************************/

package entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/** @pdOid e4573f75-49fa-46a0-8c33-c940152ac38d */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="poruka_tip")
@Table(name="poruka")
public abstract class Poruka{
	/** @pdOid 0e5481d8-2ce7-48b7-bd2d-8fba2a6a39d0 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_poruke", unique = true, nullable = false)
	protected Integer idPoruke;
	/** @pdOid 211d11bd-82b3-4f46-82b9-2aa254689474 */
	@Column(name = "vrsta", unique = false, nullable = false)
	protected double vrsta;
	/** @pdOid 0b9d5b13-4d3f-44bf-adfe-993e3b45b10a */
	@Column(name = "datum_poruke", unique = false, nullable = false)
	protected java.util.Date datumPoruke;
	
	public Poruka(){
		
	}
	
	public Integer getIdPoruke() {
		return idPoruke;
	}
	public void setIdPoruke(Integer idPoruke) {
		this.idPoruke = idPoruke;
	}
	public double getVrsta() {
		return vrsta;
	}
	public void setVrsta(double vrsta) {
		this.vrsta = vrsta;
	}
	public java.util.Date getDatumPoruke() {
		return datumPoruke;
	}
	public void setDatumPoruke(java.util.Date datumPoruke) {
		this.datumPoruke = datumPoruke;
	}
	
	
}