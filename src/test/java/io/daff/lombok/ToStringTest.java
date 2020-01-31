package io.daff.lombok;

import lombok.ToString;

/**
 * ToString注解demo
 *
 * @author daffupman
 * @since 2020/1/31
 */
@ToString(
        includeFieldNames = false,
        exclude = {"field1"},
        of = {"field2"},
        doNotUseGetters = true
)
public class ToStringTest {

    private String field1;

    private String field2;

    private String field3;
}
