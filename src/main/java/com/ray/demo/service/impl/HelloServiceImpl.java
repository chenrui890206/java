package com.ray.demo.service.impl;

import com.ray.demo.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Package: com.ray.demo.service.impl
 * @Author: Ray
 * @CreateTime: 2020/10/27 17:06
 * @E-mail: 634302021@qq.com
 */
@Service
public class HelloServiceImpl implements HelloService {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);
	
	// 阻塞5秒钟
	private String createStr() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
		}
		return "some string";
	}
	
	@Override
	public String getHello() {
		createStr();
		logger.info("bbbbbbbbccccccccccccc");
		return "getHello()";
	}
}
