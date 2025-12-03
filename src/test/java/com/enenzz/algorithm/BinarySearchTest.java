package com.enenzz.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {

    @Test
    @DisplayName("binarySearchBasic 找到")
    public void test1() {
        int[] a = {1, 2, 3, 4};
        Assertions.assertEquals(1,BinarySearch.binarySearchBasic(a, 2));
    }

    @Test
    @DisplayName("binarySearchLeftMost1")
    public void test2() {
        int[] a = {1, 2, 2, 3, 4};
        Assertions.assertEquals(1,BinarySearch.binarySearchLeftMost1(a, 2));
    }
}
