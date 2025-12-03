package com.enenzz.algorithm;

/**
 * 二分查找
 */
public class BinarySearch {

    /**
     * 基础版
     * @param a 待查找数组
     * @param target 目标元素
     * @return
     */
    public static int binarySearchBasic(int []a, int target) {
        int i = 0;
        int j = a.length - 1;
        while (i <= j) {
            //int m = (i + j) / 2; 考虑到数值超过最大范围，而导致数值变为负数
            int m = (i + j) >>> 1;
            if (target < a[m]) { //目标在左边
                j = m - 1;
            } else if (target > a[m]) { //目标在右边
                i = m + 1;
            } else { //找到了
                return m;
            }
        }
        return -1;
    }

    /**
     * 平衡版  目标在左或在右的查找次数一样 缺点是必须等循环结束
     * @param a
     * @param target
     * @return
     */
    public static int binarySearch2 (int[] a, int target) {
        int i = 0;
        int j = a.length;
        while (1 < j - i) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m;
            } else {
                i = m;
            }
        }
        if (target == a[i]) {
            return i;
        }
        return -1;
    }

    /**
     * 若有想同元素 查找最左边那个
     * @param a
     * @param target
     * @return
     */
    public static int binarySearchLeftMost1(int []a, int target) {
        int i = 0;
        int j = a.length - 1;
        int candidate = -1;
        while (i <= j) {
            //int m = (i + j) / 2; 考虑到数值超过最大范围，而导致数值变为负数
            int m = (i + j) >>> 1;
            if (target < a[m]) { //目标在左边
                j = m - 1;
            } else if (target > a[m]) { //目标在右边
                i = m + 1;
            } else { //找到了
                candidate = m;
                j = m - 1;
            }
        }
        return candidate;
    }

    /**
     * 相同元素查找最左边的
     * @param a
     * @param target
     * @return 没找到返回比目标元素大的最左边元素的索引
     */
    public static int binarySearchLeftMost2(int []a, int target) {
        int i = 0;
        int j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target <= a[m]) { //目标在左边
                j = m - 1;
            } else { //目标在右边
                i = m + 1;
            }
        }
        return i;
    }
}
