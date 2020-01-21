package com.lanstar.pesaplusdashboard.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("reports")
public class ReportController {

    @RequestMapping(value = "mpesa_reports", method = {RequestMethod.GET, RequestMethod.POST})
    public String mpesa() {
        return "reports/mpesa_reports";
    }

    @RequestMapping(value = "airtime_reports", method = {RequestMethod.GET, RequestMethod.POST})
    public String airtime() {
        return "reports/airtime_reports";
    }

}