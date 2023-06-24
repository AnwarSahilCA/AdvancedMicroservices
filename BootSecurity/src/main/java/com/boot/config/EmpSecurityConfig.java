package com.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
@Order(101)
public class EmpSecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{//authentication
	auth.inMemoryAuthentication()
	.withUser("bond")
	.password("james")
	.roles("USER")
	.and()
	.withUser("pooh")
	.password("bear")
	.roles("ADMIN");
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
		.antMatchers("/user").hasAnyRole("USER")
		.antMatchers("/").permitAll()
		.and()
		.formLogin();
	}
	}


