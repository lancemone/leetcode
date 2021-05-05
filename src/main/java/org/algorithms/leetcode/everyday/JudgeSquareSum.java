package org.algorithms.leetcode.everyday;

/**
 * @class: JudgeSquareSum
 * @author: Lance Mone
 * @date: 2021/4/28 14:33
 * @description: 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a^2 + b^2 = c
 */

public class JudgeSquareSum{

    public static boolean judgeSquareSum(int c) {
        int start = 0;
        int end = (int)Math.sqrt(c);
        while (start <= end) {
            if (start*start + end*end < c) {
                start++;
            }else if (start*start + end*end > c){
                end--;
            }else {
                System.out.println(String.format("a和b分别为：%d, %d", start, end));
                return true;
            }
        }
        return false;
    }

//    int myselfSqrt(int s) {
//
//    }
}
