package com.ray.employee.dao;

import com.ray.employee.model.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

/**
 * @Description
 * @Package: com.ray.demo.dao
 * @Author: Ray
 * @CreateTime: 2020/11/1 1:06
 * @E-mail: 634302021@qq.com
 */
public interface EmployeeDao extends ReactiveCrudRepository<Employee, Long> {
	
	Flux<Employee> findByName(String name);
	
}
