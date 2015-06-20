/***********************************************************************
 * Module:  Poruka.java
 * Author:  Nenad
 * Purpose: Defines the Class Poruka
 ***********************************************************************/

package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import util.Restifyable;

/** @pdOid e4573f75-49fa-46a0-8c33-c940152ac38d */
@Entity
@Table(name = "poruka")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Poruka implements Restifyable{
	
	public enum Vrsta {
	    MT102 ("mt102"),
	    MT103 ("mt103"),
	    MT900 ("mt900"),
	    MT910 ("mt910");

	    private final String name;       

	    private Vrsta(String s) {
	        name = s;
	    }

	    public boolean equalsName(String otherName){
	        return (otherName == null)? false:name.equals(otherName);
	    }

	    public String toString(){
	       return name;
	    }

	}
	
	/** @pdOid 0e5481d8-2ce7-48b7-bd2d-8fba2a6a39d0 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_poruke", unique = true, nullable = false)
	protected long idPoruke;
	/** @pdOid 211d11bd-82b3-4f46-82b9-2aa254689474 */
	@Column(name = "vrsta", unique = false, nullable = false)
	protected String vrsta;
	/** @pdOid 0b9d5b13-4d3f-44bf-adfe-993e3b45b10a */
	@Column(name = "datum_poruke", unique = false, nullable = false)
	protected java.util.Date datumPoruke;
	
	public Poruka(){
		
	}
	
	public long getIdPoruke() {
		return idPoruke;
	}
	public void setIdPoruke(long idPoruke) {
		this.idPoruke = idPoruke;
	}
	public String getVrsta() {
		return vrsta;
	}
	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}
	public java.util.Date getDatumPoruke() {
		return datumPoruke;
	}
	public void setDatumPoruke(java.util.Date datumPoruke) {
		this.datumPoruke = datumPoruke;
	}
	
	
}