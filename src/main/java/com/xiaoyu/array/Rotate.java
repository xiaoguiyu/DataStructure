package com.xiaoyu.array;

/**
 * @author xiaoyu
 * @version 1.0
 * @date 2023/3/31 10:52
 * leetcode 48题
 */

public class Rotate {
    /**
     注意：本题与主站 48 题相同：https://leetcode-cn.com/problems/rotate-image/

     给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
     不占用额外内存空间能否做到？

     示例 1:
     给定 matrix =
     [
         [1,2,3],
         [4,5,6],
         [7,8,9]
     ],

     原地旋转输入矩阵，使其变为:
     [
         [7,4,1],
         [8,5,2],
         [9,6,3]
     ]

     示例 2:  给定 matrix =
     [
         [ 5, 1, 9,11],
         [ 2, 4, 8,10],
         [13, 3, 6, 7],
         [15,14,12,16]
     ],

     原地旋转输入矩阵，使其变为:
     [
         [15,13, 2,  5],
         [14, 3, 4,  1],
         [12, 6, 8,  9],
         [16, 7, 10, 11]
     ]
     */
    public static void main(String[] args) {

        int[][] matrix = {
                {5, 1, 9,11},
                {2, 4, 8,10},
                {13, 3, 6, 7},
                {15,14,12,16}
        };

        rotate(matrix);
    }

    /**
     * 思路:
     * 1. 中心点上下旋转
     * 2. 对角进行旋转
     */
    public static void rotate(int[][] matrix) {

        int length =  matrix.length;
        int temp;


        // 1. 上下翻转
        for (int i = 0; i < length; i++) {
            for (int j = 0 ; j < length; j++) {

                // 循环到当前行的中间元素时, 交换完成
                if (i > (length - 1) / 2)
                    break;

                temp = matrix[i][j];
                matrix[i][j] = matrix[length - i - 1][j];
                matrix[length - i - 1][j] = temp;
            }
        }

        // 2. 对角线(右下 - 左上)进行翻转
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {  // 只交换对角线的右上部分

                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 输出结果
        for (int[] ints : matrix) {
            for (int e : ints) {
                System.out.print(e + "\t");
            }
            System.out.println();
        }

    }

}


/*
    error


    temp = matrix[i][j];
    matrix[i][j] = matrix[matrix.length - 1 - j][matrix.length - 1 - i];
    matrix[matrix.length - 1 - j][matrix.length - 1 - i] = temp;



        // 2. 以中心y(左右)轴进行翻转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i ; j < matrix[i].length; j++) {

                // 循环到当前行的中间元素时, 交换完成
                if (j > (matrix[i].length - 1) / 2)
                    break;

                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length - 1 - j];
                matrix[i][matrix[i].length - 1 - j] = temp;
            }
        }

 */



