package com.lanstar.pesaplusdashboard.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lanstar.pesaplusdashboard.model.*;
import com.lanstar.pesaplusdashboard.payload.User;
import com.lanstar.pesaplusdashboard.retrofit.network.ApiClient;
import com.lanstar.pesaplusdashboard.utils.LanstarUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import retrofit2.Response;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class AdminDashboard {

    @Autowired
    LanstarUtils lanstarUtils;

    @Autowired
    ApiClient apiClient;

    @RequestMapping("dashboard/admin")
    public String adminDashboard(@SessionAttribute("user") User user, final Model model ) throws IOException {

        model.addAttribute("saccos", lanstarUtils.getAllSaccos(user));
        model.addAttribute("user",user);
        return "dashboard/admin";
    }

    @RequestMapping("sacco/view_saccos")
    public String viewSaccos(@SessionAttribute("user") User user, final Model model ) throws IOException {

        model.addAttribute("saccos", lanstarUtils.getAllSaccos(user));
        model.addAttribute("user",user);
        return "sacco/view_saccos";
    }


    @RequestMapping("sacco/create_sacco")
    public String addSacco(@SessionAttribute("user") User user, final Model model ) {
        model.addAttribute("user",user);
        model.addAttribute("sacco",new Sacco());
        return "sacco/create_sacco";
    }

    @RequestMapping("mnos/create_mnos")
    public String createMno(@SessionAttribute("user") User user, final Model model ) {
        model.addAttribute("user",user);
        model.addAttribute("mno",new MnoInfo());
        return "mnos/create_mnos";
    }

    @RequestMapping("mnos/view_mnos")
    public String viewMnos(@SessionAttribute("user") User user, final Model model ) throws IOException {

        model.addAttribute("mnos", lanstarUtils.getCustomerMO(user));
        model.addAttribute("user",user);
        return "mnos/view_mnos";
    }


//    USER PANEL

    @RequestMapping("users/create_user")
    public String createUser(@SessionAttribute("user") User user, final Model model ) {
        model.addAttribute("user",user);
        model.addAttribute("mno",new MnoInfo());
        return "users/create_user";
    }

    @RequestMapping("users/view_users")
    public String viewUsers(@SessionAttribute("user") User user, final Model model ) throws IOException {
        model.addAttribute("mnos", lanstarUtils.getCustomerMO(user));
        model.addAttribute("user",user);
        return "users/view_users";
    }






}
