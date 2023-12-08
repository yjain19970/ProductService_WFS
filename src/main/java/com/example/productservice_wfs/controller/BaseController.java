package com.example.productservice_wfs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BaseController {
    @GetMapping("")
    public String getAllProducts(){
        return "Error 404....";
    }
}
