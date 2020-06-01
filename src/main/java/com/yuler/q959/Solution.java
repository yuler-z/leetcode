package com.yuler.q959;

/**
 * 题目链接：
 * 题目描述：
 * 解题思路：
 *    并查集                                         0
 *    将每个1X1的正方形看作4个小三角形 标号分别为    3    1
 *                                                   2
 *    1. 正方形内三角形进行union:
 *         当字符不为'\\'时， 分别将(0,3) (1,2)进行union
 *         当字符不为'/'时，分别将(0,1) (2,3)进行union
 *    2. 正方形间三角形进行union:
 *          当前正方形不在第一行，将当前正方形的0与上一行的2进行union
 *          当前正方形不在最后一行， 将当前正方形的2与下一行的0进行union
 *          同理
 *          当前正方形不在第一列，将当前正方形的3与上一列的1进行union
 *          当前正方形不在最后一列，将当前正方形的1与上一列的3进行union
 * @Author: yuler
 * @Date: 2020/6/1 11:45
 */
public class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        UnionFind uf = new UnionFind(4 * n * n);

        for (int i = 0; i < n; i++) {
            String str = grid[i];
            for (int j = 0; j < n; j++) {
                int root = 4 * (i * n + j);
                char c = str.charAt(j);
                if (c != '\\'){
                    uf.union(root, root + 3);
                    uf.union(root + 1, root + 2);
                }

                if (c != '/'){
                    uf.union(root, root + 1 );
                    uf.union(root + 2, root + 3);
                }

                // 不在第一行
                if (i > 0){
                    uf.union(root, root - 4 * n + 2);
                }

                // 不在最后一行
                if (i < n-1){
                    uf.union(root + 2, root + 4 * n);
                }

                // 不在第一列
                if (j > 0){
                    uf.union(root + 3, root - 4 + 1);
                }

                // 不在最后一列
                if (j < n-1){
                    uf.union(root + 1, root + 4 + 3);
                }
            }
        }
        
        int res = 0;
        for (int i = 0; i < 4 * n * n; i++) {
            if (uf.find(i) == i){
                res++;
            }
        }
        return res;

    }
}

class UnionFind {
    int[] parent;

    public UnionFind(int n){
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    public int find(int x){
        if (parent[x] != x)
            parent[x] = find(parent[x]);

        return parent[x];
    }

    public void union(int x, int y){
        x = find(x);
        y = find(y);
        if (x != y)
            parent[x] = y;
    }

}