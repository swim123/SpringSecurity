package com.ryx.config;

import com.ryx.entity.Menu;
import com.ryx.entity.Role;
import com.ryx.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @BelongsPackage: com.ryx.config
 * @Author: 容永轩
 * @CreateTime: 2021-06-24
 * @Description:
 */
//分析请求地址
@Component
public class MyFilter implements FilterInvocationSecurityMetadataSource {

    //路径匹配符
    AntPathMatcher pathMatcher = new AntPathMatcher();

    @Autowired
    private MenuService menuService;


    //根据你请求的地址 来确定你的url 分析你需要那些角色才可以访问
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        //拿到客户端请求的地址
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        //这里的查询 可以加入缓存 后续可以优化
        List<Menu> allMenus = menuService.getAllMenus();
        for (Menu menu : allMenus) {
            //加入匹配上数据库中的路径 就看角色是否够权限
            if (pathMatcher.match(menu.getPattern(),requestUrl)){
                List<Role> roles = menu.getRoles();
                //list 就是我们需要的角色
                String[] roleNeed = new String[roles.size()];
                for (int i = 0; i < roles.size(); i++) {
                    roleNeed[i] = roles.get(i).getName();
                }

                return SecurityConfig.createList(roleNeed);
            }
        }

        //假如都匹配不上 我们就特殊处理 这里的ROLE_login就是一个标记符
        return SecurityConfig.createList("ROLE_login");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
