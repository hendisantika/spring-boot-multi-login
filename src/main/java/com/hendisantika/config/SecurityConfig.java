package com.hendisantika.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

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
}
