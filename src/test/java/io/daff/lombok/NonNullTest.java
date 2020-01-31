package io.daff.lombok;

import lombok.NonNull;

/**
 * NonNull注解的demo
 *
 * @author daffupman
 * @since 2020/1/31
 */
public class NonNullTest {

    public NonNullTest(@NonNull String field) {
        System.out.println(field);
    }
}
