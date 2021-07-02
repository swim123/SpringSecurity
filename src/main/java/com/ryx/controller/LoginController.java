package com.ryx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @BelongsPackage: com.ryx.controller
 * @Author: 容永轩
 * @CreateTime: 2021-06-25
 * @Description:
 */
@Controller
public class LoginController {

//    @GetMapping("/index")
//    public String loginPage(){
//        return "index";
//    }

    @GetMapping("/login")
    @ResponseBody
    public String loginPost(){
        return "登录成功";
    }


    @GetMapping("/loginSuc")
//    @ResponseBody
    public String loginSuc(){
        return "index";
    }


}
