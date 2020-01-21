package com.lanstar.pesaplusdashboard.controller;

import com.lanstar.pesaplusdashboard.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

}
