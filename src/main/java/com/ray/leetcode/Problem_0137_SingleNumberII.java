package com.ray.leetcode;

/*
Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.


Example 1:

Input: nums = [2,2,3,2]
Output: 3
Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99

Constraints:

1 <= nums.length <= 3 * 104
-231 <= nums[i] <= 231 - 1
Each element in nums appears exactly three times except for one element which appears once.

Follow up: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

*/
public class Problem_0137_SingleNumberII {

    public int singleNumber(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int[] arr = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                arr[j] += (nums[i] >> j) & 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 3 == 0) {
                continue;
            } else {
                ans |= (1 << i);
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        Problem_0137_SingleNumberII solution = new Problem_0137_SingleNumberII();
        int[] arr = {3,3,3,2,2,2,5,5,5,0,0,0,2,2};
        solution.singleNumber(arr);
    }
}
