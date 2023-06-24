package com.boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class EmpSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	UserDetailsService userdetailsService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{//authentication
	auth.userDetailsService(userdetailsService);
	}
	
	@Bean
	@SuppressWarnings("deprecation")
	public PasswordEncoder getPasswordEncoder(){
		return NoOpPasswordEncoder.getInstance();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/admin").hasRole("ADMIN")//if somebody with name bond and james password they will identify the role as admin and then allows the admin endpoint to them
		.antMatchers("/user").hasAnyRole("ADMIN","USER")//user endpoing can be accessed by user and admin
		.antMatchers("/").permitAll()
		.and()
		.formLogin();
	}
	}


