package com.ray.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
We have a list of points on the plane. Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)

Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)

Note:

1 <= K <= points.length <= 10000
-10000 < points[i][0] < 10000
-10000 < points[i][1] < 10000

*/
public class Problem_0973_KClosestPointstoOrigin {
	
	public int[][] kClosest(int[][] points, int K) {
		int[][] res = new int[K][];
		if (points == null) {
			return res;
		}
		PriorityQueue<Info> priorityQueue = new PriorityQueue<>((o1, o2) -> {
			if (o1.distance.equals(o2.distance)) {
				return 0;
			} else if (o1.distance < o2.distance) {
				return -1;
			} else {
				return 1;
			}
		});
		for (int[] point : points) {
			Info info = new Info(point, getDistance(point));
			priorityQueue.add(info);
		}
		for (int i = 0; i < K; i++) {
			res[i] = priorityQueue.poll().point;
		}
		return res;
		
//		Arrays.sort(points, new Comparator<int[]>() {
//			public int compare(int[] point1, int[] point2) {
//				return (point1[0] * point1[0] + point1[1] * point1[1]) - (point2[0] * point2[0] + point2[1] * point2[1]);
//			}
//		});
//		return Arrays.copyOfRange(points, 0, K);
	
	}
	
	
	
	public static class Info{
		public int[] point;
		public Double distance;
		
		public Info(int[] point, Double distance) {
			this.point = point;
			this.distance = distance;
		}
	}
	
	public static double getDistance(int[] point) {
		return Math.sqrt((Math.pow(point[0], 2) + Math.pow(point[1], 2)));
	}
	
	public static void main(String[] args) {
		Problem_0973_KClosestPointstoOrigin solution = new Problem_0973_KClosestPointstoOrigin();
		int[][] points = {{1, 3}, {-2,2}};
		System.out.println(Arrays.toString(solution.kClosest(points, 1)));
	}
}
