package com;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;

/**
 * This class was generated by Apache CXF 3.3.2
 * 2019-06-08T16:23:29.672+08:00
 * Generated source version: 3.3.2
 *
 */
@WebService(targetNamespace = "http://service/", name = "Tuniu")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface Tuniu {

    @WebMethod
    @Action(input = "http://service/Tuniu/getTuniuDataRequest", output = "http://service/Tuniu/getTuniuDataResponse")
    @WebResult(name = "InfoListType", targetNamespace = "http://service/", partName = "InfoListType")
    InfoListType getTuniuData();
}