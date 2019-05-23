package net.spring.config;

import lombok.RequiredArgsConstructor;
import net.spring.interceptor.StudentInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class WebConfiguration implements WebMvcConfigurer {
    private final StudentInterceptor studentInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(studentInterceptor);
    }
}
