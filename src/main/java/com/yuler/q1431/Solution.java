package com.yuler.q1431;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目链接：
 * 题目描述：
 * 解题思路：
 *
 * @Author: yuler
 * @Date: 2020/6/1 9:54
 */
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> res = new ArrayList<>();
        int max = Arrays.stream(candies).max().getAsInt();
        for (int i:candies) {
            res.add(i + extraCandies >= max);
        }
        return res;
    }
}