
package com.ray.demo.util;

import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;


/**
 * @class_name: MapUtil
 * @description:
 * @author: wm_yu
 * @create: 2019/08/03
 **/
public class MapUtil {
	
	
	
	private static final String HASH_MAP_NAME = "java.util.HashMap";
	
	private static final String HASH_MAP_NODE_NAME = "java.util.HashMap$Node";
	
	private static final String TABLE_NAME = "table";
	
	/**
	 *获取对象中所有的Map属性，通过反射取出所有的数据，在转换为一个目标对象
	 * @param o 传入的对象,仅对map处理
	 * @param clazz 需要生成的对象
	 * @param <T>
	 * @return
	 */
	public static<T> T getInstance(Object o,Class<T> clazz){
		Assert.notNull(o,"传入的对象不能为空");
		Assert.notNull(clazz,"需要生成的对象类型不能为null");
		//获取所有的字段
		Field[] targetFieldArr = o.getClass().getDeclaredFields();
//		Field[] targetFieldArr = FieldReflectUtil.getAllFields(o.getClass());
		//记录反射获取到的所有map数据
		IdentityHashMap<Object, Object> resultMap = new IdentityHashMap<>();
		List<Object> keyList = new ArrayList<>();
		List<Object> valueList = new ArrayList<>();
		//过滤属性
		Field[] fields = filterFieldArr(targetFieldArr);
		for (Field field : fields) {
			if(!field.isAccessible()){
				field.setAccessible(true);
			}
			try {
				Object var = field.get(o);
				if(var instanceof Map){
					Map<Object,Object> map = (Map) var;
					//获取到HashMap中的table字段(Field)
					Class<?> hashMapClass = Class.forName(HASH_MAP_NAME);
					
					//获取到hashMap中内部的node的字节码
					Class<?> hashMapNodeClass = Class.forName(HASH_MAP_NODE_NAME);
					
					Field tableField = null;
					
//					Field[] allFields = FieldReflectUtil.getAllFields(hashMapClass);
					Field[] allFields = hashMapClass.getDeclaredFields();
					
					for (Field var1 : allFields) {
						if(Optional.ofNullable(var1).isPresent() && var1.getName().equals(TABLE_NAME)){
							tableField = var1;
						}
					}
					//反射操作获取到Map中的数据
					if(Optional.ofNullable(tableField).isPresent()){
						if(!tableField.isAccessible()){
							tableField.setAccessible(true);
						}
						//获取hashmap中的transient Entry[] table
						Object[] nodeArr = (Object[]) tableField.get(map);
						Optional.ofNullable(nodeArr).ifPresent(arr -> {
							
							Arrays.stream(arr).filter(var3 -> Optional.ofNullable(var3).isPresent()).forEach(node -> {
								try {
									Field keyField = hashMapNodeClass.getDeclaredField("key");     //获取node类里面的key属性
									Field valueField = hashMapNodeClass.getDeclaredField("value");  //获取node类里面value属性
									Field nextField = hashMapNodeClass.getDeclaredField("next");   //获取node类里面next属性
									
									nextField.setAccessible(true);
									keyField.setAccessible(true);
									valueField.setAccessible(true);
									
									Optional.ofNullable(node).ifPresent(x -> {
										try {
											System.out.println("反射获取到的node节点数据:" + "-----key:" + keyField.get(node).toString() + "----value:" + valueField.get(node).toString());
											resultMap.put(keyField.get(node),valueField.get(node));
											keyList.add(keyField.get(node));
											valueList.add(valueField.get(node));
										} catch (IllegalAccessException e) {
											e.printStackTrace();
										}
									});
								} catch (Exception e) {
									e.printStackTrace();
								}
							});
							
						});
					}
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		resultMap.entrySet().stream().forEach(var -> {
			System.out.println("key:" + var.getKey() + "-----,value:" + var.getValue());
		});
		
		
		valueList.stream().forEach(x -> {
			System.out.println(x.toString());
		});
		return null;
	}
	/**
	 * 过滤字段数组
	 * @param arr
	 * @return
	 */
	public static Field[] filterFieldArr(Field[] arr){
		Assert.notNull(arr,"待处理数组不能为null");
		List<Field> list = Arrays.stream(arr).filter(x -> Optional.ofNullable(x).isPresent()
				&& !Modifier.isAbstract(x.getModifiers())
				&& !Modifier.isNative(x.getModifiers())
				&& !Modifier.isStatic(x.getModifiers())
				&& !Modifier.isFinal(x.getModifiers()))
				.collect(Collectors.toList());
		int length = CollectionUtils.isEmpty(list) ? 0:list.size();
		Field[] var = new Field[length];
		return list.toArray(var);
	}
	
	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>() {{
			for (int i = 0; i < 4; i++) {
				put(String.valueOf("aaa" + i), String.valueOf("aaa" + i));
				
			}
		}};
		
		Map<String, String> map1 = new HashMap<String, String>() {{
			for (int i = 10; i < 20; i++) {
				put(String.valueOf(i), String.valueOf(i));
			}
		}};
		AAAA aaaa = new AAAA();
		aaaa.setClassMap(map);
		aaaa.setNameMap(map);
		getInstance(aaaa,AAAA.class);
	}
}
