package com.lanstar.pesaplusdashboard.controller.ui;

import com.lanstar.pesaplusdashboard.controller.command.PasswordFormCommand;
import com.lanstar.pesaplusdashboard.controller.command.ProfileFormCommand;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("settings")
public class Settings {

    @RequestMapping(value = "", method = {RequestMethod.GET, RequestMethod.POST})
    public String index() {
        return "settings/index";
    }

    @RequestMapping(value = "profile", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView profile() {

        ModelAndView modelAndView = new ModelAndView("settings/profile");
        ProfileFormCommand profileFormCommand = new ProfileFormCommand()
                .setFirstName("TEST")
                .setLastName("TEST")
                .setMobileNumber("TEST");
        PasswordFormCommand passwordFormCommand = new PasswordFormCommand()
                .setEmail("TEST")
                .setPassword("TEST");
        modelAndView.addObject("profileForm", profileFormCommand);
        modelAndView.addObject("passwordForm", passwordFormCommand);
        modelAndView.addObject("userName","TEST");
        return modelAndView;
    }

}
