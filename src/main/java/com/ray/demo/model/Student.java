package com.ray.demo.model;

/**
 * @Description
 * @Package: com.ray.demo.model
 * @Author: Ray
 * @CreateTime: 2020/10/12 15:45
 * @E-mail: 634302021@qq.com
 */
public class Student {
	
	private String id;
	private String name;
	private int age;
	private Integer number;
	
	public Student(String id, String name, int age, Integer number) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.number = number;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public Integer getNumber() {
		return number;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}
}
