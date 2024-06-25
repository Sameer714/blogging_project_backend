package com.techvum.login.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.techvum.login.security.JwtAuthenticationEntryPt;
import com.techvum.login.security.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity

public class SecurityConfig {
	@Autowired
	private JwtAuthenticationEntryPt point;
	@Autowired
	private JwtAuthenticationFilter filter;

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.POST,"/v1/api/createuser").permitAll()
				.requestMatchers("/auth/login").permitAll()
				.requestMatchers(HttpMethod.POST,"/v1/api/otp/send").permitAll()
				.requestMatchers(HttpMethod.POST,"/v1/api/otp/check/otp").permitAll()
				.requestMatchers(HttpMethod.GET ,"/v1/api/getallblogs").permitAll()
				.anyRequest().authenticated()).exceptionHandling(ex -> ex.authenticationEntryPoint(point))
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}	
	
//	@Bean
//	BCryptPasswordEncoder getBCryptPasswordEncoder(){
//		return new BCryptPasswordEncoder();
//	}
}