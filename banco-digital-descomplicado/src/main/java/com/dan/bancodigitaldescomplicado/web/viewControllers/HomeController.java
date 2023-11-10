package com.dan.bancodigitaldescomplicado.web.viewControllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeController {
    
    @GetMapping
    public String home(Authentication authentication){
        return "home";
    }
}
