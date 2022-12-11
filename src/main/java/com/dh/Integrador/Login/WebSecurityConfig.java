package com.dh.Integrador.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private userService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    public WebSecurityConfig(userService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
            .antMatchers("/", "static/**").permitAll()
            .antMatchers("/admin").hasRole("ADMIN")
            .antMatchers("/viewAdmin.html").hasRole("ADMIN")
            .antMatchers("/dentist").hasRole("ADMIN")
            .antMatchers("/patients").hasRole("ADMIN")
            .antMatchers("/user").hasRole("USER")
            .antMatchers("/viweUser.html").hasRole("USER")
            .antMatchers("/turns").hasRole("USER")
            .anyRequest().authenticated().and()
            .formLogin().and().logout().and().httpBasic();
    }


}
