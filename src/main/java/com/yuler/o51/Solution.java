package com.yuler.o51;

/**
 *
 * 题目链接：
 *  https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 *  https://leetcode-cn.com/problems/sliding-window-maximum/
 *
 * 题目描述：
 *  给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *  示例：
 *      输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 *  输出: [3,3,5,5,6,7]
 *  解释:
 *
 *     滑动窗口的位置                最大值
 *   ---------------               -----
 *   [1  3  -1] -3  5  3  6  7       3
 *    1 [3  -1  -3] 5  3  6  7       3
 *    1  3 [-1  -3  5] 3  6  7       5
 *    1  3  -1 [-3  5  3] 6  7       5
 *    1  3  -1  -3 [5  3  6] 7       6
 *    1  3  -1  -3  5 [3  6  7]      7
 * 解题思路：
 *    常规的滑动窗口问题。
 *
 * @Author: yuler
 * @Date: 2020/5/23 23:06
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       if(nums.length == 0) return new int[]{};

        int left, right;
        left = right = 0;

        int max = Integer.MIN_VALUE;
        int len = 0;

        int[] result = new int[nums.length - k + 1];

        while (right < nums.length){
            if(nums[right] > max){
                max = nums[right];
            }

            right++;
            len = right - left;
            if(len < k){
                continue;
            }else {
                result[left] = max;
                left++;
            }
        }
        return result;
    }
}

