
package poslovnaxws.banke;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the poslovnaxws.banke package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: poslovnaxws.banke
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Presek }
     * 
     */
    public Presek createPresek() {
        return new Presek();
    }

    /**
     * Create an instance of {@link ZahtevZaIzvod }
     * 
     */
    public ZahtevZaIzvod createZahtevZaIzvod() {
        return new ZahtevZaIzvod();
    }

    /**
     * Create an instance of {@link Presek.Zaglavlje }
     * 
     */
    public Presek.Zaglavlje createPresekZaglavlje() {
        return new Presek.Zaglavlje();
    }

    /**
     * Create an instance of {@link Presek.StavkePreseka }
     * 
     */
    public Presek.StavkePreseka createPresekStavkePreseka() {
        return new Presek.StavkePreseka();
    }

}
