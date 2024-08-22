package com.store;

import org.apache.http.HttpHost;
import org.mybatis.spring.annotation.MapperScan;
import org.opensearch.client.RestClient;
import org.opensearch.client.RestHighLevelClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    // RestHighLevelClient 빈 등록
    @Bean
    public RestHighLevelClient restHighLevelClient() {
        return new RestHighLevelClient(
            RestClient.builder(
                new HttpHost("localhost", 9200, "http") // 실제 OpenSearch 서버 호스트, 포트, 프로토콜로 변경
            )
        );
    }

    // CORS 설정
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        System.out.println("WebMvcConfigurer.addCorsMappings");
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                    .allowedOrigins(
                        "http://project-popcon-react.s3-website.ap-northeast-2.amazonaws.com/*",
                        "https://projectpopcon.com/*",
                        "https://d2a7a3tzrwboc6.cloudfront.net/*",
                        "http://localhost:3000/*")
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                    .allowedHeaders("*")
                    .allowCredentials(true)
                    .maxAge(3600);
            }
        };
    }
}
