package com.hendisantika.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-multi-login
 * User: TOSHIBA
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/4/2021
 * Time: 7:41 AM
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("regular/home");
        registry.addViewController("/regular/home").setViewName("regular/home");
        registry.addViewController("/special/home").setViewName("special/home");
        registry.addViewController("/regular/login").setViewName("regular/login");
        registry.addViewController("/special/login").setViewName("special/login");
    }
}
