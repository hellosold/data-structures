/**
 * Feb 22 - Feb 26 Leet Code exercises
 * 3 easy problems
 * @author Li Liu
 */

public class week3 {

    /** 905. Sort Array By Parity
     * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by
     * all the odd elements of A.
     *
     * You may return any answer array that satisfies this condition.
     *
     * Example 1:
     * Input: [3,1,2,4]
     * Output: [2,4,3,1]
     * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
     *
     */

    // create an array to store the result, if current item is odd, add it to right of the array
    // if it is even, add it to left of the array
    public int[] sortArrayByParity(int[] A) {

        int[] temp = new int[A.length];

        int j = A.length - 1;
        int k = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                temp[k] = A[i];
                k++;
            } else {
                temp[j] = A[i];
                j--;
            }
        }
        return temp;
    }

    /** 977. Squares of a Sorted Array
     * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted
     * in non-decreasing order.
     *
     * Example 1:
     * Input: nums = [-4,-1,0,3,10]
     * Output: [0,1,9,16,100]
     * Explanation: After squaring, the array becomes [16,1,0,9,100].
     * After sorting, it becomes [0,1,9,16,100].
     *
     */
    public int[] sortedSquares(int[] nums) {
        // squared each items in orginal array
        for(int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        // Insertion sort the new array into older array
        for(int i = 1; i < nums.length; i++) {
            int temp = nums[i];

            int j = i - 1;
            while(j >= 0 && (temp < nums[j])) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = temp;
        }
        return nums;
    }

    /** 88. Merge Sorted Array
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
     *
     * The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has a
     * size equal to m + n such that it has enough space to hold additional elements from nums2.
     *
     * Example 1:
     * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * Output: [1,2,2,3,5,6]
     *
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
        }
        if (n == 0) {
            return;
        }

        int j = 0;
        //Copy nums2 to nums1
        for (int i = m; i < nums1.length; i++) {
            nums1[i] = nums2[j];
            j++;
        }

        // Insertion sort the new array into older array
        for (int i = 1; i < nums1.length; i++) {
            int temp = nums1[i];

            int k = i - 1;
            while(k >= 0 && (nums1[k] > temp)) {
                nums1[k + 1] = nums1[k];
                k--;
            }
            nums1[k + 1] = temp;
        }
    }
}
