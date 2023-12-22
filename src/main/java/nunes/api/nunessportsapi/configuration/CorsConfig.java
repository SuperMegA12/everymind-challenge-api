package nunes.api.nunessportsapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Allow requests from the Vue.js application's origin
        config.addAllowedOrigin("http://localhost:8081");

        // Allow common HTTP methods
        config.addAllowedMethod("*");

        // Allow common HTTP headers
        config.addAllowedHeader("*");

        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}

