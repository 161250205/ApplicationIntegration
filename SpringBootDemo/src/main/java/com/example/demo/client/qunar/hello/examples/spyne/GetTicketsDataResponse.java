
package com.example.demo.client.qunar.hello.examples.spyne;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import com.example.demo.client.qunar.project.TicketArray;


/**
 * <p>getTicketsDataResponse complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="getTicketsDataResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="getTicketsDataResult" type="{Project}TicketArray" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTicketsDataResponse", propOrder = {
    "getTicketsDataResult"
})
public class GetTicketsDataResponse {

    @XmlElementRef(name = "getTicketsDataResult", namespace = "spyne.examples.hello", type = JAXBElement.class, required = false)
    protected JAXBElement<TicketArray> getTicketsDataResult;

    /**
     * ��ȡgetTicketsDataResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TicketArray }{@code >}
     *     
     */
    public JAXBElement<TicketArray> getGetTicketsDataResult() {
        return getTicketsDataResult;
    }

    /**
     * ����getTicketsDataResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TicketArray }{@code >}
     *     
     */
    public void setGetTicketsDataResult(JAXBElement<TicketArray> value) {
        this.getTicketsDataResult = value;
    }

}
