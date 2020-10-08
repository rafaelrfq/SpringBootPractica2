package edu.pucmm.eict.alquiler.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Locale;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("/")
    public String home(Principal principal, Model model, Locale locale){
        model.addAttribute("user", principal);
        return "home";
    }
}
