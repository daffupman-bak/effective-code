package io.daff.guava;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Chars;
import org.junit.Test;

/**
 * @author daffupman
 * @since 2020/2/1
 */
public class MultisetTest {

    public static final String text =
            "智慧树上智慧果；" +
            "智慧树下你和我；" +
            "智慧树前做游戏；" +
            "欢乐多又多。";

    @Test
    public void handle() {
        // 创建Multiset
        Multiset<Character> multiset = HashMultiset.create();
        // 转换成char数组
        char[] chars = text.toCharArray();
        // 将数组添加到multiset中
        multiset.addAll(Chars.asList(chars));
        System.out.println("size: " + multiset.size());
        System.out.println("count: " + multiset.count('多'));
    }
}
