package com.xiaoyu.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author xiaoyu
 * @version 1.0
 * @date 2023/3/1 10:07
 */

public class Merge {
    /**
    以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
    回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。

     示例 1：
        输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
        输出：[[1,6],[8,10],[15,18]]
        解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

     示例 2：
        输入：intervals = [[1,4],[4,5]]
        输出：[[1,5]]
        解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。

     提示：
         1 <= intervals.length <= 10⁴
         intervals[i].length == 2
         0 <= starti <= endi <= 10⁴

     Related Topics 数组  排序 👍 1807 👎 0
     */
    public static void main(String[] args) {

        int[][] intervals =  {{1,3} ,{2,6}, {8,10}, {15,18}};

        int[][] mergeArray = merge(intervals);

        for (int[] ints : mergeArray) {
            for (int anInt : ints) {
                System.out.println(anInt);
            }
        }


    }

    public static int[][] merge(int[][] intervals) {

        // 先对数组进行排序
        Arrays.sort(intervals,new Comparator<int[]>() {
            @Override
            public int compare( int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] temp = list.get(list.size() - 1);  // temp用来保存list中合并完毕的数组(或不用合并的数组)
            // 对需要合并的区间进行判断
            if (temp[1] >= intervals[i][0]) {
                if (intervals[i][1] > temp[1]) {
                    temp[1] = intervals[i][1];
                }
            } else {
                list.add(intervals[i]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}