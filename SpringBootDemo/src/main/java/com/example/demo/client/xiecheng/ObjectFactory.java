
package com.example.demo.client.xiecheng;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.example.demo.bean.InfoListType;
import com.example.demo.bean.InfoType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.other.a package. 
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

    private final static QName _GetXiechengData_QNAME = new QName("http://a.other.com/", "getXiechengData");
    private final static QName _GetXiechengDataResponse_QNAME = new QName("http://a.other.com/", "getXiechengDataResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.other.a
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetXiechengData }
     * 
     */
    public GetXiechengData createGetXiechengData() {
        return new GetXiechengData();
    }

    /**
     * Create an instance of {@link GetXiechengDataResponse }
     * 
     */
    public GetXiechengDataResponse createGetXiechengDataResponse() {
        return new GetXiechengDataResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetXiechengData }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetXiechengData }{@code >}
     */
    @XmlElementDecl(namespace = "http://a.other.com/", name = "getXiechengData")
    public JAXBElement<GetXiechengData> createGetXiechengData(GetXiechengData value) {
        return new JAXBElement<GetXiechengData>(_GetXiechengData_QNAME, GetXiechengData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetXiechengDataResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetXiechengDataResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://a.other.com/", name = "getXiechengDataResponse")
    public JAXBElement<GetXiechengDataResponse> createGetXiechengDataResponse(GetXiechengDataResponse value) {
        return new JAXBElement<GetXiechengDataResponse>(_GetXiechengDataResponse_QNAME, GetXiechengDataResponse.class, null, value);
    }

}
