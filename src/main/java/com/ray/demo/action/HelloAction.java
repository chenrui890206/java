package com.ray.demo.action;

import com.ray.demo.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @Description
 * @Package: com.ray.demo
 * @Author: Ray
 * @CreateTime: 2020/9/20 2:37
 * @E-mail: 634302021@qq.com
 */
@RestController
public class HelloAction {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloAction.class);
	
	@Autowired
	private HelloService helloService;
	
	@RequestMapping("hello")
	@ResponseBody
	public String hello() {
		return "hello world";
	}
	
	@Bean
	public RouterFunction<ServerResponse> predicateFunction() {
		return RouterFunctions.route()
				.GET("/v1/userinfo/predicate",
						request -> request.param("plan").isPresent(),
						request -> ServerResponse.ok().body("felord.cn"))
				.build();
	}
	
	
	
	// 普通的SpringMVC方法
	@GetMapping("/1")
	private String get1() {
		logger.info("get1 start");
		String result = helloService.getHello();
		logger.info("get1 end.");
		return result;
	}
	
	@GetMapping("/2")
	private Mono<String> get2() {
		logger.info("get2 start");
		Mono<String> result = Mono.fromSupplier(() -> helloService.getHello());
		logger.info("get2 end.");
		return result;
	}
}
