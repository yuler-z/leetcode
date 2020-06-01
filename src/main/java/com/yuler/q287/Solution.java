package com.yuler.q287;

/**
 * 题目链接：
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 * 题目描述：
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 *
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 *
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 *
 * 解题思路：
 *
 *
 * @Author: yuler
 * @Date: 2020/5/26 21:31
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        quickSort(nums, 0, nums.length);
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i+1])
                return nums[i];
        }
        return 0;
    }

    void quickSort(int[] nums, int begin, int end){
        if(begin >= end - 1){
            return ;
        }
        int pos = partition(nums, begin, end);

        quickSort(nums, begin, pos);
        quickSort(nums, pos+1, end);

    }

    int partition(int[] nums, int begin, int end){
        int pivot = nums[begin];

        while (begin < end){
            while (begin < end && nums[--end] >= pivot) ;
            nums[begin] = nums[end];
            while (begin < end && nums[++begin] <= pivot);
            nums[end] = nums[begin];
        }
        nums[begin] = pivot;
        return begin;
    }
}
