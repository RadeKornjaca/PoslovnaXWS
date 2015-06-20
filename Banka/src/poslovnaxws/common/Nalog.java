package poslovnaxws.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Nalog", propOrder = {
    "id",
    "duznik",
    "svrhaPlacanja",
    "primalac",
    "datumNaloga",
    "datumValute",
    "iznos",
    "oznakaValute",
    "hitno",
    "naseljenoMesto"
})
@XmlRootElement(name="nalog",namespace="PoslovnaXWS/Common")
public class Nalog extends TNalog {

}
