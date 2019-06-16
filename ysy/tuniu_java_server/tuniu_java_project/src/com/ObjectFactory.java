
package com;

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

    private final static QName _Info_QNAME = new QName("http://jw.nju.edu.cn/schema/info", "info");
    private final static QName _InfoList_QNAME = new QName("http://jw.nju.edu.cn/schema/info", "infoList");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InfoType }
     * 
     */
    public InfoType createInfoType() {
        return new InfoType();
    }

    /**
     * Create an instance of {@link InfoListType }
     * 
     */
    public InfoListType createInfoListType() {
        return new InfoListType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InfoType }{@code >}
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/schema/info", name = "info")
    public JAXBElement<InfoType> createInfo(InfoType value) {
        return new JAXBElement<>(_Info_QNAME, InfoType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InfoListType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InfoListType }{@code >}
     */
    @XmlElementDecl(namespace = "http://jw.nju.edu.cn/schema/info", name = "infoList")
    public JAXBElement<InfoListType> createInfoList(InfoListType value) {
        return new JAXBElement<>(_InfoList_QNAME, InfoListType.class, null, value);
    }

}
