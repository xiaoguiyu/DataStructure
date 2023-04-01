package com.xiaoyu.array;

/**
 * @author xiaoyu
 * @version 1.0
 * @date 2023/2/28 22:31
 */

public class SearchInsert {


    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {

            // 若target 小于数组中遍历的值, 当前就为插入的位置
            if (nums[i] >= target  ) {
                return i;
            } /*else if (target > nums[nums.length -1] && i == nums.length -1) {
                    return i + 1;
            }*/
        }
        // 若数组的中的数都小于target, 说明插如的位置为数组的末尾, 也就是length
        return nums.length;
    }
}
