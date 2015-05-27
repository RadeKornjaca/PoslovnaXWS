/***********************************************************************
 * Module:  StavkaDnevnogRacuna.java
 * Author:  Nenad
 * Purpose: Defines the Class StavkaDnevnogRacuna
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

/** @pdOid 6caabe43-5559-4260-83d1-3b295eaee9c0 */
@Entity
@Table(name = "stavka_dnevnog_racuna")
public class StavkaDnevnogRacuna {
	/** @pdOid dbfb0048-3413-4169-9672-cdfe412d1a56 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_stavke_racuna", unique = true, nullable = false)
	private long idStavkeRacuna;
	/** @pdOid 721f5e13-993c-4c42-890a-d7ad483e3ae4 */
	@Column(name = "promet_na_teret", unique = false, nullable = false)
	private double prometNaTeret;
	/** @pdOid 0fe04e09-6308-4f2e-b12e-a1b5296ddb64 */
	@Column(name = "promet_u_korist", unique = false, nullable = false)
	private double prometUKorist;
	
	@ManyToOne
	@JoinColumn(name = "id_dnevnog_stanja", referencedColumnName = "id_dnevnog_stanja", nullable = false)
	private DnevnoStanjeRacuna dnevnoStanjeRacuna;
	
	@ManyToOne
	@JoinColumn(name = "id_naloga", referencedColumnName = "id_naloga", nullable = false)
	private Nalog nalog;

	public long getIdStavkeRacuna() {
		return idStavkeRacuna;
	}

	public void setIdStavkeRacuna(long idStavkeRacuna) {
		this.idStavkeRacuna = idStavkeRacuna;
	}

	public double getPrometNaTeret() {
		return prometNaTeret;
	}

	public void setPrometNaTeret(double prometNaTeret) {
		this.prometNaTeret = prometNaTeret;
	}

	public double getPrometUKorist() {
		return prometUKorist;
	}

	public void setPrometUKorist(double prometUKorist) {
		this.prometUKorist = prometUKorist;
	}

	public DnevnoStanjeRacuna getDnevnoStanjeRacuna() {
		return dnevnoStanjeRacuna;
	}

	public void setDnevnoStanjeRacuna(DnevnoStanjeRacuna dnevnoStanjeRacuna) {
		this.dnevnoStanjeRacuna = dnevnoStanjeRacuna;
	}

	public Nalog getNalog() {
		return nalog;
	}

	public void setNalog(Nalog nalog) {
		this.nalog = nalog;
	}

}