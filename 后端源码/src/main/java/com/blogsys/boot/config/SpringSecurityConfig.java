package com.blogsys.boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
  /*      http
            .formLogin()
                //设置前端发过来的名称
                .usernameParameter("username")
                .passwordParameter("password")
                //当发现是login方法时认为是登录，必须和表单提交地址是一样的
                .loginProcessingUrl("/login")
                //成功后调用/toMain
                .successForwardUrl("/Login");*/
        http
            .authorizeRequests()
                .antMatchers( "/PageLoading/**","/PageReading/**","/PageQuery/**",
                        "/APP/InquirePostTotalCount","/CRUD/AddPost").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();

        http
                .cors();
    }
    @Bean
    public PasswordEncoder getpw(){
        return  new BCryptPasswordEncoder();
    }

}
