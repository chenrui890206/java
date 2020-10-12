package com.ray.demo.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Package: com.ray.demo
 * @Author: Ray
 * @CreateTime: 2020/9/20 2:37
 * @E-mail: 634302021@qq.com
 */
@Controller
public class HelloAction {
	
	@RequestMapping("hello")
	@ResponseBody
	public String hello() {
		return "hello world";
	}
}
