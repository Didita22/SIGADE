package cu.uci.isp5;

import java.util.Arrays;
import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class IsP5Application {

	public static void main(String[] args) {
		SpringApplication.run(IsP5Application.class, args);
	}
        @Bean
        public CorsFilter corsFilter(){
            final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            final CorsConfiguration config = new CorsConfiguration();
            config.setAllowedOrigins(Collections.singletonList("*"));
            config.setAllowedHeaders(Arrays.asList("Origin","Content-Type","Accept"));
            config.setAllowedMethods(Arrays.asList("GET","POST","PUT","OPTIONS","DELETE","PATCH"));
            source.registerCorsConfiguration("/**", config);
            System.out.println("log. "+source);
            return new CorsFilter(source);
        }
//        @Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:3000");
//			}
//		};
//	}
//@Configuration
//@EnableWebMvc
//public class WebConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**");
//    }
//}

}
