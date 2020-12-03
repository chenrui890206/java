package com.ray.async.action;

import com.ray.async.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Package: com.ray.async.action
 * @Author: Ray
 * @CreateTime: 2020/12/4 0:58
 * @E-mail: 634302021@qq.com
 */
@Controller
public class AsyncAction {
	
	@Autowired
	public AsyncService asyncService;
	
	@ResponseBody
	@RequestMapping("test123")
	public String test() {
		return asyncService.process();
	}
}
