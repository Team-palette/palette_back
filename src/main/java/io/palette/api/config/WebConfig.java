package io.palette.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final long MAX_AGE_SEC = 3600;
    private final String EXPOSED_HEADER = "Authorization";

    // TODO: 추후 배포 시 CORS 추가 설정 필요
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedOriginPatterns("*")
                .exposedHeaders("*")
                .allowedMethods("GET", "PUT", "POST", "DELETE", "OPTIONS", "PATCH", "HEAD")
                .maxAge(MAX_AGE_SEC);
    }
}
