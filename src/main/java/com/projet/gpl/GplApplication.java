package com.projet.gpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author ProSYS
 */
@SpringBootApplication
public class GplApplication extends SpringBootServletInitializer{


        public static void main(String[] args) {
            SpringApplication.run(GplApplication.class, args);
	}
        
        
        // pour ajouter /context ==> /Clinique
        @Bean
        public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>
          webServerFactoryCustomizer() {
            return factory -> factory.setContextPath("/Gpl");
        }
          
       @Override
        protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
            return application.sources(GplApplication.class);
        }
        
     
}

