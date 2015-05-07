package sc.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
 
/**
 * 
 *Spring components load
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "sc")
public class ShopCartConfig {
    
}

