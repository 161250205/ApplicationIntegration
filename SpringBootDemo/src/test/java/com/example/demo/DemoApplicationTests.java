package com.example.demo;

import com.example.demo.bean.AirLineData;
import com.example.demo.bean.Ticket;
import com.example.demo.bean.jaxb.InfoListXml;
import com.example.demo.dao.TicketDAO;
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

    @Autowired
    TicketDAO ticketDAO;

    @Test
    @Ignore
    public void test() {
        List<AirLineData> airLineDatas = airLineService.getAirTickets();
        for(AirLineData airLineData:airLineDatas){
            ticketDAO.save(getTic(airLineData));
        }
    }
    private Ticket getTic(AirLineData airLineData){
        Ticket ticket = new Ticket();
        ticket.setArrivalAirport(airLineData.getArrivalAirport());
        ticket.setArrivalTime(airLineData.getArrivalTime());
        ticket.setCompany(airLineData.getCompany());
        ticket.setDepartureAirport(airLineData.getDepartureAirport());
        ticket.setDepartureTime(airLineData.getDepartureTime());
        ticket.setFlightNumber(airLineData.getFlightNumber());
//        ticket.setPrice(airLineData.getQPrice());//qunar
//        ticket.setPrice(airLineData.getTPrice());//tuniu
        ticket.setPrice(airLineData.getXPrice());//xiecheng
        return ticket;
    }

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
