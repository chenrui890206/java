package com.ray.employee.service;

import com.ray.employee.model.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @Description
 * @Package: com.ray.demo.service
 * @Author: Ray
 * @CreateTime: 2020/10/27 17:05
 * @E-mail: 634302021@qq.com
 */
public interface EmployeeService {
	
	/**
	 * 查找全部
	 * @return
	 */
	Flux<Employee> findAll();
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 */
	Mono<Employee> findById (long id);
	
	/**
	 * 根据名字查找
	 * @param name
	 * @return
	 */
	Flux<Employee> findByName (String name);
	
	/**
	 * 保存
	 * @param employee
	 * @return
	 */
	Mono<Employee> save (Employee employee);
	
	/**
	 * 更新
	 * @param employee
	 * @return
	 */
	Mono<Void> update (Employee employee);
	
	/**
	 * 删除
	 * @param employee
	 * @return
	 */
	Mono<Void> delete (Employee employee);
	
	/**
	 * 根据ID删除
	 * @param id
	 * @return
	 */
	Mono<Void> deleteById (long id);
	
}
