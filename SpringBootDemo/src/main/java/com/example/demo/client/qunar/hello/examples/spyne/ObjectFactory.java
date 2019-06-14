
package com.example.demo.client.qunar.hello.examples.spyne;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.example.demo.client.qunar.project.TicketArray;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the hello.examples.spyne package. 
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

    private final static QName _GetTicketsData_QNAME = new QName("spyne.examples.hello", "getTicketsData");
    private final static QName _GetTicketsDataResponse_QNAME = new QName("spyne.examples.hello", "getTicketsDataResponse");
    private final static QName _GetTicketsDataResponseGetTicketsDataResult_QNAME = new QName("spyne.examples.hello", "getTicketsDataResult");
    private final static QName _GetTicketsDataCity_QNAME = new QName("spyne.examples.hello", "city");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: hello.examples.spyne
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetTicketsData }
     * 
     */
    public GetTicketsData createGetTicketsData() {
        return new GetTicketsData();
    }

    /**
     * Create an instance of {@link GetTicketsDataResponse }
     * 
     */
    public GetTicketsDataResponse createGetTicketsDataResponse() {
        return new GetTicketsDataResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTicketsData }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetTicketsData }{@code >}
     */
    @XmlElementDecl(namespace = "spyne.examples.hello", name = "getTicketsData")
    public JAXBElement<GetTicketsData> createGetTicketsData(GetTicketsData value) {
        return new JAXBElement<GetTicketsData>(_GetTicketsData_QNAME, GetTicketsData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTicketsDataResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetTicketsDataResponse }{@code >}
     */
    @XmlElementDecl(namespace = "spyne.examples.hello", name = "getTicketsDataResponse")
    public JAXBElement<GetTicketsDataResponse> createGetTicketsDataResponse(GetTicketsDataResponse value) {
        return new JAXBElement<GetTicketsDataResponse>(_GetTicketsDataResponse_QNAME, GetTicketsDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TicketArray }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TicketArray }{@code >}
     */
    @XmlElementDecl(namespace = "spyne.examples.hello", name = "getTicketsDataResult", scope = GetTicketsDataResponse.class)
    public JAXBElement<TicketArray> createGetTicketsDataResponseGetTicketsDataResult(TicketArray value) {
        return new JAXBElement<TicketArray>(_GetTicketsDataResponseGetTicketsDataResult_QNAME, TicketArray.class, GetTicketsDataResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "spyne.examples.hello", name = "city", scope = GetTicketsData.class)
    public JAXBElement<String> createGetTicketsDataCity(String value) {
        return new JAXBElement<String>(_GetTicketsDataCity_QNAME, String.class, GetTicketsData.class, value);
    }

}
