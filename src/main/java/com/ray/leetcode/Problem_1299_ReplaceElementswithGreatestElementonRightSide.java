package com.ray.leetcode;

import java.util.Arrays;

/*
Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.

After doing so, return the array.

Example 1:

Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]
Explanation:
- index 0 --> the greatest element to the right of index 0 is index 1 (18).
- index 1 --> the greatest element to the right of index 1 is index 4 (6).
- index 2 --> the greatest element to the right of index 2 is index 4 (6).
- index 3 --> the greatest element to the right of index 3 is index 4 (6).
- index 4 --> the greatest element to the right of index 4 is index 5 (1).
- index 5 --> there are no elements to the right of index 5, so we put -1.
Example 2:

Input: arr = [400]
Output: [-1]
Explanation: There are no elements to the right of index 0.

Constraints:

1 <= arr.length <= 104
1 <= arr[i] <= 105

*/
public class Problem_1299_ReplaceElementswithGreatestElementonRightSide {

    public int[] replaceElements(int[] arr) {
        if (arr == null) {
            return null;
        }
        int tmp = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >=0; i--) {
            int xxx = arr[i];
            arr[i] = tmp;
            if (xxx > tmp) {
                tmp = xxx;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Problem_1299_ReplaceElementswithGreatestElementonRightSide solution = new Problem_1299_ReplaceElementswithGreatestElementonRightSide();
        int[] arr = {17, 18, 5, 4, 6, 1};
        int[] ints = solution.replaceElements(arr);
        System.out.println(Arrays.toString(ints));
    }
}
