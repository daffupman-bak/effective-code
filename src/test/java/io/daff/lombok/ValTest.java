package io.daff.lombok;

import lombok.val;

import java.util.ArrayList;

/**
 * Val注解demo
 *
 * @author daffupman
 * @since 2020/1/31
 */
public class ValTest {

    public ValTest() {
        val field1 = "hello";
        val field2 = new ArrayList<String>();
        field2.add("java");
    }
}
