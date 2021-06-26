package com.ryx.controller;

import com.ryx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsPackage: com.ryx.controller
 * @Author: 容永轩
 * @CreateTime: 2021-06-19
 * @Description:
 */
@RestController
public class HelloController {


    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello(){
        return "hello security!";
    }

    @GetMapping("/db/hello")
    public String dba(){
        return "hello db!";
    }

    @GetMapping("/admin/hello")
    public String admin(){
        return "hello admin!";
    }
    @GetMapping("/user/hello")
    public String user(){
        return "hello user!";
    }

}
