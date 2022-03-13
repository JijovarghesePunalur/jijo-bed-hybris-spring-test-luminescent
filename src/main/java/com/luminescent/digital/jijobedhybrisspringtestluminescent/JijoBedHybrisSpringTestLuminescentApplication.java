package com.luminescent.digital.jijobedhybrisspringtestluminescent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan(basePackages = "com.luminescent.digital.jijobedhybrisspringtestluminescent")
public class JijoBedHybrisSpringTestLuminescentApplication {

	public static void main(String[] args) {
		SpringApplication.run(JijoBedHybrisSpringTestLuminescentApplication.class, args);
	}

}
