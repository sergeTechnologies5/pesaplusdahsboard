package com.lanstar.pesaplusdashboard.controller;

import com.lanstar.pesaplusdashboard.model.*;
import com.lanstar.pesaplusdashboard.payload.User;
import com.lanstar.pesaplusdashboard.retrofit.network.ApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import retrofit2.Response;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class CustomerController {


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
        ModelAndView modelAndView = new ModelAndView("customers/form");
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

    @Autowired
    ApiClient apiClient;

    @PostMapping("/createCustomer")
    public String createCustomer(@SessionAttribute("user") User user,
                                 RedirectAttributes redirectAttributes,
                                 @ModelAttribute CustomerInfo customer,
                                 final  Model model, HttpSession session) throws IOException {

       // redirectAttributes.addAttribute("message","Registration Successful");
//set default
        CustomerModel customerModel= new CustomerModel();
        customerModel.setMnoInfo(new MnoInfo(1L));
        customerModel.setSaccoInfo(new SaccoInfo(73L));
        customerModel.setCustomerInfo(customer);
        System.out.println(customerModel);
        apiClient.setAuthToken(user.getToken());
        Response<String> response = apiClient.getService().createCustomer(customerModel).execute();
        if (response.isSuccessful()){
            //  JsonObject jsonObject = new JsonParser().parse(response.body()).getAsJsonObject();
            //   String token = jsonObject.get("token").getAsString();
            //  ModelAndView modelAndView = new ModelAndView();
            // modelAndView.addObject("user", user);
            //  model.addAttribute("user", user);
            redirectAttributes.addAttribute("message","Registration Successful");
            System.out.println("ResponseBody:::"+response.body().toString());
            System.out.println("ResponseHeader:::"+response.headers().toString());
            System.out.println("Response"+response.toString());
            model.addAttribute("message","Registration Successful");
            session.setAttribute("mySessionAttribute", "Registration Successful");
            String message="Registration Successful";
            //  model.addAttribute("message","Registration Successful");
            return "redirect:/customers/create_customer?message="+message;
        }else {
            System.out.println("Error");
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
