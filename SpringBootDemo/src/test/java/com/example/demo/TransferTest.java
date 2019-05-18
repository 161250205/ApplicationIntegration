package com.example.demo;

import com.example.demo.bean.AirLineData;
import com.example.demo.bean.jaxb.InfoXml;
import com.example.demo.service.impl.AirLineServiceImpl;
import org.junit.Test;

public class TransferTest {
    @Test
    public void test1(){
        AirLineServiceImpl airLineService = new AirLineServiceImpl();
        AirLineData airLineData = new AirLineData();
        InfoXml infoXml = new InfoXml("company1","flightNum1","departPort1","arrivalPort1","departureTime1","arrivalTime1",100);
//        airLineService.transfer(airLineData,infoXml);
        System.out.println(airLineData.toString());
    }

}
