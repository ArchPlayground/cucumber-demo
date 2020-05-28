package com.upchain.arch.cucumberdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping(method={RequestMethod.GET},value={"/version"})
    public String getVersion() {
        return "v0.1";
    }

    @RequestMapping(method={RequestMethod.GET},value={"/hello"})
    public String sayHello() {
        return "Hello from Cucumber!";
    }
}