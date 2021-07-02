package com.ryx;

import com.ryx.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SpringSecurityApplicationTests {

    @Autowired
    private MenuService menuService;

    @Test
    void contextLoads() {
        System.out.println(menuService.getAllMenus());
    }

    @Test
    void contextLoads5(){
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }

}
