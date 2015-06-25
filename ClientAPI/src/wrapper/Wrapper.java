package wrapper;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import poslovnaxws.banke.ZahtevZaIzvod;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "wrapper", namespace = "")
public class Wrapper {

	@XmlElement(name = "data")
	private List<ZahtevZaIzvod> wrappedElement = new ArrayList<ZahtevZaIzvod>();


	public List<ZahtevZaIzvod> getWrappedElement() {
		return wrappedElement;
	}

	public void setWrappedElement(List<ZahtevZaIzvod> wrappedElement) {
		this.wrappedElement = wrappedElement;
	}

	public List<ZahtevZaIzvod> getData() {
		return wrappedElement;
	}

	public void setData(List<ZahtevZaIzvod> data) {
		this.wrappedElement = data;
	}

	public void addData(ZahtevZaIzvod data) {
		this.wrappedElement.add(data);
	}
}
