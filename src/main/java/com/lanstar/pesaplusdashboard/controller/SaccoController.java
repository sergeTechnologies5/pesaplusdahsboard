package com.lanstar.pesaplusdashboard.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lanstar.pesaplusdashboard.model.Sacco;
import com.lanstar.pesaplusdashboard.payload.SigninRequest;
import com.lanstar.pesaplusdashboard.payload.User;
import com.lanstar.pesaplusdashboard.retrofit.network.ApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import retrofit2.Response;

import java.io.IOException;

@Controller
public class SaccoController {

    @Autowired
    ApiClient apiClient;

    @PostMapping("/createSacco")
    public String createSacco() throws IOException {
        Sacco sacco=new Sacco();

        Response<String> response = apiClient.getService().createSacco(sacco).execute();
        if (response.isSuccessful()){
            JsonObject jsonObject = new JsonParser().parse(response.body()).getAsJsonObject();
            String token = jsonObject.get("token").getAsString();

            //  ModelAndView modelAndView = new ModelAndView();
            // modelAndView.addObject("user", user);
          //  model.addAttribute("user", user);

            return "redirect:"+"dashboard/index";
        }else {
            System.out.println("Loading Login again");
          //  model.addAttribute("error", "Unauthorized Access");
            //  modelAndView.addObject("error", "Unauthorized Access");
            System.out.println("Login Unathorized  Access");
            return "login";
        }
    }
}
