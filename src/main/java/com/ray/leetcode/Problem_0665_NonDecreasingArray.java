package com.ray.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.

We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).


Example 1:

Input: nums = [4,2,3]
Output: true
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
Example 2:

Input: nums = [4,2,1]
Output: false
Explanation: You can't get a non-decreasing array by modify at most one element.

Constraints:

n == nums.length
1 <= n <= 104
-105 <= nums[i] <= 105

*/
public class Problem_0665_NonDecreasingArray {

    public boolean checkPossibility(int[] nums) {

        if (nums == null) {
            return false;
        } else if (nums.length <= 2) {
            return true;
        } else {
            boolean flag = true;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums.length - 1; j++) {
                    if (j != i && nums[j] > nums[j+1]) {
                        System.out.println(nums[j] + "," + nums[j + 1]);
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Problem_0665_NonDecreasingArray solution = new Problem_0665_NonDecreasingArray();
        int[] nums = {1, 2, 3, 1, 4, 5, 2};
        int[] nums2 = {-1, 4, 2, 3};
        int[] nums3 = {3,4,2,3};
        System.out.println(solution.checkPossibility(nums2));
    }
}
