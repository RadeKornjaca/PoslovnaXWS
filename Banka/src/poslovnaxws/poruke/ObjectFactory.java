
package poslovnaxws.poruke;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the poslovnaxws.poruke package. 
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

    private final static QName _MT900_QNAME = new QName("PoslovnaXWS/Poruke", "MT900");
    private final static QName _MT910_QNAME = new QName("PoslovnaXWS/Poruke", "MT910");
    private final static QName _MT102_QNAME = new QName("PoslovnaXWS/Poruke", "MT102");
    private final static QName _MT103_QNAME = new QName("PoslovnaXWS/Poruke", "MT103");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: poslovnaxws.poruke
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MT102 }
     * 
     */
    public MT102 createMT102() {
        return new MT102();
    }

    /**
     * Create an instance of {@link MT9 }
     * 
     */
    public MT9 createMT9() {
        return new MT9();
    }

    /**
     * Create an instance of {@link MT103 }
     * 
     */
    public MT103 createMT103() {
        return new MT103();
    }

    /**
     * Create an instance of {@link MT102 .Uplate }
     * 
     */
    public MT102 .Uplate createMT102Uplate() {
        return new MT102 .Uplate();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MT9 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "PoslovnaXWS/Poruke", name = "MT900")
    public JAXBElement<MT9> createMT900(MT9 value) {
        return new JAXBElement<MT9>(_MT900_QNAME, MT9 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MT9 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "PoslovnaXWS/Poruke", name = "MT910")
    public JAXBElement<MT9> createMT910(MT9 value) {
        return new JAXBElement<MT9>(_MT910_QNAME, MT9 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MT102 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "PoslovnaXWS/Poruke", name = "MT102")
    public JAXBElement<MT102> createMT102(MT102 value) {
        return new JAXBElement<MT102>(_MT102_QNAME, MT102 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MT103 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "PoslovnaXWS/Poruke", name = "MT103")
    public JAXBElement<MT103> createMT103(MT103 value) {
        return new JAXBElement<MT103>(_MT103_QNAME, MT103 .class, null, value);
    }

}
