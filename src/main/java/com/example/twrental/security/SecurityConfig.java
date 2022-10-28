package com.example.twrental.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{

        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER")
                .and().withUser("admin").password("admin").roles("ADMIN");


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
        http.csrf().disable().authorizeRequests().antMatchers("/home").permitAll()
                .antMatchers("/api/v1/booking/activeorders").hasAnyRole("USER", "ADMIN")
                .antMatchers("/api/v1/customers").hasRole("ADMIN")
                .antMatchers("/api/v1/addcar").hasRole("ADMIN")
                .antMatchers("/api/v1/deletecar/**").hasRole("ADMIN")
                .antMatchers("/api/v1/updatecar/**").hasRole("ADMIN")
                .antMatchers("/api/v1/booking/cancelorder").hasRole("ADMIN")
                .antMatchers("/api/v1/booking/cars").hasRole("USER")
                .antMatchers("/api/v1/booking/ordercar").hasRole("USER")
                .antMatchers("/api/v1/booking/updateorder/").hasRole("USER")
                .antMatchers("/api/v1/booking/myorders").hasRole("USER")
                .antMatchers("/api/v1/booking/booking/**").hasAnyRole("USER", "ADMIN")
                .and().httpBasic();
                //formLogin()
                //.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/home");


    }

}
