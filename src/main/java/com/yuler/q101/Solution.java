package com.yuler.q101;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check1(root, root);
    }
    // 递归
    boolean check1(TreeNode l, TreeNode r){
        if (l == null && r == null) return true;
        if (l == null || r == null) return false;

        return l.val == r.val && check1(l.left, r.right) && check1(l.right, r.left);
    }

    //迭代
    boolean check2(TreeNode l, TreeNode r){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(l);
        queue.offer(r);
        while (queue.isEmpty()){
            l = queue.poll();
            r = queue.poll();
            if (l == null && r == null) continue;
            if (l == null || r == null) return false;
            if (l.val != r.val) return false;

            queue.offer(l.left);
            queue.offer(r.right);

            queue.offer(l.right);
            queue.offer(r.left);
        }

        return true;
    }
}
