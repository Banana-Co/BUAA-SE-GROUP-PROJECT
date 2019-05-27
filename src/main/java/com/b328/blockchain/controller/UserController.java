package com.b328.blockchain.controller;

import com.b328.blockchain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    @Qualifier("UserService1")
    private UserService userService;

    @RequestMapping("/greeting")
    public String hello() {
        return "hello";
    }
}
