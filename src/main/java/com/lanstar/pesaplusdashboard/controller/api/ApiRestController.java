package com.lanstar.pesaplusdashboard.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ApiRestController {

    @GetMapping("test")
    public String index(){
        return "{'test' : ' good'}";
    }

    @PostMapping("otp")
    public String getOTP(){
        return "{'test' : ' good'}";
    }

}
