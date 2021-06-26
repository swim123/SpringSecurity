package com.ryx.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @BelongsPackage: com.ryx.config
 * @Author: 容永轩
 * @CreateTime: 2021-06-24
 * @Description:
 */
@Component
public class MyAccessDecisionManager implements AccessDecisionManager {
    /*
    authentication  登录用户信息
    object  获取请求对象
    configAttributes  实现implements FilterInvocationSecurityMetadataSource接口重写getAttributes方法的返回值
     */
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
//        System.out.println(authentication.getPrincipal().toString());

//        roleHierarchy.getReachableGrantedAuthorities()

        for (ConfigAttribute attribute : configAttributes) {
            if ("ROLE_login".equals(attribute.getAttribute())){
                //判断authentication是否登录  如果是匿名用户
                if (authentication instanceof AnonymousAuthenticationToken){
                    throw new AccessDeniedException("非法请求");
                }else {
                    return;
                }
            }

            //正常登录 正常用户 我们就通过数据库拿到他的角色 用来决定他是否能访问
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                //访问的接口 所需要的角色 是我们用户所拥有的角色 直接break; 这里只是单纯具备一个 加入需要具备多个则另外判断
                // 而且如何解决角色继承问题也需要在这里 因为你即便注入了RoleHierarchy 但是在这里不给予放行
                if (authority.getAuthority().equals("ROLE_"+attribute.getAttribute())){
                    return;
                }
            }
        }
        throw new AccessDeniedException("非法请求");
    }


    //下面两个方法 都是告诉它支不支持 都改成true
    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
