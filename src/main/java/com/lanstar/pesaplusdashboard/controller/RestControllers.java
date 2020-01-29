package com.lanstar.pesaplusdashboard.controller;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lanstar.pesaplusdashboard.model.*;
import com.lanstar.pesaplusdashboard.payload.User;
import com.lanstar.pesaplusdashboard.request.CustomerChangePin;
import com.lanstar.pesaplusdashboard.retrofit.network.ApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import retrofit2.Response;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;

@RestController
public class RestControllers {

    @Autowired
    ApiClient apiClient;

    /* UPDATE CUSTOMER PIN */
    @PostMapping("/update_customer_pin")
    public String updateCustomerPin(@SessionAttribute("user") User user ,
                                     final Model model, @RequestBody CustomerChangePin customerChangePin,
                                    HttpSession session) throws IOException {
       // CustomerChangePin customerChangePin = new CustomerChangePin(pin,phone,customer);
        System.out.println("Customer::: "+customerChangePin);

   //     customerChangePin.setPin();

        apiClient.setAuthToken(user.getToken());
        Response<String> response = apiClient.getService().resetCustomerPin(customerChangePin).execute();
        if (response.isSuccessful()){
            JsonObject jsonObject = new JsonParser().parse(response.body()).getAsJsonObject();
            String customerStatus = jsonObject.get("status").getAsString();
            System.out.println("Success::"+"Update Successful");
            return  customerStatus;

        }else {
            //  model.addAttribute("error", "Unauthorized Access");
            System.out.println("Error"+response.errorBody().string());
            String message="Registration Not Successful";
            session.setAttribute("mySessionAttribute", "Change Pin Not Successful");
            model.addAttribute("message", "Change Pin Not Successful");
            return "Failed";
        }


    }



    /* REGISTER CUSTOMER  */
    @PostMapping("/register_customer_api")
    public String registerCustomerRest(@SessionAttribute("user") User user ,
                                    @RequestBody Customer customer
                                   ) throws IOException {
        // CustomerChangePin customerChangePin = new CustomerChangePin(pin,phone,customer);
        System.out.println("Customer::: "+customer);
        CustomerModel customerModel= new CustomerModel();
        customerModel.setMnoInfo(new MnoInfo(customer.getMoID()));
        customerModel.setSaccoInfo(new SaccoInfo(customer.getSaccoID()));
        CustomerInfo customerInfo=new CustomerInfo(customer.getFirstName(), customer.getSecondName(),
                customer.getLastName(), customer.getPhoneNumber(),
                customer.getEmail(), customer.getNationalId(), customer.getAdvanceLimit(), customer.getWithdrawalLimit());
        customerModel.setCustomerInfo(customerInfo);
        System.out.println(customerModel);
        apiClient.setAuthToken(user.getToken());
        Response<String> response = apiClient.getService().createCustomer(customerModel).execute();
        if (response.isSuccessful()){
            JsonObject jsonObject = new JsonParser().parse(response.body()).getAsJsonObject();
            String customerStatus = jsonObject.get("customerStatus").getAsString();
            System.out.println("Success::"+customerStatus);
            return customerStatus;
        }else {
            System.out.println("Error"+response.errorBody().string());
            String message=response.errorBody().string();
            System.out.println("Failed::"+message);
            return "Internal Server Error: Try Again later";
        }
    }


    // ACTIVATE CUSTOMER
    @PostMapping("/activate_customer")
    public String activateCustomer(@SessionAttribute("user") User user , @RequestBody String json ) throws IOException {

        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        String customerID = jsonObject.get("customerID").getAsString();
        apiClient.setAuthToken(user.getToken());
        Response<String> response = apiClient.getService().activateCustomer(Long.parseLong(customerID)).execute();
        if (response.isSuccessful()){
            JsonObject jsonObject1 = new JsonParser().parse(response.body()).getAsJsonObject();
            System.out.println("Response::"+jsonObject1);
            String customerStatus = jsonObject1.get("customerStatus").getAsString();
         //   System.out.println("Success::"+customerStatus);
            return "Success: Member is now "+customerStatus;
        }else {
            System.out.println("Error"+response.errorBody().string());
            String message=response.errorBody().string();
            System.out.println("Failed::"+message);
            return "Internal Server Error: Try Again later";
        }

    }


    //  SUBMIT USER TO SERVER
    @PostMapping("/createUser")
    public String createCustomer(@SessionAttribute("user") User user,
                                 @RequestBody SystemUser systemUser,
                                 final  Model model, HttpSession session) throws IOException {

        System.out.println(systemUser);

        return systemUser.getFirstName();
        // redirectAttributes.addAttribute("message","Registration Successful");
//set default
//        System.out.println("C:::"+customer);
//
//        if(customer.getEmail().equalsIgnoreCase("")){
//            customer.setEmail("noemail@gmail.com");
//        }
//        if(customer.getAdvanceLimit()==null){
//            customer.setAdvanceLimit(0);
//        }if(customer.getWithdrawalLimit()==null){
//            customer.setAdvanceLimit(0);
//        }
//
//        CustomerModel customerModel= new CustomerModel();
//        customerModel.setMnoInfo(new MnoInfo(customer.getMoID()));
//        customerModel.setSaccoInfo(new SaccoInfo(customer.getSaccoID()));
//        CustomerInfo customerInfo=new CustomerInfo(customer.getFirstName(), customer.getSecondName(),
//                customer.getLastName(), customer.getPhoneNumber(),
//                customer.getEmail(), customer.getNationalId(), customer.getAdvanceLimit(), customer.getWithdrawalLimit());
//        customerModel.setCustomerInfo(customerInfo);
//        System.out.println(customerModel);
//        apiClient.setAuthToken(user.getToken());
//        Response<String> response = apiClient.getService().createCustomer(customerModel).execute();
//        if (response.isSuccessful()){
//            JsonObject jsonObject = new JsonParser().parse(response.body()).getAsJsonObject();
//            String customerStatus = jsonObject.get("customerStatus").getAsString();
//            // {"customerStatus":"Customer Registered  in NSSF Sacco Ltd Successfully"}
//            redirectAttributes.addAttribute("message",customerStatus);
//            model.addAttribute("message",customerStatus);
//            session.setAttribute("mySessionAttribute", customerStatus);
//            String message=customerStatus;
//            return "redirect:/customers/create_customer?message="+message;
//        }else {
//            //  model.addAttribute("error", "Unauthorized Access");
//            redirectAttributes.addAttribute("message","Registration Unsuccessful");
//            model.addAttribute("error", "Unauthorized Access");
//            System.out.println("Error"+response.errorBody().string());
//            String message="Registration Not Successful";
//            session.setAttribute("mySessionAttribute", "Registration Not Successful");
//            return "redirect:/customers/create_customer?message="+message;
//        }
    }





}
