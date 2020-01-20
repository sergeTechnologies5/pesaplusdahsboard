package com.lanstar.pesaplusdashboard.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("transactions")
public class TransactionController {

    @RequestMapping(value = "", method = {RequestMethod.GET, RequestMethod.POST})
    public String index() {
        return "transactions/index";
    }

    @RequestMapping(value = "mpesa_fosa", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView mpesa_fosa() {
        ModelAndView modelAndView = new ModelAndView("transactions/mpesa_fosa");
        return modelAndView ;
    }
    @RequestMapping(value = "fosa_mpesa", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView fosa_mpesa() {

        ModelAndView modelAndView = new ModelAndView("transactions/fosa_mpesa");
        return modelAndView;
    }
    @RequestMapping(value = "airtime", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView airtime() {

        ModelAndView modelAndView = new ModelAndView("transactions/airtime");
        return modelAndView;
    }
}
