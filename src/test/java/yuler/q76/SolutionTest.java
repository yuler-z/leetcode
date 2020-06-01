package yuler.q76;

import com.yuler.q76.Solution;
import org.junit.Test;


public class SolutionTest {

    @Test
    public void test(){
        String s = "bba";
        String t = "ab";
        Solution solution = new Solution();
        System.out.println(solution.minWindow(s, t));

    }


}
