package io.daff.guava;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 不可变集合的demo
 *
 * @author daffupman
 * @since 2020/1/31
 */
public class ImmutableTest {

    @Test
    public void test() {

        /*
        不可变集合的三种创建方式
         */

        List<String> list = new ArrayList<String>() {{
                    add("a");
                    add("b");
                    add("c");
        }};

        // copyOf方法：集合对象已存在
        ImmutableSet<String> set1 = ImmutableSet.copyOf(list);
        // of方法：直接入参
        ImmutableSet<String> set2 = ImmutableSet.of("1", "2", "3");
        // Builder工具：以追加的方式生成集合
        ImmutableSet<Object> set3 = ImmutableSet.builder()
                .add(1)
                .addAll(Sets.newHashSet(2, 3))
                .add(4)
                .build();

    }
}
