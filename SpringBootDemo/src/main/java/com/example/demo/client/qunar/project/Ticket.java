
package com.example.demo.client.qunar.project;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Ticket complex type�� Java �ࡣ
 * <p>
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;complexType name="Ticket"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="flightNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="company" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="departureTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="departureAirport" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="arrivalTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="arrivalAirport" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ticket", propOrder = {
        "flightNumber",
        "company",
        "departureTime",
        "departureAirport",
        "arrivalTime",
        "arrivalAirport",
        "price"
})
public class Ticket {

    @XmlElementRef(name = "flightNumber", namespace = "Project", type = JAXBElement.class, required = false)
    protected JAXBElement<String> flightNumber;
    @XmlElementRef(name = "company", namespace = "Project", type = JAXBElement.class, required = false)
    protected JAXBElement<String> company;
    @XmlElementRef(name = "departureTime", namespace = "Project", type = JAXBElement.class, required = false)
    protected JAXBElement<String> departureTime;
    @XmlElementRef(name = "departureAirport", namespace = "Project", type = JAXBElement.class, required = false)
    protected JAXBElement<String> departureAirport;
    @XmlElementRef(name = "arrivalTime", namespace = "Project", type = JAXBElement.class, required = false)
    protected JAXBElement<String> arrivalTime;
    @XmlElementRef(name = "arrivalAirport", namespace = "Project", type = JAXBElement.class, required = false)
    protected JAXBElement<String> arrivalAirport;
    @XmlElementRef(name = "price", namespace = "Project", type = JAXBElement.class, required = false)
    protected JAXBElement<String> price;

    @Override
    public String toString() {
        return "Ticket{" +
                "flightNumber=" + flightNumber.getValue() +
                ", company=" + company.getValue() +
                ", departureTime=" + departureTime.getValue() +
                ", departureAirport=" + departureAirport.getValue() +
                ", arrivalTime=" + arrivalTime.getValue() +
                ", arrivalAirport=" + arrivalAirport.getValue() +
                ", price=" + price.getValue() +
                '}';
    }

    /**
     * ��ȡflightNumber���Ե�ֵ��
     *
     * @return possible object is
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public JAXBElement<String> getFlightNumber() {
        return flightNumber;
    }

    /**
     * ����flightNumber���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public void setFlightNumber(JAXBElement<String> value) {
        this.flightNumber = value;
    }

    /**
     * ��ȡcompany���Ե�ֵ��
     *
     * @return possible object is
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public JAXBElement<String> getCompany() {
        return company;
    }

    /**
     * ����company���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public void setCompany(JAXBElement<String> value) {
        this.company = value;
    }

    /**
     * ��ȡdepartureTime���Ե�ֵ��
     *
     * @return possible object is
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public JAXBElement<String> getDepartureTime() {
        return departureTime;
    }

    /**
     * ����departureTime���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public void setDepartureTime(JAXBElement<String> value) {
        this.departureTime = value;
    }

    /**
     * ��ȡdepartureAirport���Ե�ֵ��
     *
     * @return possible object is
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public JAXBElement<String> getDepartureAirport() {
        return departureAirport;
    }

    /**
     * ����departureAirport���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public void setDepartureAirport(JAXBElement<String> value) {
        this.departureAirport = value;
    }

    /**
     * ��ȡarrivalTime���Ե�ֵ��
     *
     * @return possible object is
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public JAXBElement<String> getArrivalTime() {
        return arrivalTime;
    }

    /**
     * ����arrivalTime���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public void setArrivalTime(JAXBElement<String> value) {
        this.arrivalTime = value;
    }

    /**
     * ��ȡarrivalAirport���Ե�ֵ��
     *
     * @return possible object is
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public JAXBElement<String> getArrivalAirport() {
        return arrivalAirport;
    }

    /**
     * ����arrivalAirport���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public void setArrivalAirport(JAXBElement<String> value) {
        this.arrivalAirport = value;
    }

    /**
     * ��ȡprice���Ե�ֵ��
     *
     * @return possible object is
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public JAXBElement<String> getPrice() {
        return price;
    }

    /**
     * ����price���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public void setPrice(JAXBElement<String> value) {
        this.price = value;
    }

}
