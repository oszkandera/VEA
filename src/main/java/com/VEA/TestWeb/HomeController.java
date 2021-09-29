package com.VEA.TestWeb;

import com.VEA.TestWeb.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String greeting()
    {
        var users = userRepository.findAll();

        return "hello";
    }

}