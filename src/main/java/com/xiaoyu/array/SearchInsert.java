package com.xiaoyu.array;

/**
 * @author xiaoyu
 * @version 1.0
 * @date 2023/2/28 22:31
 */

public class SearchInsert {
    public static void main(String[] args) {

    }
}



class Solution_35 {
    public int searchInsert(int[] nums, int target) {


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target  ) {
                return i;
            } /*else if (target > nums[nums.length -1] && i == nums.length -1) {
                    return i + 1;
            }*/
        }
        return nums.length;
    }
}

