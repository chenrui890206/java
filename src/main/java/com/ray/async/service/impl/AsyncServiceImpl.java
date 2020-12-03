package com.ray.async.service.impl;

import com.ray.async.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @Description
 * @Package: com.ray.async.service.impl
 * @Author: Ray
 * @CreateTime: 2020/12/4 1:01
 * @E-mail: 634302021@qq.com
 */
@Service
public class AsyncServiceImpl implements AsyncService {
	
	@Autowired
	private Async2ServiceImpl async2Service;
	
	@Override
	public String process() {
		String result = "";
		List<Future<String>> futures = new ArrayList<>();
		try {
		for (int i = 0; i < 10; i++) {
			Future<String> future = async2Service.processInner(i);
//			result += future.get();
			futures.add(future);
		}
		for (Future<String> future : futures) {
			String string = future.get();
			result += string;
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
}
