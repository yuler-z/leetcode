package com.yuler.q974;

/**
 * 题目链接：
 * 题目描述：
 * 解题思路:
 *      前缀和: sum[i] = p[0] + p[1] + ... + p[i]
 *      如果(sum[j] - sum[i]) mod k, 那么sum[j] mod k = sum[i] mod k
 *      使用哈希表记录(sum[x] mod k) 出现的次数，进行排列组合从 N各种任选2个进行排列组合 Cn2
 *
 *
 * @Author: yuler
 * @Date: 2020/5/31 16:40
 */
public class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int[] map = new int[K];
        map[0] = 1;

        int sum = 0;
        int remainder;
        int count = 0;

        for (int i = 0; i < A.length; i++) {
           sum += A[i];
           remainder = (sum % K + K) % K;
           count += map[remainder];
           map[remainder]++;
        }
        return count;
    }
}