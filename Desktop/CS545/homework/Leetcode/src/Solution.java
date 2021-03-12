import java.util.Arrays;

/**
 * Feb 15 - Feb 19 Leet Code exercises
 * 3 easy problems
 * @author Li Liu
 */

public class Solution {

    /** 1122. Relative Sort Array
     * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
     *
     * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.
     * Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
     *
     * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
     * Output: [2,2,2,1,4,3,3,9,6,7,19]
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int temp;
        int count = 0;
        int len = arr1.length;
        int[] result = new int[len];
        int[] visited = new int[len];
        Arrays.sort(arr1);

        for (int i = 0; i < arr2.length; i++) {
            temp =  arr2[i];
            for (int j = 0; j < len; j++) {
                if (arr1[j] == temp) {
                    result[count] = temp;
                    visited[j] = 1;
                    count++;
                } else {
                    continue;
                }
            }
        }

        for (int i = 0; i < len; i++) {
            if (visited[i] == 0) {
                result[count] = arr1[i];
                count++;
            }
        }
        return result;
    }

    /**
     * 1491. Average Salary Excluding the Minimum and Maximum Salary
     * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
     * Return the average salary of employees excluding the minimum and maximum salary.
     *
     * Input: salary = [4000,3000,1000,2000]
     * Output: 2500.00000
     * Explanation: Minimum salary and maximum salary are 1000 and 4000 respectively.
     * Average salary excluding minimum and maximum salary is (2000+3000)/2= 2500
     *
     * @param salary
     * @return
     */
    public double average(int[] salary) {
        if (salary.length == 0) {
            return 0.0;
        }

        double mini = salary[0];
        double maxi = salary[0];
        double sum = 0;

        for (int i = 0; i < salary.length; i++) {
            sum += salary[i];
            if (salary[i] < mini) {
                mini = salary[i];
            }
            if (salary[i] > maxi) {
                maxi = salary[i];
            }
        }

        double aver = (sum - mini - maxi) / (salary.length - 2);
        return aver;

    }

    /** 976. Largest Perimeter Triangle
     *
     * Given an array A of positive lengths, return the largest perimeter of a triangle with non-zero area,
     * formed from 3 of these lengths.
     *
     * Example 1:
     * Input: [2,1,2]
     * Output: 5
     *
     * If it is impossible to form any triangle of non-zero area, return 0.
     * @param A
     * @return
     */
    public int largestPerimeter(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i] < (A[i - 1] + A[i - 2])) {
                return A[i] + A[i - 1] + A[i - 2];
            }
        }
        return 0;
    }

}
