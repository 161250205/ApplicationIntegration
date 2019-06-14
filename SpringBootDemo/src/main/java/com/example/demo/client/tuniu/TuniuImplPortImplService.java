package com.example.demo.client.tuniu;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.3.2
 * 2019-06-08T16:39:33.094+08:00
 * Generated source version: 3.3.2
 *
 */
@WebServiceClient(name = "TuniuImplPortImplService",
                  wsdlLocation = "http://localhost:8000/service/TuniuService?wsdl",
                  targetNamespace = "http://com/")
public class TuniuImplPortImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://com/", "TuniuImplPortImplService");
    public final static QName TuniuImplPortImplPort = new QName("http://com/", "TuniuImplPortImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8000/service/TuniuService?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(TuniuImplPortImplService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:8000/service/TuniuService?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public TuniuImplPortImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public TuniuImplPortImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TuniuImplPortImplService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public TuniuImplPortImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public TuniuImplPortImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public TuniuImplPortImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns TuniuImplPortImpl
     */
    @WebEndpoint(name = "TuniuImplPortImplPort")
    public TuniuImplPortImpl getTuniuImplPortImplPort() {
        return super.getPort(TuniuImplPortImplPort, TuniuImplPortImpl.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TuniuImplPortImpl
     */
    @WebEndpoint(name = "TuniuImplPortImplPort")
    public TuniuImplPortImpl getTuniuImplPortImplPort(WebServiceFeature... features) {
        return super.getPort(TuniuImplPortImplPort, TuniuImplPortImpl.class, features);
    }

}