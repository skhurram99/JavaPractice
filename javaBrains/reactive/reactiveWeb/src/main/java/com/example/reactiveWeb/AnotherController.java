package com.example.reactiveWeb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnotherController {

    @GetMapping("/anotherPath")
    public String getData(){
        return "data from a different source";
    }
}
