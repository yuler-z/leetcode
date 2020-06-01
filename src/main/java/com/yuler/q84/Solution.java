package com.yuler.q84;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 题目链接：
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * 题目描述：
 *     84. 柱状图中最大的矩形
 * 解题思路：
 *
 *
 * @Author: yuler
 * @Date: 2020/5/30 18:36
 */
// 暴力解法
class Solution {
    public int largestRectangleArea(int[] heights) {
        int curHeight;
        int minHeight;
        int curArea = 0;
        int maxArea = 0;

        if (heights.length == 1) return heights[0];

        for (int i = 0; i < heights.length; i++) {
            curHeight = heights[i];
            if (i > 0 && curHeight <= heights[i-1]){
                continue;
            }

            minHeight = curHeight;
            for (int j = i; j < heights.length; j++) {
                if(heights[j] == 0) break;
                if(heights[j] < minHeight) minHeight = heights[j];
                curArea = (j - i + 1) * minHeight;
                if (curArea > maxArea) maxArea = curArea;
            }
        }
        return maxArea;
    }
}

class Solution3 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }

        int area = 0;
        int[] newHeights = new int[len + 2];
        for (int i = 0; i < len; i++) {
            newHeights[i + 1] = heights[i];
        }
        len += 2;
        heights = newHeights;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);

        for (int i = 1; i < len; i++) {
            while (heights[stack.peekLast()] > heights[i]) {
                int height = heights[stack.removeLast()];
                int width  = i - stack.peekLast() - 1;
                area = Math.max(area, width * height);
            }
            stack.addLast(i);
        }
        return area;
    }
}