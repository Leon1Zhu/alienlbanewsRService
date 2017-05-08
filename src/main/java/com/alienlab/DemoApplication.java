package com.alienlab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@EnableAsync
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
