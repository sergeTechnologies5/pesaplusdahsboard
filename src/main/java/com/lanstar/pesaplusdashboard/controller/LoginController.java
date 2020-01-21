package com.lanstar.pesaplusdashboard.controller.ui;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lanstar.pesaplusdashboard.payload.SigninRequest;
import com.lanstar.pesaplusdashboard.payload.User;
import com.lanstar.pesaplusdashboard.retrofit.network.ApiClient;
import com.lanstar.pesaplusdashboard.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("user")
public class LoginController {

    @Autowired
    ApiClient apiClient;

    @PostMapping("/login")
    public String login(@Valid SigninRequest signinRequest,Model model, @ModelAttribute User user) throws IOException {
        Response<String> response = apiClient.getService().login(new SigninRequest(signinRequest.getUsername(), signinRequest.getPassword())).execute();
        if (response.isSuccessful()){
            JsonObject jsonObject = new JsonParser().parse(response.body()).getAsJsonObject();
            String token = jsonObject.get("token").getAsString();
           user = new User(signinRequest.getUsername(), token);
          //  ModelAndView modelAndView = new ModelAndView();
           // modelAndView.addObject("user", user);
            model.addAttribute("user", user);

            return "redirect:"+"dashboard/index";
        }else {
            System.out.println("Loading Login again");
            model.addAttribute("error", "Unauthorized Access");
          //  modelAndView.addObject("error", "Unauthorized Access");
            System.out.println("Login Unathorized  Access");
            return "login";
        }
    }

    @ModelAttribute("user")
    public User shoppingCart() {
        return new User();
    }

}
