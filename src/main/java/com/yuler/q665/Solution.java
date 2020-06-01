package com.yuler.q665;

/**
 * 题目链接：
 * 题目描述：
 * 解题思路：
 *
 * @Author: yuler
 * @Date: 2020/5/31 18:58
 */
class Solution {
    // 3,4,2,3 => 3,4,4,3
    // 3,4,2,4 => 3,4,4,4
    public boolean checkPossibility(int[] nums) {
        int index = 0;
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] > nums[i+1]){
                index ++;
                if (index == 2) return false;
                // 当前面两个数字都大于后面的数字时，需要进行转换
                if (i - 1 >= 0 && nums[i - 1] > nums[i+1]) nums[i+1] = nums[i];
            }
        }
        return true;

    }
}
