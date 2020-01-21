package com.lanstar.pesaplusdashboard.controller.ui;

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

    @RequestMapping("customers/add")
    public String addCustomer(@SessionAttribute("user") User user, final Model model ) {
        model.addAttribute("user",user);
        return "customers/form";
    }





}
