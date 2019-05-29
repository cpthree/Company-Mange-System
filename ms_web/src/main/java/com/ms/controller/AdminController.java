package com.ms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Dell on 2017/8/9.
 */
@Controller
@RequestMapping("/")
public class AdminController {

    @RequestMapping("/admin")
    public String admin(){
        return "admin_manager";
    }

}
