package com.durgendra.okta;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableWebSecurity
@EnableResourceServer
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig  {}