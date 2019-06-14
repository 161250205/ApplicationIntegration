
package com.example.demo.client.qunar.project;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the project package. 
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

    private final static QName _Ticket_QNAME = new QName("Project", "Ticket");
    private final static QName _TicketArray_QNAME = new QName("Project", "TicketArray");
    private final static QName _TicketFlightNumber_QNAME = new QName("Project", "flightNumber");
    private final static QName _TicketCompany_QNAME = new QName("Project", "company");
    private final static QName _TicketDepartureTime_QNAME = new QName("Project", "departureTime");
    private final static QName _TicketDepartureAirport_QNAME = new QName("Project", "departureAirport");
    private final static QName _TicketArrivalTime_QNAME = new QName("Project", "arrivalTime");
    private final static QName _TicketArrivalAirport_QNAME = new QName("Project", "arrivalAirport");
    private final static QName _TicketPrice_QNAME = new QName("Project", "price");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: project
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Ticket }
     * 
     */
    public Ticket createTicket() {
        return new Ticket();
    }

    /**
     * Create an instance of {@link TicketArray }
     * 
     */
    public TicketArray createTicketArray() {
        return new TicketArray();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ticket }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Ticket }{@code >}
     */
    @XmlElementDecl(namespace = "Project", name = "Ticket")
    public JAXBElement<Ticket> createTicket(Ticket value) {
        return new JAXBElement<Ticket>(_Ticket_QNAME, Ticket.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TicketArray }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TicketArray }{@code >}
     */
    @XmlElementDecl(namespace = "Project", name = "TicketArray")
    public JAXBElement<TicketArray> createTicketArray(TicketArray value) {
        return new JAXBElement<TicketArray>(_TicketArray_QNAME, TicketArray.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "Project", name = "flightNumber", scope = Ticket.class)
    public JAXBElement<String> createTicketFlightNumber(String value) {
        return new JAXBElement<String>(_TicketFlightNumber_QNAME, String.class, Ticket.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "Project", name = "company", scope = Ticket.class)
    public JAXBElement<String> createTicketCompany(String value) {
        return new JAXBElement<String>(_TicketCompany_QNAME, String.class, Ticket.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "Project", name = "departureTime", scope = Ticket.class)
    public JAXBElement<String> createTicketDepartureTime(String value) {
        return new JAXBElement<String>(_TicketDepartureTime_QNAME, String.class, Ticket.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "Project", name = "departureAirport", scope = Ticket.class)
    public JAXBElement<String> createTicketDepartureAirport(String value) {
        return new JAXBElement<String>(_TicketDepartureAirport_QNAME, String.class, Ticket.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "Project", name = "arrivalTime", scope = Ticket.class)
    public JAXBElement<String> createTicketArrivalTime(String value) {
        return new JAXBElement<String>(_TicketArrivalTime_QNAME, String.class, Ticket.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "Project", name = "arrivalAirport", scope = Ticket.class)
    public JAXBElement<String> createTicketArrivalAirport(String value) {
        return new JAXBElement<String>(_TicketArrivalAirport_QNAME, String.class, Ticket.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "Project", name = "price", scope = Ticket.class)
    public JAXBElement<String> createTicketPrice(String value) {
        return new JAXBElement<String>(_TicketPrice_QNAME, String.class, Ticket.class, value);
    }

}
