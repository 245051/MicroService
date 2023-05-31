package com.cts.boot.config;

import javax.sql.DataSource;

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
public class EmpSecurityConfig extends WebSecurityConfigurerAdapter {
//	@Autowired
//	DataSource dataSource; // Will have info about database port name.
	@Autowired
	UserDetailsService userDetailsService;
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService);
		
	}

	@Bean
	@SuppressWarnings("deprecation")
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance(); //oudated library we shouldn't use it
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN").antMatchers("/user").hasAnyRole("USER").antMatchers("/").permitAll().and().formLogin();
		
	}
	

}
