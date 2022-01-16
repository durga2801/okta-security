package com.durgendra.okta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class CustomWebSecurityConfigurerAdapter
  extends WebSecurityConfigurerAdapter {

	@Autowired
	private JWTRequestFilter requestFilter;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterAfter(
        		requestFilter, BasicAuthenticationFilter.class);
    }
}