package com.ray.async.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @Description
 * @Package: com.ray.async.service.impl
 * @Author: Ray
 * @CreateTime: 2020/12/4 1:14
 * @E-mail: 634302021@qq.com
 */
@Service
public class Async2ServiceImpl {
	
	@Async
	public Future<String> processInner(int i) {
		try {
			System.out.println(Thread.currentThread().getName()+"-----开始休眠");
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName()+"-----休眠完毕");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new AsyncResult<>(Thread.currentThread().getName()+"-----收到的是：" + i+"\r\n");
	}
	
}
