package com.example.twrental.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{

        auth.inMemoryAuthentication().withUser("user1").password("user").roles("USER")
                .and().withUser("admin1").password("admin").roles("ADMIN");


    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){return NoOpPasswordEncoder.getInstance();
    }

    /*
    @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers()

    }*/


    @Override   //SKRIV IN VAD SOM ÄR OK FÖR DIVERSE SIDA
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests().antMatchers("/home").permitAll()
                .antMatchers("/api/v1/activeorders").hasAnyRole("USER", "ADMIN")
                .antMatchers("/api/v1/customers").hasRole("ADMIN")
                .antMatchers("/api/v1/addcar").hasRole("ADMIN")
                .antMatchers("/api/v1/deletecar/**").hasRole("ADMIN")
                .antMatchers("/api/v1/updatecar/**").hasRole("ADMIN")
                .antMatchers("/api/v1/cancelorder").hasRole("ADMIN")
                .antMatchers("/api/v1/cars").hasRole("USER")
                .antMatchers("/api/v1/ordercar").hasRole("USER")
                .antMatchers("/api/v1/updateorder/").hasRole("USER")
                .antMatchers("/api/v1/myorders").hasRole("USER")
                .and().httpBasic();
                //formLogin()
                //.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/home");
    }

}
