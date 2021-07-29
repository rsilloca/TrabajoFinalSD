
package com.soap6.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.soap6.ws package. 
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

    private final static QName _AddDocente_QNAME = new QName("http://ws.soap6.com/", "addDocente");
    private final static QName _AddDocenteResponse_QNAME = new QName("http://ws.soap6.com/", "addDocenteResponse");
    private final static QName _GetDocenteResponse_QNAME = new QName("http://ws.soap6.com/", "getDocenteResponse");
    private final static QName _GetDocentesResponse_QNAME = new QName("http://ws.soap6.com/", "getDocentesResponse");
    private final static QName _GetDocentes_QNAME = new QName("http://ws.soap6.com/", "getDocentes");
    private final static QName _GetDocente_QNAME = new QName("http://ws.soap6.com/", "getDocente");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.soap6.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDocentes }
     * 
     */
    public GetDocentes createGetDocentes() {
        return new GetDocentes();
    }

    /**
     * Create an instance of {@link GetDocentesResponse }
     * 
     */
    public GetDocentesResponse createGetDocentesResponse() {
        return new GetDocentesResponse();
    }

    /**
     * Create an instance of {@link GetDocente }
     * 
     */
    public GetDocente createGetDocente() {
        return new GetDocente();
    }

    /**
     * Create an instance of {@link AddDocente }
     * 
     */
    public AddDocente createAddDocente() {
        return new AddDocente();
    }

    /**
     * Create an instance of {@link GetDocenteResponse }
     * 
     */
    public GetDocenteResponse createGetDocenteResponse() {
        return new GetDocenteResponse();
    }

    /**
     * Create an instance of {@link AddDocenteResponse }
     * 
     */
    public AddDocenteResponse createAddDocenteResponse() {
        return new AddDocenteResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddDocente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap6.com/", name = "addDocente")
    public JAXBElement<AddDocente> createAddDocente(AddDocente value) {
        return new JAXBElement<AddDocente>(_AddDocente_QNAME, AddDocente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddDocenteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap6.com/", name = "addDocenteResponse")
    public JAXBElement<AddDocenteResponse> createAddDocenteResponse(AddDocenteResponse value) {
        return new JAXBElement<AddDocenteResponse>(_AddDocenteResponse_QNAME, AddDocenteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDocenteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap6.com/", name = "getDocenteResponse")
    public JAXBElement<GetDocenteResponse> createGetDocenteResponse(GetDocenteResponse value) {
        return new JAXBElement<GetDocenteResponse>(_GetDocenteResponse_QNAME, GetDocenteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDocentesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap6.com/", name = "getDocentesResponse")
    public JAXBElement<GetDocentesResponse> createGetDocentesResponse(GetDocentesResponse value) {
        return new JAXBElement<GetDocentesResponse>(_GetDocentesResponse_QNAME, GetDocentesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDocentes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap6.com/", name = "getDocentes")
    public JAXBElement<GetDocentes> createGetDocentes(GetDocentes value) {
        return new JAXBElement<GetDocentes>(_GetDocentes_QNAME, GetDocentes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDocente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap6.com/", name = "getDocente")
    public JAXBElement<GetDocente> createGetDocente(GetDocente value) {
        return new JAXBElement<GetDocente>(_GetDocente_QNAME, GetDocente.class, null, value);
    }

}
