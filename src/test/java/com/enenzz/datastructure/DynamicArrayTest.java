package com.enenzz.datastructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 动态数组
 */
public class DynamicArrayTest {

    @Test
    @DisplayName("利用函数接口遍历")
    public void test1() {
        DynamicArray arr = new DynamicArray();
        arr.addLast(1);
        arr.addLast(2);
        arr.addLast(3);
        arr.addLast(4);
        arr.myForEach((val -> System.out.println(val)));
    }

    @Test
    @DisplayName("利用迭代器遍历")
    public void test2() {
        DynamicArray arr = new DynamicArray();
        arr.addLast(1);
        arr.addLast(2);
        arr.addLast(3);
        arr.addLast(4);
        for (Integer i: arr) {
            System.out.println(i);
        }
    }

    @Test
    @DisplayName("将数组转换为流遍历")
    public void test3() {
        DynamicArray arr = new DynamicArray();
        arr.addLast(1);
        arr.addLast(2);
        arr.addLast(3);
        arr.addLast(4);
        arr.intStream().forEach(value -> System.out.println(value));
    }

    @Test
    @DisplayName("删除元素")
    public void test4() {
        DynamicArray arr = new DynamicArray();
        arr.addLast(1);
        arr.addLast(2);
        arr.addLast(3);
        arr.addLast(4);
        for (Integer i: arr) {
            System.out.println(i);
        }
        Assertions.assertEquals(2, arr.remove(1));
        //比较集合内元素是否相等
        Assertions.assertIterableEquals(List.of(1, 3, 4), arr);
    }

    @Test
    @DisplayName("测试数组容量")
    public void test5() {
        DynamicArray arr = new DynamicArray();
        arr.addLast(1);
        arr.addLast(2);
        arr.addLast(3);
        arr.addLast(4);
        arr.addLast(1);
        arr.addLast(2);
        arr.addLast(3);
        arr.addLast(4);
        arr.addLast(4);
        arr.intStream().forEach(value -> System.out.println(value));
    }
}
