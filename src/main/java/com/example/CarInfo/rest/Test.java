package com.example.CarInfo.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @PostMapping("/api")
    public String Printing() {
        return "Nigga";
    }
}
