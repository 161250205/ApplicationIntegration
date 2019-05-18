package com.example.demo.controller;

import com.example.demo.bean.AirLineData;
import com.example.demo.bean.jaxb.InfoListXml;
import com.example.demo.bean.jaxb.InfoXml;
import com.example.demo.data.DataAccessHelper;
import com.example.demo.service.AirLineService;
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
    AirLineService airLineService;
    @RequestMapping(value = "/getAirTickets",method = RequestMethod.GET)
    public List<AirLineData> getAirTickets(){
        return airLineService.getAirTickets();
    }
}
