package com.ray.demo.util;

import com.ray.demo.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 匹配到的放前面
 * @Package: com.ray.demo.util
 * @Author: Ray
 * @CreateTime: 2020/10/12 15:22
 * @E-mail: 634302021@qq.com
 */
public class MatchFront {
	
	public static <T, V> Map<T,V> change(T t, List<V> list) {
		if (list == null || list.isEmpty()) {
			return null;
		}
		Map<T,V> map = new HashMap<>(list.size());
		V v = list.get(0);
		Class<?> clz = v.getClass();
		String clzName = clz.getName();
		String superClzName = "";
		
		if (clz.getSuperclass() != null) {
			superClzName = clz.getSuperclass().getName();
		}
		if (!"java.util.AbstractMap".equals(superClzName) && (superClzName.startsWith("java.util.") || superClzName.startsWith("java.Math."))) {
			throw new RuntimeException("该类不是Map子类或是");
		}
		if ("java.lang.Object".equals(superClzName)) {
		
		}
		System.out.println(superClzName);
//		switch () {
//			case :
//
//				break;
//			case :
//
//				break;
//			default:
//
//				break;
//		}
		
//		if ("java.util.HashMap".equals(clzName)) {
//			System.out.println("这是一个");
//		} else if () {
//
//		} else {
//
//		}
		
		return map;
	}
	
	public static void main(String[] args) {
		Student student1 = new Student("s1", "c1", 20, 1);
		Student student2 = new Student("s2", "c2", 21, 2);
		Student student3 = new Student("s3", "c3", 22, 3);
		List<Student> list = new ArrayList<>();
		list.add(student1);
		list.add(student2);
		list.add(student3);
		change("name", list);
		
//		Map<String,Object> map1 = new HashMap<>();
//		Map<String,Object> map2 = new HashMap<>();
//		Map<String,Object> map3 = new HashMap<>();
//		List<Map> list1 = new ArrayList<>();
//		list1.add(map1);
//		list1.add(map2);
//		list1.add(map3);
//		change("name", list1);
		
//		Object s1 = new Object();
//		Object s2 = new Object();
//		Object s3 = new Object();
//		List<Object> list2 = new ArrayList<>();
//		list2.add(s1);
//		list2.add(s2);
//		list2.add(s3);
//		change("name", list2);
		

//		List<String> list = new ArrayList<>();
//		list.add("a");
//		list.add("b");
//		list.add("c");
//		list.add("d");
//		list.add("e");
//		Map<String,String> map = new HashMap<>(0);
//		map.put("c", "c");
//		map.put("d", "d");
//		int left = 0;
//		int right = 0;
//		while (right < list.size()) {
//			if (map.containsKey(list.get(right))) {
//				Collections.swap(list, left, right);
//				left++;
//			}
//			right++;
//		}
//		System.out.println(list);
		
	}
}
