package com.lanstar.pesaplusdashboard.controller.ui;

import com.lanstar.pesaplusdashboard.model.Customers;
import com.lanstar.pesaplusdashboard.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController {

    private CustomersService customerService;

    @Autowired
    public void setCustomerService(CustomersService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = {"/customers"}, method = {RequestMethod.GET})
    public ModelAndView index( Model model) {
        Page<Customers> page = customerService.getList(1);
        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("list", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        ModelAndView modelAndView = new ModelAndView("customers/list");
        return modelAndView;
    }

    @RequestMapping(value = "/customers/{pageNumber}", method = RequestMethod.GET)
    public ModelAndView list(@PathVariable Integer pageNumber, Model model) {
        Page<Customers> page = customerService.getList(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("list", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        ModelAndView modelAndView = new ModelAndView("customers/list");

        return modelAndView;

    }

    @RequestMapping(value = "/customers/add", method = {RequestMethod.GET})
    public ModelAndView add(ModelAndView modelAndView) {

        modelAndView.setViewName("customers/form");
        modelAndView.addObject("customer", new Customers());
        return modelAndView;

    }

    @RequestMapping("/customers/edit/{id}")
    public ModelAndView edit(@PathVariable Long id, Model model) {

       // model.addAttribute("customer", customerService.get(id));
        ModelAndView modelAndView = new ModelAndView("customers/form");
        return modelAndView;

    }

    @RequestMapping(value = "/customers/save", method = RequestMethod.POST)
    public String save(Customers customer, final RedirectAttributes ra) {

       // Customers save = customerService.save(customer);
        ra.addFlashAttribute("successFlash", "Record Saved Successfully.");
        return "redirect:/";

    }

    @RequestMapping("/customers/delete/{id}")
    public ModelAndView delete(@PathVariable Long id, final RedirectAttributes ra) {

        customerService.delete(id);
        ra.addFlashAttribute("successFlash", "Record Deleted Successfully.");
        ModelAndView modelAndView = new ModelAndView("customers/list");
        return modelAndView;

    }

}
