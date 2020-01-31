package io.daff.lombok;

import com.sun.istack.internal.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import org.junit.Test;

/**
 * Getter注解demo
 *
 * @author daffupman
 * @since 2020/1/31
 */
public class GetterTest {

    @Getter
    private String field1;

    // 指定访问级别
    @Getter(AccessLevel.PRIVATE)
    private String field2;

    // 指定访问级别和自动生成的方法上的注解
    @Getter(
            value = AccessLevel.PRIVATE,
            onMethod_ = {@NotNull}
    )
    private String field3;

    // 针对final修饰的变量，可指定是否启用懒加载
    @Getter(
            lazy = true
    )
    private final String field4 = "defaultValue";
}
