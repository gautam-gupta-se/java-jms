 package com.springjms.javajms.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        //
        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/msg","/blog").authenticated()
                .requestMatchers("/user/*","/demo").permitAll())
                .formLogin(withDefaults())
                .httpBasic(withDefaults());
        /*http.formLogin(withDefaults());
        http.httpBasic(withDefaults());*/
        return http.build();
    }
    // need to remove the UserDetailsService bean initialization otherwise it use spring default users table credentials
    // to use custom userdetails service we have to implement UserDetailsService  interface
    // if we use multiple bean then it will give error No AuthenticationProvider found for org.springframework.security.authentication.UsernamePasswordAuthenticationToken
    /*@Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }*/
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}