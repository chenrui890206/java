package com.ray.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an array A of strings made only from lowercase letters,
return a list of all characters that show up in all strings within the list (including duplicates).
For example, if a character occurs 3 times in all strings but not 4 times,
you need to include that character three times in the final answer.

You may return the answer in any order.

Example 1:

Input: ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: ["cool","lock","cook"]
Output: ["c","o"]

*/
public class Problem_1002_FindCommonCharacters {
	
	public List<String> commonChars(String[] A) {
		List<String> list = new ArrayList<>();
		if (A == null) {
			return list;
		}
		//		List<Map<Character,Integer>> total = new ArrayList<>();
		Map<Character,Integer> total = new HashMap<>();
		//		for (int i = 97; i <= 122; i++) {
		//			total.put((char) i, null);
		//		}
		for (int i = 0, aLength = A.length; i < aLength; i++) {
			String s = A[i];
			Map<Character,Integer> map = new HashMap<>();
			for (char c : s.toCharArray()) {
				map.put(c, map.getOrDefault(c, 0) + 1);
			}
			for (Map.Entry<Character,Integer> entry : map.entrySet()) {
				Character k = entry.getKey();
				Integer v = entry.getValue();
				
				if (i == 0) {
					total.put(k, v);
				}
				if (! total.containsKey(k)) {
					total.remove(k);
				} else if (v < total.get(k)) {
					total.put(k, v);
				}
			}
		}
		total.forEach((k, v) -> {
			if (v != - 1 && v != 101 && v >= 0) {
				while (v != 0) {
					list.add(String.valueOf(k));
					v--;
				}
			}
		});
		System.out.println(total);
		return list;
	}
	
	public static void main(String[] args) {
		String[] arr = {"bella", "label", "roller"};
		Problem_1002_FindCommonCharacters solution = new Problem_1002_FindCommonCharacters();
		System.out.println(solution.commonChars(arr));
		
		//		System.out.println((int)'z');
	}
}
