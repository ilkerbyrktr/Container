package com.distro.Container.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/containers").hasRole("WORKER")//1
                        .requestMatchers(HttpMethod.GET, "/api/containers/**").hasRole("WORKER")//2
                        .requestMatchers(HttpMethod.GET, "/api/items").hasRole("WORKER")//8
                        .requestMatchers(HttpMethod.GET, "/api/items/**").hasRole("WORKER")//8
                        .requestMatchers(HttpMethod.GET, "/api/location").hasRole("WORKER")//6
                        .requestMatchers(HttpMethod.POST, "/api/containers").hasRole("LEADER")//3
                        .requestMatchers(HttpMethod.POST, "/api/containers/list").hasRole("LEADER")//3
                        .requestMatchers(HttpMethod.PUT, "/api/containers").hasRole("LEADER")//4
                        .requestMatchers(HttpMethod.PUT, "/api/containers/**").hasRole("LEADER")//3
                        .requestMatchers(HttpMethod.DELETE, "/api/containers/**").hasRole("MANAGER")//5
                        .requestMatchers(HttpMethod.DELETE, "/api/items/**").hasRole("MANAGER")//7

                );

        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());

        return http.build();


    }
}

   /* @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails ilker = User.builder()
                .username("ilker")
                .password("{noop}123")
                .roles("WORKER")
                .build();
        UserDetails erkan = User.builder()
                .username("erkan")
                .password("{noop}123")
                .roles("WORKER","LEADER")
                .build();
        UserDetails fatma = User.builder()
                .username("fatma")
                .password("{noop}123")
                .roles("WORKER","LEADER","MANAGER")
                .build();
        return new InMemoryUserDetailsManager(ilker,erkan,fatma);
    }*/
