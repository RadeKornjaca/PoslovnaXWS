package sessionbeans.concrete;

import java.io.IOException;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.XMLGregorianCalendar;

import poslovnaxws.banke.Presek;
import poslovnaxws.common.Status;
import poslovnaxws.services.banka.NotificationMessage;
import sessionbeans.common.GenericDao;

@Stateless
@Local(PresekDaoLocal.class)
public class PresekDao extends GenericDao<Presek, String> implements PresekDaoLocal{

	public static final String contextPath = "poslovnaxws.banke";

	public static final String schemaName = "preseci";
	
	
	public Presek getPresek(XMLGregorianCalendar datum, String brojRacuna, int redniBroj) throws NotificationMessage{
		//datum.setDay(datum.getDay()+1);
		String strDatum = datum.toString().replace("Z", ""); 
		System.out.println(strDatum);
		Status status = new Status();
		try {
			
			//List<Presek> preseciZaDatum = findAll("(//*:presek)", true);
			//System.out.println(preseciZaDatum.size());
			//List<Presek> preseciZaDatum = findAll( "(//presek[datum='" + "2015-06-21" +
			//		"']//*:presek[//*:duznik/*:racun='" + brojRacuna + "' or //*:primalac/*:racun='" + brojRacuna + "'])[position()=" + redniBroj + "]", true);
			List<Presek> preseciZaDatum = findAll("(//*:presek[//*:duznik/*:racun='" + brojRacuna
				    + "' or //*:primalac/*:racun='" + brojRacuna + "' and ../*:datum ='"+strDatum+"'])",true);
			
			/*List<Presek> preseciZaDatum = findAll("(//*:presek[//*:duznik/*:racun='" + brojRacuna
			        + "' or //*:primalac/*:racun='" + brojRacuna + "' and ../*:datum ='2015-06-21'])",true);*/
			
			
			Presek presek = null;
			System.out.println(preseciZaDatum.size());
			if(redniBroj-1 < preseciZaDatum.size()){
				presek = preseciZaDatum.get(redniBroj-1);
			}
			else{
				status.setKod(0);
				status.setOpis("Ne postoji presek broj " + (redniBroj)
						+ " za datum: " + strDatum
						+ "; broj preseka: " + preseciZaDatum.size());
				throw new NotificationMessage(status.getOpis(), status);
			}
			/*for (TStavkaPreseka stavkaPreseka : presek.getStavkePreseka().getStavka()) {
				if(!stavkaPreseka.getDuznik().getRacun().equals(brojRacuna)){
					if(!stavkaPreseka.getPrimalac().getRacun().equals(brojRacuna)){
						return null;
					}
				}
			}*/
			return presek;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NotificationMessage e) {
				throw e;
		} catch (Exception e){
			e.printStackTrace();
		} 
		return null;
	}
	
	
	public PresekDao() {
		super(contextPath, schemaName);
	}
	
	@Override
	public Presek persist(Presek entity) throws JAXBException, IOException {
		return null;
	}
}
