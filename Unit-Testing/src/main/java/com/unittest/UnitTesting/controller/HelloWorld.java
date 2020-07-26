package com.unittest.UnitTesting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @RequestMapping("/{text:[a-z-]+}.{number:[\\d]+}")
    public String regularExpression(@PathVariable String text, @PathVariable String number){
        return "Got your text and Number !! ";
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello World!";
    }
}
