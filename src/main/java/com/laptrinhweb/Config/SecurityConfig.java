package com.laptrinhweb.Config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.laptrinhweb.Convert.UserSecurity;
import com.laptrinhweb.Service.Implementation.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	UserService userService;
	@Autowired
	UserDetailsService userDetailsService;
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	 @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userDetailsService) 
            .passwordEncoder(passwordEncoder());
    }
	
	 @Override
    protected void configure(HttpSecurity http) throws Exception  {
		http.authorizeRequests().antMatchers("/login", "/home", "/shop", "/contact", "/blog","/product-detail","/register", "/assets/**").permitAll()
	    .anyRequest().authenticated()
	    .and().formLogin()
	    //.loginPage("/login")
	        .permitAll()
	    .defaultSuccessUrl("/home")
	    .loginProcessingUrl("/j_spring_security_check")
	    .usernameParameter("username")
	    .passwordParameter("password")
	    .and().logout().logoutSuccessUrl("/home").invalidateHttpSession(true)
	    .deleteCookies("JSESSIONID").permitAll();
		
		
		http.rememberMe().key("uniqueAndSecret").tokenValiditySeconds(1296000);
    
	}
}
