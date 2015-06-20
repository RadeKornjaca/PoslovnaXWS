
package initdb;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Banka;

@Stateless
@Remote(Init.class)
public class InitBean implements Init{

	@PersistenceContext(unitName = "CentralnaBanka")
	EntityManager em;
	
	public void init() {
		// TODO Auto-generated method stub
		Banka banka = new Banka();
		banka.setNaziv("BankaDuznik");
		banka.setSifra(123);
		banka.setSwiftKod("BANKAS12");
		em.persist(banka);
		
		/*Banka banka1 = new Banka();
		banka.setNaziv("BankaPoverilac");
		banka.setSifra(124);
		banka.setSwiftKod("BANKAS34");
		em.persist(banka1);*/
		
		/*RacunBanke racunBankeDuznika = new RacunBanke();
		racunBankeDuznika.setAktivan(true);
		racunBankeDuznika.setBanka(banka);
		racunBankeDuznika.setBrojRacuna("111-1111111111111-11");
		racunBankeDuznika.setDatumOtvaranja(new Date());
		racunBankeDuznika.setLikvidan(true);
		racunBankeDuznika.setStanjeRacuna(1000000);
		em.persist(racunBankeDuznika);
		
		RacunBanke racunBankePoverilaca = new RacunBanke();
		racunBankePoverilaca.setAktivan(true);
		racunBankePoverilaca.setBanka(banka1);
		racunBankePoverilaca.setBrojRacuna("222-2222222222222-22");
		racunBankePoverilaca.setDatumOtvaranja(new Date());
		racunBankePoverilaca.setLikvidan(true);
		racunBankePoverilaca.setStanjeRacuna(0);
		em.persist(racunBankePoverilaca);
		
		Drzava drzava = new Drzava();
		drzava.setNazivDrzave("Srbija");
		drzava.setSifraDrzave("SRB");
		em.persist(drzava);
		drzava.setIdDrzave(1);
		
		NaseljenoMesto naseljenoMesto = new NaseljenoMesto();
		naseljenoMesto.setDrzava(drzava);
		naseljenoMesto.setNazivMesta("Neko mesto");
		naseljenoMesto.setSifraMesta("1");
		em.persist(naseljenoMesto);*/
	}
	

}
