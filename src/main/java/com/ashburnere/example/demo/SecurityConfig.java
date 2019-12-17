package com.ashburnere.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Once the spring-boot-starter-security dependency on the classpath of the
 * application – all endpoints are secured by default, using either httpBasic or
 * formLogin based on Spring Security's content-negotiation strategy.
 * 
 * That's why, if we have the starter on the classpath, we should usually define
 * our own custom Security configuration by extending the
 * WebSecurityConfigurerAdapter class:
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().permitAll().and().csrf().disable();
	}
}
