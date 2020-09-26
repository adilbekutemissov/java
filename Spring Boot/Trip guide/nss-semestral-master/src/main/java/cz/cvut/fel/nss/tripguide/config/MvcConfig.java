package cz.cvut.fel.nss.tripguide.config;

import cz.cvut.fel.nss.tripguide.interceptor.RequestHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * The type Mvc config.
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * The Interceptor.
     */
    @Autowired
    RequestHandlerInterceptor interceptor;

    /**
     * Add resource handlers.
     *
     * @param registry the ResourceHandlerRegistry
     */
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }

    /**
     * Add interceptors. We will have to register this Interceptor with InterceptorRegistry
     * by using WebMvcConfigurer
     *
     * @param registry the InterceptorRegistry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor).addPathPatterns("/delegate/tour/{id}/message");
    }
}
