package com.lanstar.pesaplusdashboard.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("airtime")
public class AirtimeController {

    @RequestMapping(value = "", method = {RequestMethod.GET, RequestMethod.POST})
    public String index() {
        return "airtime/index";
    }

    @RequestMapping(value = "/add_float", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView add_float() {
        ModelAndView modelAndView = new ModelAndView("airtime/add_airtime_float");
        return modelAndView ;
    }

    @RequestMapping(value = "/view_float", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView view_float() {

        ModelAndView modelAndView = new ModelAndView("airtime/view_airtime_float");
        return modelAndView;
    }
}
