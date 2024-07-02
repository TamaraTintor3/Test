package com.example.config;

import lombok.RequiredArgsConstructor;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Configuration
@EnableWebSecurity
public class SecurityConfig {


    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

	    	 logger.info("Configuring Security Filter Chain");
	        http
	            .authorizeRequests(authorizeRequests ->
	                authorizeRequests.anyRequest().permitAll()
	            )
	            .csrf().disable();
	        return http.build();
	    }
	    
}