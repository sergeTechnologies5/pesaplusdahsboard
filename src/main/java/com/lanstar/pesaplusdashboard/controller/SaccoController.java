package com.lanstar.pesaplusdashboard.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lanstar.pesaplusdashboard.model.Sacco;
import com.lanstar.pesaplusdashboard.payload.SigninRequest;
import com.lanstar.pesaplusdashboard.payload.User;
import com.lanstar.pesaplusdashboard.retrofit.network.ApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import retrofit2.Response;

import java.io.IOException;

@Controller
public class SaccoController {

    @Autowired
    ApiClient apiClient;

    @PostMapping("/createSacco")
    public String createSacco(@SessionAttribute("user") User user, @ModelAttribute Sacco sacco) throws IOException {

        sacco.setActive(false);
        sacco.setChargeRequests(false);
        sacco.setHasAirtimePurchase(true);
        apiClient.setAuthToken(user.getToken());
        Response<String> response = apiClient.getService().createSacco(sacco).execute();
        if (response.isSuccessful()){
          //  JsonObject jsonObject = new JsonParser().parse(response.body()).getAsJsonObject();
         //   String token = jsonObject.get("token").getAsString();

            //  ModelAndView modelAndView = new ModelAndView();
            // modelAndView.addObject("user", user);
          //  model.addAttribute("user", user);

            System.out.println("Response:::"+response.body().toString());
            return "redirect:"+"sacco/create_sacco";
        }else {
            System.out.println("Loading Login again");
          //  model.addAttribute("error", "Unauthorized Access");
            //  modelAndView.addObject("error", "Unauthorized Access");
            System.out.println("Login Unathorized  Access");
            return "login";
        }
    }
}
