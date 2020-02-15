package com.Myex.base;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ComponentScan(basePackages = {
			"com.Myex.base.controllers",
			"com.Myex.base.models",
			"com.Myex.base.repositories",
			"com.Myex.base.services",
			"com.Myex.base.security"
			}
		)
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })//itt ez kikapcsolja a securityt amig nem csinalok sajatot
public class MyExperimentApplication {
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(MyExperimentApplication.class, args);
	}
}
