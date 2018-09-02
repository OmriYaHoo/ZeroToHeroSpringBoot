package com.example.demo.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.boot.autoconfigure.security.servlet.StaticResourceRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Arrays;
import java.util.List;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        List<UserDetails> userDetails = Arrays.asList(
                // we are adding prefix "{noop}" to passwords because the default PasswordEncoder is built as a DelegatingPasswordEncoder which require a matches for the plain text.
                // Since it's not good practice to save passwords in plain text we are activating NoOpPasswordEncoder flag with this prefix
                User.builder()
                        .username("omri")
                        .password("{noop}1234")
                        .authorities("ROLE_USER")
                        .build()
                , User.builder()
                        .username("admin")
                        .password("{noop}admin")
                        .authorities("ROLE_ACTUATOR", "ROLE_ADMIN", "ROLE_USER")
                        .build()
        );
        return new InMemoryUserDetailsManager(userDetails);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        StaticResourceRequest.StaticResourceRequestMatcher staticResourceRequestMatcher;
        http.authorizeRequests()
                .mvcMatchers("/admin").hasRole("ADMIN")
                .requestMatchers(EndpointRequest.to("info", "health")).permitAll()
                .requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("ACTUATOR")
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .antMatchers("/events/**").hasRole("USER")
                .antMatchers("/","/swagger-resources").permitAll()
                .antMatchers("/**").permitAll()
                .and().httpBasic();
        http.csrf().disable();
    }
}
