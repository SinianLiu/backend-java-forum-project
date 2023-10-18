//package com.springboot.forum.config;
//
//import com.springboot.forum.util.CommunityConstant;
//import com.springboot.forum.util.CommunityUtil;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.access.AccessDeniedHandler;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//
//@Deprecated
//@Configuration
//public class SecurityConfig implements CommunityConstant {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        web.ignoring().antMatchers("/resources/**");
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception  {
//        // 授权
//        http.authorizeRequests()
//                .antMatchers(
//                        "/user/setting",
//                        "/user/upload",
//                        "/discuss/add",
//                        "/comment/add/**",
//                        "/letter/**",
//                        "/notice/**",
//                        "/like",
//                        "/follow",
//                        "/unfollow"
//                )
//                .hasAnyAuthority(
//                        AUTHORITY_USER,
//                        AUTHORITY_ADMIN,
//                        AUTHORITY_MODERATOR
//                )
//                .antMatchers(
//                        "/discuss/top",
//                        "/discuss/wonderful"
//                )
//                .hasAnyAuthority(
//                        AUTHORITY_MODERATOR
//                )
//                .antMatchers(
//                        "/discuss/delete",
//                        "/data/**"
//                )
//                .hasAnyAuthority(
//                        AUTHORITY_ADMIN
//                )
//                .anyRequest().permitAll()
////                不检查csrf攻击
//                .and().csrf().disable();
//
//        // 权限不够时的处理
//        http.exceptionHandling()
//                .authenticationEntryPoint(new AuthenticationEntryPoint() {
//                    // 没有登录
//                    @Override
//                    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
//                        String xRequestedWith = request.getHeader("x-requested-with");
//                        if ("XMLHttpRequest".equals(xRequestedWith)) {
//                            response.setContentType("application/plain;charset=utf-8");
//                            PrintWriter writer = response.getWriter();
//                            writer.write(CommunityUtil.getJSONString(403, "你还没有登录哦!"));
//                        } else {
//                            response.sendRedirect(request.getContextPath() + "/login");
//                        }
//                    }
//                })
//                .accessDeniedHandler(new AccessDeniedHandler() {
//                    // 权限不足
//                    @Override
//                    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
//                        String xRequestedWith = request.getHeader("x-requested-with");
//                        if ("XMLHttpRequest".equals(xRequestedWith)) {
//                            response.setContentType("application/plain;charset=utf-8");
//                            PrintWriter writer = response.getWriter();
//                            writer.write(CommunityUtil.getJSONString(403, "你没有访问此功能的权限!"));
//                        } else {
//                            response.sendRedirect(request.getContextPath() + "/denied");
//                        }
//                    }
//                });
//
//        // Security底层默认会拦截/logout请求,进行退出处理.
//        // 覆盖它默认的逻辑,才能执行我们自己的退出代码.
//        http.logout().logoutUrl("/securitylogout");
//    }
//
//}