package yuler.q101;

import com.yuler.q101.Solution;
import com.yuler.q101.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 题目链接：
 * 题目描述：
 * 解题思路：
 *
 * @Author: yuler
 * @Date: 2020/5/31 10:48
 */
public class SolutionTest {

    @Test
    public void Test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);

        Solution solution = new Solution();
        System.out.println(solution.isSymmetric(root));
    }

    @Test
    public void Test2(){
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(null);
        ArrayDeque<Object> objects = new ArrayDeque<>();
        objects.add(null);
    }
}
