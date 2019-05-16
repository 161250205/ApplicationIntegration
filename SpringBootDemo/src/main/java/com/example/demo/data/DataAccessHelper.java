package com.example.demo.data;

import com.example.demo.bean.jaxb.InfoListXml;

import java.util.List;

/**
 * @author Shuaiyu Yao
 * @create 2019-05-16 17:00
 */
public interface DataAccessHelper {

    /**
     * 返回xml对应的对象
     *
     * @return
     */
    List<InfoListXml> getAirLineData();
}
