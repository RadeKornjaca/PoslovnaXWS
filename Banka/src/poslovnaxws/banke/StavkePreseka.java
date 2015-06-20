package poslovnaxws.banke;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import poslovnaxws.common.TStavkaPreseka;
/**
 * Gets the value of the stavka property.
 * 
 * <p>
 * This accessor method returns a reference to the live list,
 * not a snapshot. Therefore any modification you make to the
 * returned list will be present inside the JAXB object.
 * This is why there is not a <CODE>set</CODE> method for the stavka property.
 * 
 * <p>
 * For example, to add a new item, do as follows:
 * <pre>
 *    getStavka().add(newItem);
 * </pre>
 * 
 * 
 * <p>
 * Objects of the following type(s) are allowed in the list
 * {@link TStavkaPreseka }
 * 
 * 
 */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "stavka"
    })
    public class StavkePreseka {

        protected List<TStavkaPreseka> stavka;

        
        public List<TStavkaPreseka> getStavka() {
            if (stavka == null) {
                stavka = new ArrayList<TStavkaPreseka>();
            }
            return this.stavka;
        }

    }