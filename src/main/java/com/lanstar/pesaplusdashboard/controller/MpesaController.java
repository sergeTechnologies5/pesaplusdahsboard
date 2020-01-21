package com.lanstar.pesaplusdashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("mpesa")
public class MpesaController {

    @RequestMapping(value = "", method = {RequestMethod.GET, RequestMethod.POST})
    public String index() {
        return "mpesa/index";
    }

    @RequestMapping(value = "load_float", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView add_float() {
        ModelAndView modelAndView = new ModelAndView("mpesa/add_mpesa_float");
        return modelAndView ;
    }
    @RequestMapping(value = "view_float", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView view_float() {

        ModelAndView modelAndView = new ModelAndView("mpesa/view_mpesa_float");
        return modelAndView;
    }
}
