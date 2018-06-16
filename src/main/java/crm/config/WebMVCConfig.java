package crm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class WebMVCConfig implements WebMvcConfigurer{

	//Remplace web.xml
	
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	//	registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/view/js/");
		registry.addResourceHandler("/styles/**").addResourceLocations("/WEB-INF/ressources/css/");
	//registry.addResourceHandler("/*.html/**").addResourceLocations("/WEB-INF/ressources/html/");
	}
	 @Override
	   public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	       configurer.enable();
	   }
	
}
