package com.example.demo.controller;

import com.example.demo.bean.AirLineData;
import com.example.demo.bean.jaxb.InfoListXml;
import com.example.demo.bean.jaxb.InfoXml;
import com.example.demo.data.DataAccessHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/one")
public class AirLineController {
    @Autowired
    DataAccessHelper dataAccessHelper;
    @RequestMapping(value = "/getAirTickets",method = RequestMethod.GET)
    public List<AirLineData> getAirTickets(){
        List<InfoListXml> listXmls = dataAccessHelper.getAirLineData();
        Map<String,AirLineData> map = new HashMap<String, AirLineData>();//key : flightNumber
        for(InfoListXml info:listXmls){
            String company = info.getCompany();
            for(InfoXml infoXml:info.getInfos()){
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
        List<AirLineData> res = new ArrayList<AirLineData>(map.values());
        return res;
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

    private void transfer(AirLineData airLineData,InfoXml infoXml){
        Class ac = airLineData.getClass();
        Class ic = infoXml.getClass();
        Field[] ifields = ic.getDeclaredFields();

        for(Field field:ifields){
            String fname = field.getName();
            if(!fname.equals("price")){
                char c = fname.charAt(0);
                if(c<'z'&&c>'a'){
                    c = (char)(c-32);
                    fname = c+fname.substring(1);
                }

                try {
                    ac.getDeclaredMethod("set"+fname).invoke(airLineData,
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
