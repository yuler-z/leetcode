package com.yuler.q76;


/**
 * 题目链接：
 * https://leetcode-cn.com/problems/minimum-window-substring/solution/
 *
 * 题目描述：
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 * 实例：
 *     输入: S = "ADOBECODEBANC", T = "ABC"
 *     输出: "BANC"
 *
 * 解题思路：
 *  滑动窗口问题
 *  首先在s中找到能恰好覆盖t的子串，s[left,right]则为此时的滑动窗口
 *     左侧滑动，left++,剔除有效字符
 *     右侧华东，right++,加入有效字符
 *
 *  此处可以引入distance的概念，类似于编辑距离,主要逻辑如下：
 *  两个字符频数数组，滑动窗口windows 和 t中字符频数数组count
 *  当t[s[right]]!=0 && window[s[right]] < count[s[right]] 时， distance++;
 *  当t[s[left]]!=0 && window[s[left]] == count[s[left]] 时， distance--;
 *
 */

public class Solution {
    public String minWindow(String s, String t) {

        int left, right, distance;
        int begin, end, minLength;
        left = right = distance = 0;
        begin = end = 0;
        minLength = Integer.MAX_VALUE;

        int sLen, tLen;
        sLen = s.length();
        tLen = t.length();

        if(sLen == 0 || tLen == 0 || sLen < tLen) return "";

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        // 计算字符频数数组
        int[] window = new int[128];
        int[] count = new int[128];
        for (char c : tArray) {
            count[c] += 1;
        }

        // 开始滑动
        while (right < s.length()){
            // 右侧滑动
            if (count[sArray[right]] == 0) {
                right++;
                continue;
            }

            if (window[sArray[right]] < count[sArray[right]]) {
                distance++;
            }
            window[sArray[right]]++;
            right++;

            // 左侧滑动
            // 找到了子串就可以移动左侧
            while (distance == tLen) {
                // 记录最小子串
                if(right - left < minLength){
                    begin = left;
                    end = right;
                    minLength = right - left;
                }

                if (count[sArray[left]] == 0) {
                    left++;
                    continue;
                }

                if (window[sArray[left]] == count[sArray[left]]) {
                    distance--;
                }

                window[sArray[left]]--;
                left++;
            }
        }
        return minLength!=Integer.MAX_VALUE?s.substring(begin, end):"";
    }
}