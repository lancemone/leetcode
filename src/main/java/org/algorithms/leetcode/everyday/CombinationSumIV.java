package org.algorithms.leetcode.everyday;

/**
 * @class: CombinationSumIV
 * @author: Lance Mone
 * @date: 2021/4/25 11:16
 * @description:
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 *
 * 题目数据保证答案符合 32 位整数范围。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3], target = 4
 * 输出：7
 * 解释：
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 *
 * 示例 2：
 * 输入：nums = [9], target = 3
 * 输出：0
 *
 * 提示：
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 1000
 * nums 中的所有元素 互不相同
 * 1 <= target <= 1000
 *
 * 如果给定的数组中含有负数，则会导致出现无限长度的排列。
 *
 * 例如，假设数组 nums 中含有正整数 aa 和负整数 -b−b（其中 a>0,b>0,-b<0a>0,b>0,−b<0），则有 a×b+(−b)×a=0，
 * 对于任意一个元素之和等于 target 的排列，在该排列的后面添加 b 个 a 和 a 个 −b 之后，得到的新排列的元素之和仍然等于 target，而
 * 且还可以在新排列的后面继续 b 个 a 和 aa 个 −b。因此只要存在元素之和等于 target 的排列，就能构造出无限长度的排列。
 *
 * 如果允许负数出现，则必须限制排列的最大长度，避免出现无限长度的排列，才能计算排列数。
 */

public class CombinationSumIV {

    // 简单递归
    static int combinationSum41(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int res = 0;
        for (int num : nums) {
            if (target >= num) {
                System.out.println(res);
                res += combinationSum41(nums, target-num);
            }
        }
        return res;
    }

    // 动态规划
    /**
     * 需要考虑选取元素的顺序，因此这道题需要计算的是选取元素的排列数。
     *
     * 复杂度分析
     * 时间复杂度：O(\textit{target} \times n)O(target×n)，其中 \textit{target}target 是目标值，nn 是数组 \textit{nums}nums 的长度。需要计算长度为 \textit{target}+1target+1 的数组 \textit{dp}dp 的每个元素的值，对于每个元素，需要遍历数组 \textit{nums}nums 之后计算元素值。
     *
     * 空间复杂度：O(\textit{target})O(target)。需要创建长度为 \textit{target}+1target+1 的数组 \textit{dp}dp。
     */
    static int combinationSum4(int[] nums, int target) {
        // dp[x] 表示选取的元素之和等于 x 的方案数，目标是求 dp[target]
        // dp[i]=dp[i-nums[0]]+dp[i-nums[1]]+dp[i=nums[2]]+...
        //举个例子比如nums=[1,3,4],target=7; dp[7]=dp[6]+dp[4]+dp[3]
        int[] dp = new int[target+1];
        // 动态规划的边界是 dp[0]=1。只有当不选取任何元素只有等于自己时，元素之和才为 0，因此只有 1 种方案
        dp[0] = 1;
        for (int i=1; i<=target; i++) {
            for (int num : nums) {
                if (num <=i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = new int[]{2,3,4};
        System.out.println(combinationSum4(nums, target));
    }
}
