package com.example.demo.controller;

import com.example.demo.bean.AirLineData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/one")
public class AirLineController {
    @RequestMapping(value = "/getAirTickets",method = RequestMethod.GET)
    public List<AirLineData> getAirTickets(){
        return null;
    }
}
