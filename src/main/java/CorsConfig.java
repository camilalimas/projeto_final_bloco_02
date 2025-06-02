

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
        
        // Allow specific origin for development
        config.addAllowedOrigin("http://localhost:3000");
        
        // Allow credentials
        config.setAllowCredentials(true);
        
        // Allow all common HTTP methods
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("OPTIONS");
        
        // Allow all headers
        config.addAllowedHeader("*");
        
        // Allow specific headers
        config.addExposedHeader("Authorization");
        config.addExposedHeader("Content-Type");
        
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}