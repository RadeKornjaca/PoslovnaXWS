package sessionbeans.concrete;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.xml.bind.JAXBException;

import poslovnaxws.banke.Uplata;
import sessionbeans.common.GenericDao;

@Stateless
@Local(UplataDaoLocal.class)
public class UplataDao extends GenericDao<Uplata, Long> implements
		UplataDaoLocal {

	public static final String contextPath = "poslovnaxws.banke";

	public static final String schemaName = "uplata";

	public UplataDao() {
		super(contextPath, schemaName);
	}

	@Override
	public HashMap<String, List<Uplata>> setupClearing() throws IOException,
			JAXBException {
		HashMap<String, List<Uplata>> uplatePoBanci = new HashMap<String, List<Uplata>>();
		List<Uplata> uplate = findAll(
				"(//*:uplata[*:nalog/*:iznos<250000 and *:nalog/*:hitno=false()] )",
				true);

		for (Uplata uplata : uplate) {
			String racunBankePoverioca = uplata.getNalog().getPrimalac()
					.getRacun().substring(0, 3);
			if (uplatePoBanci.containsKey(racunBankePoverioca)) {
				uplatePoBanci.get(racunBankePoverioca).add(uplata);
			} else {
				List<Uplata> uplateZaBanku = new ArrayList<Uplata>();
				uplateZaBanku.add(uplata);
				uplatePoBanci.put(racunBankePoverioca, uplateZaBanku);
			}
		}
		
		return uplatePoBanci;

	}

}
