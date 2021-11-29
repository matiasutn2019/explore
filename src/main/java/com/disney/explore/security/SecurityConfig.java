package com.disney.explore.security;

import com.disney.explore.filter.CustomAuthenticationFilter;
import com.disney.explore.filter.CustomAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
        // customAuthenticationFilter.setFilterProcessesUrl("/auth/login");
        http
            .csrf()
            .disable()
            .cors()
            .and()
            .sessionManagement()
            .sessionCreationPolicy(STATELESS)
            .and()
            .authorizeRequests()
            .antMatchers("/auth/register/**").permitAll()
            .antMatchers("/auth/login/**").permitAll()
            .antMatchers(GET, "/characters/**", "/movies/**").hasAnyRole("ROLE_USER")
            .antMatchers(GET, "/characters**", "/movies**").hasAnyRole("ROLE_USER")
            .antMatchers(POST, "/characters/**", "/movies/**").hasAnyRole("ROLE_USER")
            .antMatchers(PUT, "/characters/**", "/movies/**").hasAnyRole("ROLE_USER")
            .antMatchers(DELETE, "/characters/**", "/movies/**").hasAnyRole("ROLE_USER")
            .and()
            .authorizeRequests()
            .anyRequest()
            .authenticated();
            // .and()
            // .addFilter(customAuthenticationFilter)
            // .addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}
