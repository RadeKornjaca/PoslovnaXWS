package poslovnaxws.banke;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import poslovnaxws.common.TNalog;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "bankaDB")
public class BankaDB {
	
    @XmlElement(required = true)
    protected BankaDB.Nalozi nalozi;
	
    public BankaDB.Nalozi getNalozi() {
		return nalozi;
	}

	public void setNalozi(BankaDB.Nalozi nalozi) {
		this.nalozi = nalozi;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "nalog"
    })
    public static class Nalozi {

        protected List<TNalog> nalog;

        /**
         * Gets the value of the nalog property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the nalog property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getNalog().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TNalog }
         * 
         * 
         */
        public List<TNalog> getNalog() {
            if (nalog == null) {
                nalog = new ArrayList<TNalog>();
            }
            return this.nalog;
        }

    }

}
