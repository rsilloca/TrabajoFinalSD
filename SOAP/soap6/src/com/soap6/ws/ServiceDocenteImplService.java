
package com.soap6.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ServiceDocenteImplService", targetNamespace = "http://ws.soap6.com/", wsdlLocation = "http://localhost:1515/WS/DOCENTE?wsdl")
public class ServiceDocenteImplService
    extends Service
{

    private final static URL SERVICEDOCENTEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException SERVICEDOCENTEIMPLSERVICE_EXCEPTION;
    private final static QName SERVICEDOCENTEIMPLSERVICE_QNAME = new QName("http://ws.soap6.com/", "ServiceDocenteImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:1515/WS/DOCENTE?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SERVICEDOCENTEIMPLSERVICE_WSDL_LOCATION = url;
        SERVICEDOCENTEIMPLSERVICE_EXCEPTION = e;
    }

    public ServiceDocenteImplService() {
        super(__getWsdlLocation(), SERVICEDOCENTEIMPLSERVICE_QNAME);
    }

    public ServiceDocenteImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SERVICEDOCENTEIMPLSERVICE_QNAME, features);
    }

    public ServiceDocenteImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICEDOCENTEIMPLSERVICE_QNAME);
    }

    public ServiceDocenteImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SERVICEDOCENTEIMPLSERVICE_QNAME, features);
    }

    public ServiceDocenteImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServiceDocenteImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ServiceDocente
     */
    @WebEndpoint(name = "ServiceDocenteImplPort")
    public ServiceDocente getServiceDocenteImplPort() {
        return super.getPort(new QName("http://ws.soap6.com/", "ServiceDocenteImplPort"), ServiceDocente.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServiceDocente
     */
    @WebEndpoint(name = "ServiceDocenteImplPort")
    public ServiceDocente getServiceDocenteImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.soap6.com/", "ServiceDocenteImplPort"), ServiceDocente.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SERVICEDOCENTEIMPLSERVICE_EXCEPTION!= null) {
            throw SERVICEDOCENTEIMPLSERVICE_EXCEPTION;
        }
        return SERVICEDOCENTEIMPLSERVICE_WSDL_LOCATION;
    }

}
