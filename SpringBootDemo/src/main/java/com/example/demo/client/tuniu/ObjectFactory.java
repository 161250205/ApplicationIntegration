
package com.example.demo.client.tuniu;

import com.example.demo.bean.InfoListType;
import com.example.demo.bean.InfoType;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com package. 
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

    private final static QName _GetTuniuData_QNAME = new QName("http://com/", "getTuniuData");
    private final static QName _GetTuniuDataResponse_QNAME = new QName("http://com/", "getTuniuDataResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetTuniuData }
     * 
     */
    public GetTuniuData createGetTuniuData() {
        return new GetTuniuData();
    }

    /**
     * Create an instance of {@link GetTuniuDataResponse }
     * 
     */
    public GetTuniuDataResponse createGetTuniuDataResponse() {
        return new GetTuniuDataResponse();
    }

    /**
     * Create an instance of {@link InfoListType }
     * 
     */
    public InfoListType createInfoListType() {
        return new InfoListType();
    }

    /**
     * Create an instance of {@link InfoType }
     * 
     */
    public InfoType createInfoType() {
        return new InfoType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTuniuData }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetTuniuData }{@code >}
     */
    @XmlElementDecl(namespace = "http://com/", name = "getTuniuData")
    public JAXBElement<GetTuniuData> createGetTuniuData(GetTuniuData value) {
        return new JAXBElement<GetTuniuData>(_GetTuniuData_QNAME, GetTuniuData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTuniuDataResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetTuniuDataResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://com/", name = "getTuniuDataResponse")
    public JAXBElement<GetTuniuDataResponse> createGetTuniuDataResponse(GetTuniuDataResponse value) {
        return new JAXBElement<GetTuniuDataResponse>(_GetTuniuDataResponse_QNAME, GetTuniuDataResponse.class, null, value);
    }

}
