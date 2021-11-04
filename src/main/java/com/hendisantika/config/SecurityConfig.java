package com.hendisantika.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-multi-login
 * User: TOSHIBA
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/4/2021
 * Time: 7:45 AM
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class SecurityConfig {
    @Bean
    public static PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Configuration
    @Order(1)
    public static class SpecialSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            //@formatter:off
            http
                    .antMatcher("/special/**")
                    .authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/special/login")
                    .defaultSuccessUrl("/special/home")
                    .permitAll()
                    .and()
                    .logout()
                    .logoutUrl("/special/logout")
                    .permitAll();
            //@formatter:on
        }
    }

    @Configuration
    public static class RegularSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            //@formatter:off
            http
                    .authorizeRequests()
                    .antMatchers("/css/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/regular/login")
                    .defaultSuccessUrl("/regular/home")
                    .permitAll()
                    .and()
                    .logout()
                    .logoutUrl("/regular/logout")
                    .permitAll();
            //@formatter:on
        }
    }

    @Bean
    public UserDetailsService userDetailsService() throws Exception {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User
                .withUsername("user")
                .password(encoder().encode("user"))
                .roles("USER")
                .build());

        manager.createUser(User
                .withUsername("admin")
                .password(encoder().encode("admin"))
                .roles("ADMIN")
                .build());

        return manager;
    }
}
