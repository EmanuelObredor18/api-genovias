package com.globalvia.genovias.api.auth.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.globalvia.genovias.api.auth.config.filters.JwtTokenValidator;
import com.globalvia.genovias.api.auth.util.JwtUtils;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  
//   @Autowired
//   private JwtUtils jwtUtils;


  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    return httpSecurity
      .csrf(csrf -> csrf.disable())
      
      .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
      .authorizeHttpRequests(http -> {
        //http.requestMatchers("/api_key").permitAll();
        http.anyRequest().permitAll();
      })
      // .addFilterBefore(new JwtTokenValidator(jwtUtils), BasicAuthenticationFilter.class)
      .build();

  }

//   @Bean
//   PasswordEncoder passwordEncoder() {
//     return new BCryptPasswordEncoder();
//   }

//   // @Bean
//   // UserDetailsService userDetailsService() {
//   //   return new UserDetailsServiceImpl();
//   // }

//   @Bean
//   AuthenticationProvider authenticationProvider(PasswordEncoder passwordEncoder) {
//     DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//     authenticationProvider.setPasswordEncoder(passwordEncoder);
//     // authenticationProvider.setUserDetailsService(userDetailsService);
//     return authenticationProvider;
//   }
}