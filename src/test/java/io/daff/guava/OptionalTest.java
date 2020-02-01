package io.daff.guava;

import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Optional类的demo
 *
 * @author daffupman
 * @since 2020/1/31
 */
public class OptionalTest {

    @Test
    public void test() {
        /*
        创建Optional对象的三种方式
         */

        // 创建空Optional对象
        Optional<Object> empty = Optional.empty();
        // 使用非null值创建Optional对象
        Optional<String> notNullOpl = Optional.of("hello");
        // 创建可null或非null（任意）0的Optional对象
        Optional<Object> nullOrNotOpl1 = Optional.ofNullable(null);
        Optional<String> nullOrNotOpl2 = Optional.ofNullable("hi");

        /*
        判断是否引用缺失的方法
         */
        // 不推荐使用
        empty.isPresent();

        /*
        Optional对象不为空，则执行lambda表达式
        与ifPresent方法类似的有：map、filter、flatMap
         */
        notNullOpl.ifPresent(System.out::println);

        /*
        当Optional引用缺失时执行
         */
        empty.orElse("引用缺失");
        empty.orElseGet(() -> {
            return "自定义引用缺失";
        });
//        notNullOpl.orElseThrow(() -> {
//            throw new RuntimeException("引用缺失异常");
//        });
    }

    @Test
    public void testStream() {
        stream(null);
    }

    private void stream(List<String> list) {
        Optional.ofNullable(list)
                .map(List::stream)
                .orElseGet(Stream::empty)
                .forEach(System.out::println);
    }
}
