package org.algorithms.leetcode.everyday;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @class: LargestDivisibleSubset
 * @author: Lance Mone
 * @date: 2021/4/23 12:10
 * @description: 最大整除子集
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,2]
 * 解释：[1,3] 也会被视为正确答案。
 *
 * 示例 2：
 * 输入：nums = [1,2,4,8]
 * 输出：[1,2,4,8]
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 2 * 109
 * nums 中的所有整数 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-divisible-subset
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 复杂度分析
 *
 * 时间复杂度：O(n^2)其中 n 为输入数组的长度。对数组 nums 排序的时间复杂度为 O(nlogn)，计算数组 dp 元素的时间复杂度为 O(n^2)，
 * 倒序遍历得到一个目标子集，时间复杂度为 O(n)。
 *
 * 空间复杂度：O(n)，其中 n 为输入数组的长度。需要创建长度为 nn 的数组 dp。
 */

public class LargestDivisibleSubset {

    static void largestDivisibleSubset(int[] nums) {
        // 升序排列整数数组
        Arrays.sort(nums);
        int len = nums.length;
        List<Integer> res = new ArrayList<Integer>();

        // 第 1 步：动态规划找出最大子集的个数、最大子集中的最大整数
        // dp[i] 表示在输入数组 nums 升序排列的前提下,以 nums[i] 为最大整数的「整除子集」的大小（在这种定义下 nums[i] 必须被选择）
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int maxSize = 1;
        int maxVal = dp[0];
        // 枚举所有的 dp[i]，选出最大整除子集的大小 maxSize，以及该最大子集中的最大整数 maxVal
        for (int i=1; i < nums.length; i++) {
            for (int j=0; j<i; j++) {
                if (nums[i] % nums[j] == 0) {
                    // 整除的传递性
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    System.out.println("dp " + i + ": " + dp[i]);
                }
            }

            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxVal = nums[i];
            }
        }

        // 倒推获得最大子集
        if (maxSize == 1) {
            res.add(nums[0]);
        }else {
            // 倒序遍历数组 dp，直到找到 dp[i]=maxSize 为止，把此时对应的 nums[i] 加入结果集，此时 maxVal=nums[i]
            for (int i=len-1; i>=0 && maxSize>0; i--) {
                if (dp[i] == maxSize && maxVal % nums[i] == 0) {
                    res.add(nums[i]);
                    maxSize--;
                }
            }
        }
        Collections.sort(res);
        System.out.println("" + res);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,4,7,8,9,12,16,18};
        largestDivisibleSubset(nums);
    }
}
