package com.example.demo.bean.jaxb;

import lombok.*;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * @author Shuaiyu Yao
 * @create 2019-05-16 16:22
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
@XmlRootElement(name = "info", namespace = "http://jw.nju.edu.cn/schema/info")
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlType(name = "infoType", namespace = "http://jw.nju.edu.cn/schema/info",
        propOrder = {"company", "flightNumber", "departureAirport", "arrivalAirport", "departureTime", "arrivalTime", "price"})
public class InfoXml implements Serializable {

    @XmlElement(name = "company", namespace = "http://jw.nju.edu.cn/schema/info")
    private String company;
    @XmlElement(name = "flightNumber", namespace = "http://jw.nju.edu.cn/schema/info")
    private String flightNumber;
    @XmlElement(name = "departureAirport", namespace = "http://jw.nju.edu.cn/schema/info")
    private String departureAirport;
    @XmlElement(name = "arrivalAirport", namespace = "http://jw.nju.edu.cn/schema/info")
    private String arrivalAirport;
    @XmlElement(name = "departureTime", namespace = "http://jw.nju.edu.cn/schema/info")
    private String departureTime;
    @XmlElement(name = "arrivalTime", namespace = "http://jw.nju.edu.cn/schema/info")
    private String arrivalTime;
    @XmlElement(name = "price", namespace = "http://jw.nju.edu.cn/schema/info")
    private Integer price;

    @XmlTransient
    public String getCompany() {
        return company;
    }

    @XmlTransient
    public String getFlightNumber() {
        return flightNumber;
    }

    @XmlTransient
    public String getDepartureAirport() {
        return departureAirport;
    }

    @XmlTransient
    public String getArrivalAirport() {
        return arrivalAirport;
    }

    @XmlTransient
    public String getDepartureTime() {
        return departureTime;
    }

    @XmlTransient
    public String getArrivalTime() {
        return arrivalTime;
    }

    @XmlTransient
    public Integer getPrice() {
        return price;
    }

}
