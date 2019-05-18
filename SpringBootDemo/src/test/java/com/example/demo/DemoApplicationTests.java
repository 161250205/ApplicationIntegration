package com.example.demo;

import com.example.demo.bean.AirLineData;
import com.example.demo.bean.jaxb.InfoListXml;
import com.example.demo.data.DataAccessHelper;
import com.example.demo.service.AirLineService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private DataAccessHelper dataAccessHelper;

    @Autowired
    private AirLineService airLineService;

    @Test
    @Ignore
    public void contextLoads() {
        List<InfoListXml> xmlList = dataAccessHelper.getAirLineData();
        System.out.println(xmlList);
    }

    @Test
    @Ignore
    public void test2(){
        List<AirLineData> lineData=airLineService.getAirTickets();
        System.out.println(lineData);
    }
}
