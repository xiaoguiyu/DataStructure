package com.xiaoyu.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoyu
 * @version 1.0
 * @date 2023/4/1 12:09
 * 零矩阵
 */

public class ZeroMatrix {
    /**
    编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
    示例 1：
    输入：
        [
            [1,1,1],
            [1,0,1],
            [1,1,1]
        ]
    输出：
        [
            [1,0,1],
            [0,0,0],
            [1,0,1]
        ]

    示例 2：
    输入：
        [
            [0,1,2,0],
            [3,4,5,2],
            [1,3,1,5]
        ]
    输出：
        [
            [0,0,0,0],
            [0,4,5,0],
            [0,3,1,0]
        ]
    Related Topics
    数组 哈希表 矩阵
     */
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5},
        };
        setZeroes(matrix);
    }


    /**
     * 思路: 分别使用两个 list来记录0 所处的位置(行和列)
     *      将list更换为 set,  可以去除重复, 效率更高
     * @param matrix  原矩阵
     */
    public static void setZeroes(int[][] matrix) {
        List<Integer> rowIndex = new ArrayList<>();
        List<Integer> columnIndex = new ArrayList<>();

        // 使用list来记录 0 所处的 行 和列
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] == 0) {
                   rowIndex.add(i);
                   columnIndex.add(j);
                }
            }
        }

        // 将有0位置的行 全部置为0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                for (Integer index : rowIndex) {
                    matrix[index][j] = 0;
                }
            }
        }

        // 将有0位置的列 重置为0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                for (Integer index : columnIndex) {
                    matrix[i][index] = 0;
                }
            }
        }

        // 输出结果
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }

}
