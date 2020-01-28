package com.lanstar.pesaplusdashboard.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lanstar.pesaplusdashboard.Response.CustomerMO;
import com.lanstar.pesaplusdashboard.model.*;
import com.lanstar.pesaplusdashboard.payload.User;
import com.lanstar.pesaplusdashboard.request.CustomerChangePin;
import com.lanstar.pesaplusdashboard.retrofit.network.ApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import retrofit2.Response;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;

@Controller
public class CustomerController {
    @Autowired
    ApiClient apiClient;

    @RequestMapping(value = {"/customers"}, method = {RequestMethod.GET})
    public ModelAndView index( Model model) {
//        Page<Customer> page = customerService.getList(1);
//        int current = page.getNumber() + 1;
       // int begin = Math.max(1, current - 5);
       /// int end = Math.min(begin + 10, page.getTotalPages());

//        model.addAttribute("customers", page);
//        model.addAttribute("beginIndex", begin);
//        model.addAttribute("endIndex", end);
//        model.addAttribute("currentIndex", current);

        ModelAndView modelAndView = new ModelAndView("customers/list");
        return modelAndView;
    }

    @RequestMapping(value = "/customers/{pageNumber}", method = RequestMethod.GET)
    public ModelAndView list(@PathVariable Integer pageNumber, Model model) {
//        Page<Customer> page = customerService.getList(pageNumber);
//
//        int current = page.getNumber() + 1;
//        int begin = Math.max(1, current - 5);
//        int end = Math.min(begin + 10, page.getTotalPages());

//        model.addAttribute("list", page);
//        model.addAttribute("beginIndex", begin);
//        model.addAttribute("endIndex", end);
//        model.addAttribute("currentIndex", current);
        ModelAndView modelAndView = new ModelAndView("customers/list");

        return modelAndView;

    }

    @RequestMapping(value = "/customers/add", method = {RequestMethod.GET})
    public ModelAndView add(ModelAndView modelAndView) {

        modelAndView.setViewName("customers/form");
       // modelAndView.addObject("customer", new Customer());
        return modelAndView;

    }

    @RequestMapping("/customers/edit/{id}")
    public ModelAndView edit(@PathVariable Long id, Model model) {

     //   model.addAttribute("customer", customerService.get(id));
        ModelAndView modelAndView = new ModelAndView("customers/resetpin");
        return modelAndView;

    }

    @RequestMapping(value = "/customers/save", method = RequestMethod.POST)
    public String save(Customer customer, final RedirectAttributes ra) {
       // Customer save = customerService.save(customer);
        ra.addFlashAttribute("successFlash", "Record Saved Successfully.");
        return "redirect:/customers";

    }

    @RequestMapping("/customers/delete/{id}")
    public String delete(@PathVariable Long id, final RedirectAttributes ra) {
      //  customerService.delete(id);
        ra.addFlashAttribute("successFlash", "Record Deleted Successfully.");
        return "redirect:/customers";
    }



    @PostMapping("/createCustomer")
    public String createCustomer(@SessionAttribute("user") User user,
                                 RedirectAttributes redirectAttributes,
                                 @ModelAttribute Customer customer,
                                 final  Model model, HttpSession session) throws IOException {

       // redirectAttributes.addAttribute("message","Registration Successful");
//set default
        System.out.println("C:::"+customer);

        if(customer.getEmail().equalsIgnoreCase("")){
            customer.setEmail("noemail@gmail.com");
        }
        if(customer.getAdvanceLimit()==null){
            customer.setAdvanceLimit(0);
        }if(customer.getWithdrawalLimit()==null){
            customer.setAdvanceLimit(0);
        }

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
           // {"customerStatus":"Customer Registered  in NSSF Sacco Ltd Successfully"}
            redirectAttributes.addAttribute("message",customerStatus);
            model.addAttribute("message",customerStatus);
            session.setAttribute("mySessionAttribute", customerStatus);
            String message=customerStatus;
            return "redirect:/customers/create_customer?message="+message;
        }else {
            //  model.addAttribute("error", "Unauthorized Access");
            redirectAttributes.addAttribute("message","Registration Unsuccessful");
            model.addAttribute("error", "Unauthorized Access");
            System.out.println("Error"+response.errorBody().string());
            String message="Registration Not Successful";
            session.setAttribute("mySessionAttribute", "Registration Not Successful");
            return "redirect:/customers/create_customer?message="+message;
        }
    }



}
