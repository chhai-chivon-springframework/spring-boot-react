package com.chhaichivon.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/28/2017
 * TIME   : 5:12 PM
 */

@Controller
public class LoginController{

    @RequestMapping("/login")
    public String login(){
        return "/login/login1";
    }

}
