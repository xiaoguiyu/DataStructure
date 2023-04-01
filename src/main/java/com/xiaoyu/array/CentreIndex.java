package com.xiaoyu.array;

/**
 * @author xiaoyu
 * @version 1.0
 * @date 2023/2/28 14:23
 * LetCode: 1991 题
 */



public class CentreIndex {
    /**
     * 给你一个整数数组 nums ，请计算数组的 中心下标 。
     *
     * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
     *
     * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
     *
     * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1
     */
    public static void main(String[] args) {


        int[] nums = {  2, 1, -1  };
        System.out.println(findMiddleIndex(nums));
    }

    public static int findMiddleIndex(int[] nums) {

        // 求出总和
        int sum = 0;
        for (int num : nums) {
            sum  += num;
        }

        int letSum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 数组左边的和
            letSum += nums[i];
            // 判断左边的和 是否等于右边的和
            if (letSum == sum - letSum + nums[i]) {
                return i;
            }
        }
        return -1;
    }

}







