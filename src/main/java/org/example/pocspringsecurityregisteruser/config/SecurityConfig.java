package org.example.pocspringsecurityregisteruser.config;

import org.example.pocspringsecurityregisteruser.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // @Autowired
    // UserDetailsServiceImpl userDetailsService;

    // @SuppressWarnings("removal")
    // @Bean
    // public AuthenticationManager authenticationManager(HttpSecurity http,
    // BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailsServiceImpl
    // userDetailsService) throws Exception {
    // return http.getSharedObject(AuthenticationManagerBuilder.class)
    // .userDetailsService(userDetailsService)
    // .passwordEncoder(bCryptPasswordEncoder)
    // .and().build();
    // }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/login", "/register", "/create-user", "/index").permitAll()
                .requestMatchers("/home").authenticated()
                )

        .formLogin(login -> login
                .loginPage("/index")
                .defaultSuccessUrl("/home"))

        .logout(logout -> logout.permitAll())
        
        // http.sessionManagement((sessionManagement) -> sessionManagement
        // .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        
        .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
