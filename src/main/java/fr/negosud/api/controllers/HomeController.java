package fr.negosud.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String home() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("static/index.html");
        return "test";
    }

}

