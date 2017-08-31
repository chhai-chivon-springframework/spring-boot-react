package com.chhaichivon.backend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/28/2017
 * TIME   : 4:09 PM
 */

public class MvcConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("/login/login");
        /*registry.addViewController("/API.KSL").setViewName("/admin/login");*/
/*		registry.addViewController("/LOGIN").setViewName("/admin/login");
		registry.addViewController("/API.KSL/LOGIN").setViewName("/admin/login");*/
       /* registry.addViewController("/developer").setViewName("/swagger");*/
        // Errors
     /*   registry.addViewController("/404").setViewName("/error/404");
        registry.addViewController("/access-denied").setViewName("/error/404");*/

    }



    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET","POST","DELETE","PUT","OPTIONS","PATCH")
                .allowedOrigins("*");
    }

    /*@Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSizePerFile(104857600);
        return resolver;
    }*/

//	 @Bean
//	    public MultipartFilter multipartFilter() {
//	            MultipartFilter multipartFilter = new MultipartFilter();
//	        multipartFilter.setMultipartResolverBeanName("multipartResolver");
//	        return multipartFilter;
//	    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/files/images/**").addResourceLocations("file:/opt/images/");
    }

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        return resolver;
    }


//	@Bean
//	public ViewResolver viewResolver(){
//		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		resolver.setPrefix("/WEB-INF/pages/");
//		resolver.setSuffix(".jsp");
//		return resolver;
//	}

//	@Bean
//	public MultipartResolver multipartResolver() {
//	    return new CommonsMultipartResolver();
//	}

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
}