package yuler.q146;

import com.yuler.q146.LRUCache;
import org.junit.Test;

/**
 * 题目链接：
 * 题目描述：
 * 解题思路：
 *
 * @Author: yuler
 * @Date: 2020/5/25 17:38
 */
public class LRUCacheTest {
    @Test
    public void Test(){
        LRUCache cache = new LRUCache(2);
        int i;
        cache.put(1, 1);
        cache.put(2, 2);
        i = cache.get(1);       // 返回  1
        System.out.println(i);
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        i = cache.get(2);       // 返回 -1 (未找到)
        System.out.println(i);
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        i = cache.get(1);       // 返回 -1 (未找到)
        System.out.println(i);
        i = cache.get(3);       // 返回  3
        System.out.println(i);
    }

}
