package com.ray.employee.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

/**
 * @Description
 * @Package: com.ray.demo.model
 * @Author: Ray
 * @CreateTime: 2020/10/12 15:45
 * @E-mail: 634302021@qq.com
 */

@Table("employee")
public class Employee implements Serializable {
	
	@Id
	private long id;
	private String name;
	private long age;
	private long salary;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public long getAge() {
		return age;
	}
	
	public void setAge(long age) {
		this.age = age;
	}
	
	public long getSalary() {
		return salary;
	}
	
	public void setSalary(long salary) {
		this.salary = salary;
	}
}
