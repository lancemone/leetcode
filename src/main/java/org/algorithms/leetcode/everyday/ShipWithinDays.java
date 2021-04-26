package org.algorithms.leetcode.everyday;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @class: shipWithinDays
 * @author: Lance Mone
 * @date: 2021/4/26 14:08
 * @description: 在 D 天内送达包裹的能力
 * 示例 1：
 *
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 *
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 */

/**
 * 解题思路: 二分法
 * */
public class ShipWithinDays {

    static int shipWithinDays(int[] weights, int day) {
        if (weights.length == 0 || day > weights.length) {
            return 0;
        }
        int[] interval = new int[] {Arrays.stream(weights).max().getAsInt(), Arrays.stream(weights).sum()};
        while (interval[0] < interval[1]) {
            int midValue = (interval[0] + interval[1]) / 2;
            int weightPerDay = 0;
            int dayCount = 1;
            for (int weight : weights) {
                weightPerDay += weight;
                if (weightPerDay > midValue) {
                    dayCount ++;
                    // 需要在下次运送的重量
                    weightPerDay = weight;
                }
            }
            if (dayCount > day) {
                interval[0] = midValue + 1;
            }else {
                interval[1] = midValue;
            }
        }
        return interval[1];
    }

    public static void main(String[] args) {
        int[] weights = new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println(shipWithinDays(weights, 4));
    }
}
