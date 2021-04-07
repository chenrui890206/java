package com.ray.leetcode;

/*
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.


Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1


Constraints:

1 <= nums.length <= 104
-9999 <= nums[i], target <= 9999
All the integers in nums are unique.
nums is sorted in an ascending order.

*/
public class Problem_0704_BinarySearch {

    public int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Problem_0704_BinarySearch solution = new Problem_0704_BinarySearch();
        int[] arr = {1, 3, 5, 6, 7, 7, 8, 9};
        System.out.println(solution.search(arr, 6));
    }
}
