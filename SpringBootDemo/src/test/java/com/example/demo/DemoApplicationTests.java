package com.example.demo;

import com.example.demo.bean.AirLineData;
import com.example.demo.bean.InfoType;
import com.example.demo.bean.jaxb.InfoListXml;
import com.example.demo.client.qunar.hello.examples.spyne.Application;
import com.example.demo.client.qunar.hello.examples.spyne.QunarService;
import com.example.demo.client.tuniu.TuniuImplPortImpl;
import com.example.demo.client.tuniu.TuniuImplPortImplService;
import com.example.demo.client.xiecheng.XiechengImplPortImpl;
import com.example.demo.client.xiecheng.XiechengImplPortImplService;
import com.example.demo.dao.TicketDAO;
import com.example.demo.data.DataAccessHelper;
import com.example.demo.service.AirLineService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demo.client.qunar.project.Ticket;

import javax.xml.namespace.QName;
import java.net.URL;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

//    @Autowired
//    private DataAccessHelper dataAccessHelper;
//
//    @Autowired
//    private AirLineService airLineService;
//
//    @Autowired
//    TicketDAO ticketDAO;

    private static final QName tSERVICE_NAME = new QName("http://com/", "TuniuImplPortImplService");
    private static final QName qSERVICE_NAME = new QName("spyne.examples.hello", "QunarService");
    private static final QName xSERVICE_NAME = new QName("http://a.other.com/", "XiechengImplPortImplService");

    @Test
    public void test() {

        //使用客户端获取途牛信息
        URL twsdlURL = TuniuImplPortImplService.WSDL_LOCATION;
        TuniuImplPortImplService tss = new TuniuImplPortImplService(twsdlURL, tSERVICE_NAME);
        TuniuImplPortImpl tport = tss.getTuniuImplPortImplPort();
        //使用客户端获取携程信息
        URL xwsdlURL = XiechengImplPortImplService.WSDL_LOCATION;
        XiechengImplPortImplService xss = new XiechengImplPortImplService(xwsdlURL, xSERVICE_NAME);
        XiechengImplPortImpl xport = xss.getXiechengImplPortImplPort();
        //使用客户端获取去哪儿信息
        URL qwsdlURL = QunarService.WSDL_LOCATION;
        QunarService ss = new QunarService(qwsdlURL, qSERVICE_NAME);
        Application qport = ss.getApplication();
//
        List<Ticket> qs = qport.getTicketsData("").getTicket();
        List<InfoType> xs = xport.getXiechengData().getInfo();
        List<InfoType> ts = tport.getTuniuData().getInfo();
//        for(Ticket ticket:qs){
//            System.out.println(ticket.getFlightNumber().getValue());
//        }
        System.out.println("去哪儿:" + qs);
        System.out.println("-----------------------");
        System.out.println("途牛:" + ts);
        System.out.println("0------------------------");
        System.out.println("携程" + xs);
    }
//    private Ticket getTic(AirLineData airLineData){
//        Ticket ticket = new Ticket();
//        ticket.setArrivalAirport(airLineData.getArrivalAirport());
//        ticket.setArrivalTime(airLineData.getArrivalTime());
//        ticket.setCompany(airLineData.getCompany());
//        ticket.setDepartureAirport(airLineData.getDepartureAirport());
//        ticket.setDepartureTime(airLineData.getDepartureTime());
//        ticket.setFlightNumber(airLineData.getFlightNumber());
////        ticket.setPrice(airLineData.getQPrice());//qunar
////        ticket.setPrice(airLineData.getTPrice());//tuniu
//        ticket.setPrice(airLineData.getXPrice());//xiecheng
//        return ticket;
//    }

//    @Test
//    @Ignore
//    public void contextLoads() {
//        List<InfoListXml> xmlList = dataAccessHelper.getAirLineData();
//        System.out.println(xmlList);
//    }
//
//    @Test
//    @Ignore
//    public void test2(){
//        List<AirLineData> lineData=airLineService.getAirTickets();
//        System.out.println(lineData);
//    }
}
