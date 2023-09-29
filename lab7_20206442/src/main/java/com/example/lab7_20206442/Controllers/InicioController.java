package com.example.lab7_20206442.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {
    @GetMapping("")
    public String incio(){
        return "index";
    }
}
