package com.yuler.q84;

import java.util.ArrayDeque;
import java.util.Deque;

// 单调栈
public class Solution2 {

    public int largestRectangleArea(int[] heights) {

        Deque<Integer> stack = new ArrayDeque<>();

        int len = heights.length;
        int area = 0;
        int width;
        // 处理数组，直到数组尾部
        for (int i = 0; i < len ; i++) {
           while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i] ){
               int height = heights[stack.removeLast()];

               while (!stack.isEmpty() && heights[stack.peekLast()] == height){
                   stack.removeLast();
               }

               if (stack.isEmpty()){
                   width = i;
               }else {
                   width = i - stack.peekLast() - 1;
               }

               area = Math.max(area, width * height);
           }

        }

        while (!stack.isEmpty() ){
            int height = heights[stack.removeLast()];

            while (!stack.isEmpty() && heights[stack.peekLast()] == height){
                stack.removeLast();
            }

            if (stack.isEmpty()){
                width = len;
            }else {
                width = len - stack.peekLast() - 1;
            }

            area = Math.max(area, width * height);
        }
        return area;
    }
}
