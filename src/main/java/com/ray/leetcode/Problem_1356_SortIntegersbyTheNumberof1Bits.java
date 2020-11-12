package com.ray.leetcode;

import java.util.*;

/**
 * @Description
 * @Package: com.ray.leetcode
 * @Author: Ray
 * @CreateTime: 2020/11/6 11:17
 * @E-mail: 634302021@qq.com
 */
public class Problem_1356_SortIntegersbyTheNumberof1Bits {
	
	public int[] sortByBits(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] tmp = new int[10000];
		List<Integer> list = new ArrayList<>();
		for (int i : arr) {
//			tmp[i] = Integer.bitCount(i);
			tmp[i] = hammingWeight(i);
			list.add(i);
		}
		list.sort(((o1, o2) -> {
			if (tmp[o1] == tmp[o2]) {
				return o1 - o2;
			} else {
				return tmp[o1] - tmp[o2];
			}
		}));
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}
	
	/**
	 * 二进制中有几个1
	 * @param n
	 * @return
	 */
	public int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			count += n & 1;
			n = n >>> 1;
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] arr = {1024,512,256,128,64,32,16,8,4,2,1};
		Problem_1356_SortIntegersbyTheNumberof1Bits solution = new Problem_1356_SortIntegersbyTheNumberof1Bits();
		System.out.println(Arrays.toString(solution.sortByBits(arr)));
	}
}
