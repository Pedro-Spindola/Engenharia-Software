package com.spindola.atividade_02_pp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Atividade02PpApplication {

	public static void main(String[] args) {
		SpringApplication.run(Atividade02PpApplication.class, args);

        // Roteador roteador = new Roteador("X5000", "NetMaker", antenaHuawei, chipsetQualcomm, fonteCorsair, placaIntel);

        //roteador.listarComponentes();
        //roteador.ligarRoteador();
	}

	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200") // Angular
                        .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                        .allowedHeaders("*");
            }
        };
    }

}
