package com.ray.leetcode;

/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?

Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1

Constraints:

1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.

*/
public class Problem_0136_SingleNumber {

    public int singleNumber(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int x = 0;
        for (int num : nums) {
            x ^= num;
        }
        return x;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 3, 4};
        Problem_0136_SingleNumber solution = new Problem_0136_SingleNumber();
        System.out.println(solution.singleNumber(arr));
    }
}
