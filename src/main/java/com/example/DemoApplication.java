package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	/*	@Bean
	public TomcatEmbeddedServletContainerFactory servletContainer(){
		TomcatEmbeddedServletContainerFactory container = new TomcatEmbeddedServletContainerFactory();
		container.setPort(8081);
//      container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,""));
		return container;
	}*/
}
