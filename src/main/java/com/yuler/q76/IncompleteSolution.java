package com.yuler.q76;

import java.util.HashMap;
import java.util.Map;

class IncompleteSolution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        int nextLeft;
        int minLeft, minRight;
        int minLength;
        int left, right;
        int len, num;
        int charNum;

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (Character c: t.toCharArray()) {
            if(map.containsKey(c)){
               map.put(c, map.get(c)+1);
            }else {
                map.put(c, 1);
            }
        }
        charNum = t.length();
        nextLeft = minLeft = minRight = -1;
        minLength = Integer.MAX_VALUE;
        left  = 0;

        // 1.先找到第一次开始的地方
        for (int i = 0; i <= s.length() - charNum; i++) {
           if(map.containsKey(s.charAt(i))) {
               nextLeft = i;
               break;
           }
        }
        if(nextLeft == -1) return "";
        if(charNum == 1) return s.substring(nextLeft,nextLeft+1);

        Map<Character, Integer> back = new HashMap<>(map);

        while(nextLeft <= s.length() - charNum){
            map.putAll(back);
            map.put(s.charAt(nextLeft), map.get(s.charAt(nextLeft)) - 1);
            num = len = 1;
            for (right = nextLeft + 1,left = nextLeft, nextLeft= s.length(); right < s.length(); right++) {
                if(map.containsKey(s.charAt(right))){
                    if(map.containsKey(s.charAt(right))){
                        len++;
                        if(len == 2){
                            nextLeft = right;
                        }
                        if(map.get(s.charAt(right)) != 0){
                            num++;
                            map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                        }

                        if(num == charNum){
                            if(right - left< minLength) {
                                minLeft = left;
                                minRight = right;
                                minLength = minRight - minLeft;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return minRight == -1?"":s.substring(minLeft, minRight+1);
    }
}