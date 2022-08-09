/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tvp.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tvp.formatter.CategoryFormatter;
import com.tvp.validator.StoreNameValidator;
import com.tvp.validator.WebAppValidator;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.persistence.internal.helper.Helper;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author tran van phuong
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.tvp.controllers",
    "com.tvp.repository",
    "com.tvp.service",
    "com.tvp.validator",
    "com.tvp.formatter"
})
public class WebAppContextConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer conf) {
        conf.enable();
    }

//    @Bean
//    public InternalResourceViewResolver viewResolver(){
//        InternalResourceViewResolver r = new InternalResourceViewResolver();
//        r.setPrefix("/WEB-INF/jsp/");
//        r.setSuffix(".jsp");
//        r.setViewClass(JstlView.class);
//        
//        return r;
//    }
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new CategoryFormatter());
    }

//    validator
    @Override
    public Validator getValidator() {
        return validator();
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean v = new LocalValidatorFactoryBean();

        v.setValidationMessageSource(messageSource());
        return v;
    }

//    @Bean
//    public WebAppValidator storeValidator() {
//
//        Set<Validator> springvalidators = new HashSet<>();
//        springvalidators.add(new StoreNameValidator());
//
//        WebAppValidator v = new WebAppValidator();
//        v.setSpringValidators(springvalidators);
//
//        return v;
//    }
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages");

        return source;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");

        return resolver;
    }

    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary
                = new Cloudinary(ObjectUtils.asMap(
                        "cloud_name", "dogosq8z4",
                        "api_key", "338272838275355",
                        "api_secret", "IirWac17xXkmWSBbixT_29LuGOM",
                        "secure", true));
        return cloudinary;
    }

}
