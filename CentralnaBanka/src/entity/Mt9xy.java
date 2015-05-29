/***********************************************************************
 * Module:  Mt9xy.java
 * Author:  Nenad
 * Purpose: Defines the Class Mt9xy
 ***********************************************************************/

package entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import poslovnaxws.poruke.MT900;
import poslovnaxws.poruke.MT910;

/** @pdOid 928b7313-3d67-4770-99f2-90dc6a721a77 */
@Entity
@DiscriminatorValue("mt9xy")
public class Mt9xy extends Poruka {

	@ManyToOne
	@JoinColumn(name = "id_poruke", referencedColumnName = "id_poruke", nullable = false)
	private Mt10x mt10x;

	@ManyToOne
	@JoinColumn(name = "id_banke_duznika", referencedColumnName = "id_banke", nullable = true)
	private RacunBanke racunBankeDuznika;

	@ManyToOne
	@JoinColumn(name = "id_banke_poverioca", referencedColumnName = "id_banke", nullable = true)
	private RacunBanke racunBankePoverioca;

	public Mt9xy(MT900 mt900) {
		this.setDatumPoruke(mt900.getDatumValute().toGregorianCalendar()
				.getTime());
		this.setVrsta(900);
		racunBankeDuznika = new RacunBanke(mt900.getBanka());

	}

	public Mt9xy(MT910 mt910) {
		this.setDatumPoruke(mt910.getDatumValute().toGregorianCalendar()
				.getTime());
		this.setVrsta(910);
		racunBankeDuznika = new RacunBanke(mt910.getBanka());
	}
}