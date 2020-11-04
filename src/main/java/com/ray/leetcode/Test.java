package com.ray.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description
 * @Package: com.ray.leetcode
 * @Author: Ray
 * @CreateTime: 2020/10/13 9:50
 * @E-mail: 634302021@qq.com
 */
public class Test {
	
	public static int[][] insert(int[][] intervals, int[] newInterval) {
		if (intervals == null || newInterval == null) {
			return null;
		}
		if (newInterval[1] <= intervals[0][0] || newInterval[0] >= intervals[intervals.length - 1][1]) {
			return intervals;
		}
		List<List<Integer>> lists = new ArrayList<>();
		for (int i = 0; i < intervals.length; i++) {
			List<Integer> obj = new ArrayList<>();
			int left_val = intervals[i][0];
			int right_val = intervals[i][1];
			if (left_val <= newInterval[0] && newInterval[0] <= right_val) {
				left_val = intervals[i][0];
			} else if (newInterval[0] < left_val) {
				left_val = newInterval[0];
			}
			
			
			obj.add(left_val);
			obj.add(right_val);
			lists.add(obj);
			
		}
		Iterator<List<Integer>> iterator = lists.iterator();
		while (iterator.hasNext()) {
			List<Integer> next = iterator.next();
			int left_val = next.get(0);
			int right_val = next.get(1);
			if (newInterval[0] > right_val) {
				continue;
			}
			if (newInterval[1] < left_val) {
				continue;
			}
			if (newInterval[1] > right_val) {
				iterator.remove();
			}/* else if (newInterval[1] >= left_val && newInterval[1] <= right_val) {
				right_val = newInterval[1];
			} else {
			
			}*/
			
		}
		System.out.println(lists);
		
		return null;
	}
	
	public static void main(String[] args) {
		int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
		int[] newInterval = {4, 8};
		System.out.println(insert(intervals, newInterval));
	}
}
