package com.team.bazar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HelloController {

    @GetMapping()
    String hello(){
        return "hello";
    }
}
