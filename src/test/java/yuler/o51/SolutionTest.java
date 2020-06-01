package yuler.o51;

import com.yuler.o51.Solution;
import org.junit.Test;

import java.util.Arrays;

/**
 * 题目链接：
 * 题目描述：
 * 解题思路：
 *
 * @Author: yuler
 * @Date: 2020/5/23 23:27
 */
public class SolutionTest {

    @Test
    public void Test(){
        int nums[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums,k)));

    }
}
