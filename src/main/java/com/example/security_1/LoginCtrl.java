package com.example.security_1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginCtrl {
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
