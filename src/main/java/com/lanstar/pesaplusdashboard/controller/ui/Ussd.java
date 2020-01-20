package com.lanstar.pesaplusdashboard.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("ussd")
public class Ussd {

    @RequestMapping(value = "", method = {RequestMethod.GET, RequestMethod.POST})
    public String index() {
        return "ussd/index";
    }

    @RequestMapping(value = "ussd", method = {RequestMethod.GET, RequestMethod.POST})
    public String ussd() {
        return "ussd/ussd";
    }

}
