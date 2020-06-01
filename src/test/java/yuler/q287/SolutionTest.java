package yuler.q287;

import com.yuler.q287.Solution;
import org.junit.Test;

/**
 * @Author: yuler
 * @Date: 2020/5/26 21:51
 */
public class SolutionTest {
    @Test
    public void Test(){
        int[] nums = new int[]{2,1,1};
        Solution solution = new Solution();
        System.out.println(solution.findDuplicate(nums));
    }
}
