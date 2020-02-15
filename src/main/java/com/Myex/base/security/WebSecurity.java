package com.Myex.base.security;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import static com.Myex.base.security.SecurityConstans.SIGN_UP_URL;



@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
	private UserDetailsService userDetailsService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    
    
    
    
    
    public WebSecurity(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    
  
   
    
    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.cors();
        http.csrf().disable().authorizeRequests()
        		.antMatchers(HttpMethod.GET,"/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",  //Barmilyen formatumot nem hozz be ide kell berakni
                        "/**/*.json",
                        "/**/*.png",
                        "/**/*.jpg").permitAll()
                .antMatchers(HttpMethod.POST, SIGN_UP_URL).permitAll()
                .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                .antMatchers(HttpMethod.GET,"/users/allusers").permitAll()
                .antMatchers(HttpMethod.POST, "/users/adduser").permitAll()
                .antMatchers(HttpMethod.GET,"/experiments").permitAll()
                //.antMatchers(HttpMethod.POST, "/experiments/updateExperiment").permitAll()
                .antMatchers(HttpMethod.GET,"/experiments/{experimentId}").permitAll()
                .antMatchers(HttpMethod.POST,"/experiments/new").permitAll()
                .antMatchers(HttpMethod.DELETE,"/experiments/{experimentId}").permitAll()
                .antMatchers(HttpMethod.POST,"/groups/new").permitAll()
                .antMatchers(HttpMethod.GET,"/groups").permitAll()
                .antMatchers(HttpMethod.POST, "/scoretable/new").permitAll()
                .antMatchers(HttpMethod.GET, "/scoretable").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()));
    }
    
   

    
    
 
    
    

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }
    
	
}
