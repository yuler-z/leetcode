package yuler.q974;

import com.yuler.q974.Solution;
import org.junit.Test;

/**
 * 题目链接：
 * 题目描述：
 * 解题思路：
 *
 * @Author: yuler
 * @Date: 2020/5/31 16:54
 */
public class SolutionTest {
    @Test
    public void Test(){
        int[] A = {4,5,0,-2,-3,1};
        int K = 5;
        Solution solution = new Solution();
        System.out.println(solution.subarraysDivByK(A, K));
    }
}
