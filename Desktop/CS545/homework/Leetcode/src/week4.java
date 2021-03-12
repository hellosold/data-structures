/**
 * Feb 29 - Mar 26 Leet Code exercises
 * 3 easy problems
 * @author Li Liu
 */

public class week4 {
    /** 35. Search Insert Position
     * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not,
     * return the index where it would be if it were inserted in order.
     *
     * Example 1:
     * Input: nums = [1,3,5,6], target = 5
     * Output: 2
     */

    public int searchInsert(int[] nums, int target) {
        int j = 0;
        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            } else {
                if (nums[i] < target) {
                    j++;
                }
            }
        }
        return j;
    }


}
