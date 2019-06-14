package com.example.demo.service.impl;

import com.example.demo.bean.AirLineData;
import com.example.demo.bean.InfoType;
import com.example.demo.client.qunar.hello.examples.spyne.Application;
import com.example.demo.client.qunar.hello.examples.spyne.QunarService;
import com.example.demo.client.qunar.project.Ticket;
import com.example.demo.client.tuniu.TuniuImplPortImpl;
import com.example.demo.client.tuniu.TuniuImplPortImplService;
import com.example.demo.client.xiecheng.XiechengImplPortImpl;
import com.example.demo.client.xiecheng.XiechengImplPortImplService;
import com.example.demo.data.DataAccessHelper;
import com.example.demo.service.AirLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.namespace.QName;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AirLineServiceImpl implements AirLineService {
    @Autowired
    DataAccessHelper dataAccessHelper;
    private static final QName tSERVICE_NAME = new QName("http://com/", "TuniuImplPortImplService");
    private static final QName qSERVICE_NAME = new QName("spyne.examples.hello", "QunarService");
    private static final QName xSERVICE_NAME = new QName("http://a.other.com/", "XiechengImplPortImplService");
    public List<AirLineData> getAirTickets(){
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

        List<InfoType> xs = xport.getXiechengData().getInfo();//携程信息
        List<InfoType> ts = tport.getTuniuData().getInfo();//途牛信息
        List<Ticket> qs = qport.getTicketsData("").getTicket();

        Map<String,AirLineData> map = new HashMap<String, AirLineData>();//key : flightNumber
        processData(ts,"途牛",map);
        processData(xs,"携程",map);
        List<AirLineData> res = new ArrayList<AirLineData>(map.values());
        return res;
    }

    private void processData(List<InfoType> s,String com,Map<String,AirLineData> map){
        for(InfoType infoXml:s){
            String company = com;
            AirLineData airLineData;
            if(map.containsKey(infoXml.getFlightNumber())){
                airLineData = map.get(infoXml.getFlightNumber());
            }else{
                airLineData = new AirLineData();
                transfer(airLineData,infoXml);
            }
            try {
                setAirLineData(airLineData, company, infoXml.getPrice());
            }catch (Exception e){
                e.printStackTrace();
            }
            map.put(infoXml.getFlightNumber(),airLineData);
        }
    }

    private void setAirLineData(AirLineData airLineData,String company,int price){
        String p = Integer.toString(price);
        if(company.equals("去哪儿")){
            airLineData.setQPrice(p);
        }else if(company.equals("途牛")){
            airLineData.setTPrice(p);
        }else if(company.equals("携程")){
            airLineData.setXPrice(p);
        }else{
            throw new IllegalArgumentException("Wrong Company Name");
        }
    }

    private void transfer(AirLineData airLineData,InfoType infoXml){
        Class ac = airLineData.getClass();
        Class ic = infoXml.getClass();
        Field[] ifields = ic.getDeclaredFields();

        for(Field field:ifields){
            String fname = field.getName();
            if(!fname.equals("price")){
                char c = fname.charAt(0);
                if(c<='z'&&c>='a'){
                    c = (char)(c-32);
                    fname = c+fname.substring(1);
                }
                try {
                    ac.getDeclaredMethod("set"+fname,String.class).invoke(airLineData,
                            (String)(ic.getDeclaredMethod("get"+fname).invoke(infoXml)));
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
