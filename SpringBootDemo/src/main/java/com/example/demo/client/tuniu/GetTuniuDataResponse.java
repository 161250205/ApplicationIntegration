
package com.example.demo.client.tuniu;
import com.example.demo.bean.InfoListType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>getTuniuDataResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="getTuniuDataResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://com/}infoListType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTuniuDataResponse", propOrder = {
    "_return"
})
public class GetTuniuDataResponse {

    @XmlElement(name = "return")
    protected InfoListType _return;

    /**
     * 获取return属性的值。
     * 
     * @return
     *     possible object is
     *     {@link InfoListType }
     *     
     */
    public InfoListType getReturn() {
        return _return;
    }

    /**
     * 设置return属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link InfoListType }
     *     
     */
    public void setReturn(InfoListType value) {
        this._return = value;
    }

}
