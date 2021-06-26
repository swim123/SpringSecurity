package com.ryx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @BelongsPackage: com.ryx.controller
 * @Author: 容永轩
 * @CreateTime: 2021-06-25
 * @Description:
 */
@Controller
public class LoginController {

    @GetMapping("/index")
    public String loginPage(){
        return "index";
    }

}
