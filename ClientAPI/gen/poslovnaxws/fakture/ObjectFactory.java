//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.05.27 at 10:40:27 PM CEST 
//


package poslovnaxws.fakture;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the poslovnaxws.fakture package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: poslovnaxws.fakture
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Faktura }
     * 
     */
    public Faktura createFaktura() {
        return new Faktura();
    }

    /**
     * Create an instance of {@link Faktura.Zaglavlje }
     * 
     */
    public Faktura.Zaglavlje createFakturaZaglavlje() {
        return new Faktura.Zaglavlje();
    }

    /**
     * Create an instance of {@link Faktura.StavkeFakture }
     * 
     */
    public Faktura.StavkeFakture createFakturaStavkeFakture() {
        return new Faktura.StavkeFakture();
    }

    /**
     * Create an instance of {@link TStavkaFakture }
     * 
     */
    public TStavkaFakture createTStavkaFakture() {
        return new TStavkaFakture();
    }

}