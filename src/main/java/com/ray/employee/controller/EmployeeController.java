package com.ray.employee.controller;

import com.ray.employee.model.Employee;
import com.ray.employee.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @Description
 * @Package: com.ray.demo
 * @Author: Ray
 * @CreateTime: 2020/9/20 2:37
 * @E-mail: 634302021@qq.com
 */
@RestController
@RequestMapping("employee")
public class EmployeeController {
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	private final EmployeeService employeeService;
	
	@GetMapping
	public Flux<Employee> findAll() {
		return employeeService.findAll();
	}
	
	@GetMapping (path = "{id}")
	public Mono<Employee> findById(@PathVariable("id") long id) {
		return employeeService.findById(id);
	}
	
//	@GetMapping ("find")
//	public Flux<Employee> findByName(@RequestParam("name") String name) {
//		return employeeService.findByName(name);
//	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Employee> save(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Mono<Void> update (@RequestBody Employee employee) {
		return employeeService.update(employee);
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Mono<Void> delete (@RequestBody Employee employee) {
		return employeeService.delete(employee);
	}
	
	@DeleteMapping(path = "{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Mono<Void> deleteById (@PathVariable long id) {
		return employeeService.deleteById(id);
	}
	
	
}
