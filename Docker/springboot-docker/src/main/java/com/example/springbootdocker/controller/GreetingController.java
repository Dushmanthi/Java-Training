package com.example.springbootdocker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class GreetingController {
    public String greeting(){
        return "<h1>Hello... this running on docker</h1>";
    }
}
