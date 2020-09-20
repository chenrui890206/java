package com.ray.utils;

import javax.crypto.SecretKeyFactory;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Description
 * @Package: com.ray.utils
 * @Author: Ray
 * @CreateTime: 2020/9/20 17:56
 * @E-mail: 634302021@qq.com
 */
public class Sha256 {
	
	/**
	 * 利用java原生的类实现SHA256加密
	 *
	 * @param str 加密后的报文
	 * @return
	 */
	public static String getSHA256(String str) {
		MessageDigest messageDigest;
		String encodestr = "";
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
			encodestr = byte2Hex(messageDigest.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return encodestr;
	}
	
	/**
	 * 将byte转为16进制
	 *
	 * @param bytes
	 * @return
	 */
	private static String byte2Hex(byte[] bytes) {
		StringBuffer stringBuffer = new StringBuffer();
		String temp = null;
		for (int i = 0; i < bytes.length; i++) {
			temp = Integer.toHexString(bytes[i] & 0xFF);
			if (temp.length() == 1) {
				// 1得到一位的进行补0操作
				stringBuffer.append("0");
			}
			stringBuffer.append(temp);
		}
		return stringBuffer.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(getSHA256("1"));
		SecretKeyFactory keyFactory = null;
		
	}
	
}
