package com.ray.leetcode;

import java.util.Arrays;

/*
Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Clarification:

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by reference, which means a modification to the input array will be known to the caller as well.

Internally you can think of this:

// nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
   print(nums[i]);
}

Example 1:

Input: nums = [1,1,2]
Output: 2, nums = [1,2]
Explanation: Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the returned length.
Example 2:

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4]
Explanation: Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively. It doesn't matter what values are set beyond the returned length.

Constraints:

0 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
nums is sorted in ascending order.

*/
public class Problem_0026_RemoveDuplicatesfromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return 1;
        }
        int p1 = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[p1] != nums[i]) {
                p1++;
                nums[p1] = nums[i];
            }
        }
        return p1 + 1;
    }



    public static void main(String[] args) {
        Problem_0026_RemoveDuplicatesfromSortedArray solution = new Problem_0026_RemoveDuplicatesfromSortedArray();
        int[] arr = {1, 2, 2, 2, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 7};
        int i = solution.removeDuplicates(arr);
        System.out.println(i);
        System.out.println(Arrays.toString(arr));
    }
}
