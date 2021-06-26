package com.ryx;

import com.ryx.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringSecurityApplicationTests {

    @Autowired
    private MenuService menuService;

    @Test
    void contextLoads() {
        System.out.println(menuService.getAllMenus());
    }

}
