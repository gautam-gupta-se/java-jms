 package com.springjms.javajms.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("pass01")
                .authorities("admin")
                .build();
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("gautam")
                .password("pass02")
                .authorities("view")
                .build();
        return new InMemoryUserDetailsManager(admin,user);

    }
}