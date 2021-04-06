package com.ray.leetcode;

/*
Given an integer array nums and two integers lower and upper, return the number of range sums that lie in [lower, upper] inclusive.

Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j inclusive, where i <= j.


Example 1:

Input: nums = [-2,5,-1], lower = -2, upper = 2
Output: 3
Explanation: The three ranges are: [0,0], [2,2], and [0,2] and their respective sums are: -2, -1, 2.
Example 2:

Input: nums = [0], lower = 0, upper = 0
Output: 1

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
-3 * 104 <= lower <= upper <= 3 * 104

*/
public class Problem_0327_CountofRangeSum {

    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        return process(sums, 0, sums.length - 1, lower, upper);
    }

    public int process(int[] nums, int left, int right, int lower, int upper) {
        if (left == right) {
            return nums[left] >= lower && nums[right] <= upper ? 1 : 0;
        }
        int mid = left + (right - left) / 2;
        return process(nums, left, mid, lower, upper) + process(nums, mid + 1, right, lower, upper) + merge(nums, left, mid, right, lower, upper);
    }

    public int merge(int[] nums, int left, int mid, int right, int lower, int upper) {
        int result = 0;
        int windowL = left;
        int windowR = left;
        for (int i = mid + 1; i <= right; i++) {
            int min = nums[i] - upper;
            int max = nums[i] - lower;
            while (windowL <= mid && nums[windowL] < min) {
                windowL++;
            }
            while (windowR <= mid && nums[windowR] <= max) {
                windowR++;
            }
            result += (windowR - windowL);
        }
        int[] help = new int[right - left + 1];
        int l = left;
        int r = mid + 1;
        int index = 0;
        while (l <= mid && r <= right) {
            help[index++] = nums[l] <= nums[r] ? nums[l++] : nums[r++];
        }
        while (l <= mid) {
            help[index++] = nums[l++];
        }
        while (r <= right) {
            help[index++] = nums[r++];
        }
        for (int i = 0; i < help.length; i++) {
            nums[left + i] = help[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Problem_0327_CountofRangeSum solution = new Problem_0327_CountofRangeSum();
        int[] nums = {0, -1, -2, -3, 0, 2};
        System.out.println(solution.countRangeSum(nums, 3, 5));
    }
}
