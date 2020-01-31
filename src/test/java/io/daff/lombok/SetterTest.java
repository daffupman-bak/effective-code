package io.daff.lombok;

import com.sun.istack.internal.NotNull;
import lombok.AccessLevel;
import lombok.Setter;

/**
 * Setter注解demo
 *
 * @author daffupman
 * @since 2020/1/31
 */
public class SetterTest {

    private String field1;

    @Setter(
            value = AccessLevel.PRIVATE,
            onMethod_ = {@NotNull},
            onParam_ = {@NotNull}
    )
    private String field2;
}
