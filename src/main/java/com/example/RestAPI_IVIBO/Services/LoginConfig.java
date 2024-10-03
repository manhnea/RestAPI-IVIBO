package com.example.RestAPI_IVIBO.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class LoginConfig {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails u1 = User.withUsername("admin")
                .password(bCryptPasswordEncoder.encode("admin"))
                .build();

        UserDetails u2 = User.withUsername("root")
                .password(bCryptPasswordEncoder.encode("root"))
                .build();
        return new InMemoryUserDetailsManager(u1, u2);

    }
}
