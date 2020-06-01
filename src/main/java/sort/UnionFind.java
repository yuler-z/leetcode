package sort;

/**
 * 并查集
 * 通常用于处理连通图问题
 *
 * 主要函数：
 *  find(int x); 确定x属于哪一个子集
 *
 *  union(int x, int y); 将x, y合并成同一个集合
 *
 *
 * @Author: yuler
 * @Date: 2020/6/1 10:40
 */

public class UnionFind {
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
