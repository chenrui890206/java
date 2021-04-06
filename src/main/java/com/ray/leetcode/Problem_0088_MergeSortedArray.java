package com.ray.leetcode;

import java.util.Arrays;

/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has a size equal to m + n such that it has enough space to hold additional elements from nums2.

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]

Constraints:

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[i] <= 109

*/
public class Problem_0088_MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) {
            return;
        }
        int[] help = new int[m+n];
        int l = 0;
        int r = 0;
        int mid = m - 1;
        int right = n - 1;
        int i = 0;

        while (l <= mid && r <= right) {
            if (nums1[l] <= nums2[r]) {
                help[i++] = nums1[l++];
            } else {
                help[i++] = nums2[r++];
            }
        }
        while (l <= mid) {
            help[i++] = nums1[l++];
        }
        while (r <= right) {
            help[i++] = nums2[r++];
        }
        for (int j = 0; j < nums1.length; j++) {
            nums1[j] = help[j];
        }
    }

    public static void main(String[] args) {
        Problem_0088_MergeSortedArray solution = new Problem_0088_MergeSortedArray();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        solution.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
