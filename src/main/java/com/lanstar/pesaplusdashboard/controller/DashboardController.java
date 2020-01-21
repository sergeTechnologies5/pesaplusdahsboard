package com.lanstar.pesaplusdashboard.controller;

import com.lanstar.pesaplusdashboard.model.Customer;
import com.lanstar.pesaplusdashboard.model.CustomerInfo;
import com.lanstar.pesaplusdashboard.model.CustomerModel;
import com.lanstar.pesaplusdashboard.model.Sacco;
import com.lanstar.pesaplusdashboard.payload.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class DashboardController {

    @RequestMapping("/")
    public String login() {
        return "login";
    }

    @RequestMapping("dashboard/index")
    public String dashboard(@SessionAttribute("user") User user, final Model model ) {
        model.addAttribute("user",user);
        return "dashboard/index";
    }

    @RequestMapping("customers/create_customer")
    public String addCustomer(@SessionAttribute("user") User user, final Model model ) {
        model.addAttribute("user",user);
        model.addAttribute("customer",new CustomerInfo());
        return "customers/create_customer";
    }

    @RequestMapping("sacco/create_sacco")
    public String addSacco(@SessionAttribute("user") User user, final Model model ) {
        model.addAttribute("user",user);
        model.addAttribute("sacco",new Sacco());
        return "sacco/create_sacco";
    }





}
