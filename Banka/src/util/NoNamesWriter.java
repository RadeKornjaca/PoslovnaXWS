package util;

import java.io.OutputStream;
import java.io.Writer;
import java.util.Iterator;

import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.cxf.staxutils.DelegatingXMLStreamWriter;

public class NoNamesWriter extends DelegatingXMLStreamWriter {

  private static final NamespaceContext emptyNamespaceContext = new NamespaceContext() {

    @Override
    public String getNamespaceURI(String prefix) {
      return "";
    }

    @Override
    public String getPrefix(String namespaceURI) {
      return "";
    }

    @Override
    public Iterator getPrefixes(String namespaceURI) {
      return null;
    }

  };

  public static XMLStreamWriter filter(OutputStream outputStream) throws XMLStreamException {
    return new NoNamesWriter(XMLOutputFactory.newInstance().createXMLStreamWriter(outputStream));
  }

  public NoNamesWriter(XMLStreamWriter writer) {
    super(writer);
  }

  @Override
  public NamespaceContext getNamespaceContext() {
    return emptyNamespaceContext;
  }

}