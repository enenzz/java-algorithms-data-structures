package com.enenzz.datastructure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
