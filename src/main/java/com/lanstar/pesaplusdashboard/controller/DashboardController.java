package com.lanstar.pesaplusdashboard.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lanstar.pesaplusdashboard.Response.CustomerMO;
import com.lanstar.pesaplusdashboard.Response.CustomerR;
import com.lanstar.pesaplusdashboard.Response.SaccoResponse;
import com.lanstar.pesaplusdashboard.model.Customer;
import com.lanstar.pesaplusdashboard.model.Sacco;
import com.lanstar.pesaplusdashboard.payload.User;
import com.lanstar.pesaplusdashboard.retrofit.network.ApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.support.SessionStatus;
import retrofit2.Response;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    ApiClient apiClient;

    @RequestMapping("/")
    public String login() {
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(final Model model, HttpServletRequest request, HttpSession session, SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        request.removeAttribute("user");
        session.invalidate();
       // model.addAttribute("user",new User());
        return "login";
    }

    @RequestMapping("dashboard/index")
    public String dashboard(@SessionAttribute("user") User user, final Model model ) {
        model.addAttribute("user",user);
        return "dashboard/index";
    }

    /* CUSTOMER  */

      //create customer
    @RequestMapping("customers/create_customer")
    public String addCustomer(@SessionAttribute("user") User user, final Model model ) throws IOException {

        model.addAttribute("customerMOList",getCustomerMO(user));
        model.addAttribute("saccoList",getSaccos(user));
        model.addAttribute("user",user);
        model.addAttribute("customer",new Customer());
        return "customers/create_customer";
    }


    //view  Inactive Customer
    @RequestMapping("customers/inactive_customers")
    public String viewInactiveCustomers(@SessionAttribute("user") User user, final Model model ) throws IOException {
        //connect to API and Get Customer
        apiClient.setAuthToken(user.getToken());
        List<CustomerR> customerRList=new ArrayList<>();
        Response<String> response = apiClient.getService().getCustomers().execute();
        if (response.isSuccessful()) {
            assert response.body() != null;
            JsonArray jsonArray = new JsonParser().parse(response.body()).getAsJsonArray();
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jsonObject = new JsonParser().parse(jsonArray.get(i).toString()).getAsJsonObject();
                CustomerR customerR=new CustomerR(jsonObject.get("customerStatus").getAsString(),
                        jsonObject.get("customerFirstName").getAsString(),
                        jsonObject.get("customerLastName").getAsString(),
                        jsonObject.get("id").getAsString() ,
                        jsonObject.get("customerPhoneNumber").getAsString(),
                        jsonObject.get("customerSaccoID").getAsString(),
                        jsonObject.get("isRegistrationComplete").getAsString());
                customerRList.add(customerR);
            }
        } else {
            System.out.println("Error:::"+response.errorBody());
        }

        model.addAttribute("customerRList",customerRList);
        model.addAttribute("user",user);
        return "customers/inactive_customers";
    }


    //view Active Customer
    @RequestMapping("customers/active_customers")
    public String viewActiveCustomers(@SessionAttribute("user") User user, final Model model ) throws IOException {
        //connect to API and Get Customer
        apiClient.setAuthToken(user.getToken());
        List<CustomerR> customerRList=new ArrayList<>();
        Response<String> response = apiClient.getService().getActiveCustomers().execute();
        if (response.isSuccessful()) {
            assert response.body() != null;
            JsonArray jsonArray = new JsonParser().parse(response.body()).getAsJsonArray();
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jsonObject = new JsonParser().parse(jsonArray.get(i).toString()).getAsJsonObject();
                CustomerR customerR=new CustomerR(jsonObject.get("customerStatus").getAsString(),
                        jsonObject.get("customerFirstName").getAsString(),
                        jsonObject.get("customerLastName").getAsString(),
                        jsonObject.get("id").getAsString() ,
                        jsonObject.get("customerPhoneNumber").getAsString(),
                        jsonObject.get("customerSaccoID").getAsString(),
                        jsonObject.get("isRegistrationComplete").getAsString());
                customerRList.add(customerR);
            }
        } else {
            System.out.println("Error:::"+response.errorBody());
        }

        model.addAttribute("customerRList",customerRList);
        model.addAttribute("user",user);
        return "customers/active_customers";
    }





    @RequestMapping("sacco/create_sacco")
    public String addSacco(@SessionAttribute("user") User user, final Model model ) {
        model.addAttribute("user",user);
        model.addAttribute("sacco",new Sacco());
        return "sacco/create_sacco";
    }


    public List<CustomerMO> getCustomerMO(User user) throws IOException {
        apiClient.setAuthToken(user.getToken());
        List<CustomerMO> customerMOList=new ArrayList<>();
        Response<String> response = apiClient.getService().getMnos().execute();
        if (response.isSuccessful()) {
            assert response.body() != null;
            JsonArray jsonArray = new JsonParser().parse(response.body()).getAsJsonArray();
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jsonObject = new JsonParser().parse(jsonArray.get(i).toString()).getAsJsonObject();
                CustomerMO customerMO=new CustomerMO(jsonObject.get("id").getAsLong(),
                        jsonObject.get("operatorName").getAsString(),
                        jsonObject.get("phoneNumber").getAsString(),
                        jsonObject.get("serviceName").getAsString());
                customerMOList.add(customerMO);
            }
        } else {
            System.out.println("Error:::"+response.errorBody());
        }
        return customerMOList;
    }

    public List<SaccoResponse> getSaccos(User user) throws IOException {
        apiClient.setAuthToken(user.getToken());
        List<SaccoResponse> saccoResponseList=new ArrayList<>();
        Response<String> response = apiClient.getService().getSaccos().execute();
        if (response.isSuccessful()) {
            assert response.body() != null;
                JsonObject jsonObject = new JsonParser().parse(response.body()).getAsJsonObject();
                SaccoResponse saccoResponse=new SaccoResponse(jsonObject.get("saccoID").getAsLong(),
                        jsonObject.get("saccoName").getAsString());
                saccoResponseList.add(saccoResponse);

        } else {
            System.out.println("Error:::"+response.errorBody());
        }
        return saccoResponseList;
    }




}
