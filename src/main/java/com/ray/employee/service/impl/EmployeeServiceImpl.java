package com.ray.employee.service.impl;

import com.ray.employee.dao.EmployeeDao;
import com.ray.employee.model.Employee;
import com.ray.employee.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @Description
 * @Package: com.ray.demo.service.impl
 * @Author: Ray
 * @CreateTime: 2020/10/27 17:06
 * @E-mail: 634302021@qq.com
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	private final EmployeeDao employeeDao;
	
	/**
	 * 查找全部
	 *
	 * @return
	 */
	@Override
	public Flux<Employee> findAll() {
		return employeeDao.findAll();
	}
	
	/**
	 * 根据ID查找
	 *
	 * @param id
	 * @return
	 */
	@Override
	public Mono<Employee> findById(long id) {
		return employeeDao.findById(id);
	}
	
	/**
	 * 根据名字查找
	 *
	 * @param name
	 * @return
	 */
	@Override
	public Flux<Employee> findByName(String name) {
		return employeeDao.findByName(name);
	}
	
	/**
	 * 保存
	 *
	 * @param employee
	 * @return
	 */
	@Override
	public Mono<Employee> save(Employee employee) {
		return employeeDao.save(employee);
	}
	
	/**
	 * 更新
	 *
	 * @param employee
	 * @return
	 */
	@Override
	public Mono<Void> update(Employee employee) {
		return null;
	}
	
	/**
	 * 删除
	 *
	 * @param employee
	 * @return
	 */
	@Override
	public Mono<Void> delete(Employee employee) {
		return employeeDao.delete(employee);
	}
	
	/**
	 * 根据ID删除
	 *
	 * @param id
	 * @return
	 */
	@Override
	public Mono<Void> deleteById(long id) {
		return employeeDao.deleteById(id);
	}
}
