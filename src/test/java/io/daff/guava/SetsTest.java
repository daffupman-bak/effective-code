package io.daff.guava;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Sets工具类demo
 *
 * @author daffupman
 * @since 2020/2/1
 */
public class SetsTest {

    public static final Set<Integer> set1 = Sets.newHashSet(1, 2, 3);
    public static final Set<Integer> set2 = Sets.newHashSet(3, 4, 5);

    @Test
    public void testUnion() {
        // 取并集
        Sets.SetView<Integer> union = Sets.union(set1, set2);
        System.out.println(union);
    }

    @Test
    public void testIntersection() {
        // 取交集
        Sets.SetView<Integer> intersection = Sets.intersection(set1, set2);
        System.out.println(intersection);
    }

    @Test
    public void testDiff() {
        // 元素属于set1，但不属于set2
        Sets.SetView<Integer> difference1 = Sets.difference(set1, set2);
        System.out.println(difference1);
        // 元素属于set2,但不属于set1
        Sets.SetView<Integer> difference2 = Sets.difference(set2, set1);
        System.out.println(difference2);
        // 取出两个集合分别独立的元素
        Sets.SetView<Integer> difference3 = Sets.symmetricDifference(set1, set2);
        System.out.println(difference3);
    }

    @Test
    public void testPowerSet() {
        // 返回集合中元素的所有的组合
        Set<Set<Integer>> powerSet = Sets.powerSet(set1);
        powerSet.forEach(System.out::println);
    }

    @Test
    public void testCartesianProduct() {
        // 返回笛卡尔积
        Set<List<Integer>> product = Sets.cartesianProduct(set1, set2);
        product.forEach(System.out::println);
    }

    @Test
    public void testPartition() {
        ArrayList<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5);

        List<List<Integer>> partition = Lists.partition(list, 2);
        partition.forEach(System.out::println);
    }

    @Test
    public void testReverse() {
        LinkedList<Object> list = Lists.newLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(Lists.reverse(list));
    }

}
