package com.example.demo.bean.jaxb;

import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Shuaiyu Yao
 * @create 2019-05-16 16:22
 */
@Setter
@ToString
@XmlRootElement(name = "infoList", namespace = "http://jw.nju.edu.cn/schema/info")
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlType(name = "infoListType",
        namespace = "http://jw.nju.edu.cn/schema/info",
        propOrder = {"infos"})
public class InfoListXml implements Serializable {

    @XmlElement(name = "info", namespace = "http://jw.nju.edu.cn/schema/info")
    private List<InfoXml> infos;

    @XmlAttribute(name = "company", namespace = "http://jw.nju.edu.cn/schema/info")
    private String company;//平台？

    @XmlTransient
    public List<InfoXml> getInfos() {
        return infos;
    }

    @XmlTransient
    public String getCompany() {
        return company;
    }
}
