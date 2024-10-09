package com.example.RestAPI_IVIBO.Services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return
                httpSecurity.cors().disable().csrf().disable()
                .authorizeHttpRequests(
                        request -> request
                                .requestMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                                .requestMatchers(HttpMethod.GET,"/**").permitAll()
                                .anyRequest().authenticated()
                ).httpBasic(Customizer.withDefaults())
                .build();

    }
}
