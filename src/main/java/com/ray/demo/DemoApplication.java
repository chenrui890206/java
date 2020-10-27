package com.ray.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}
	
	//	@Bean
	//	public RouterFunction<ServerResponse> helloWorld() {
	//		return route(GET("/hello-world"),
	//				request -> ok().body(Mono.just("hello,world"), String.class)
	//		);
	//
	//	}
	
	
	
}
