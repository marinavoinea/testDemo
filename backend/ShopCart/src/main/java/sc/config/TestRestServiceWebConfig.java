package sc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * enable Spring config for Test container 
 * @author marina
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"sc"})
public class TestRestServiceWebConfig extends WebMvcConfigurerAdapter {

}
