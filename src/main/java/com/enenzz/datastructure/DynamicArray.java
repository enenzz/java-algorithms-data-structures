package com.enenzz.datastructure;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * 动态数组
 */
public class DynamicArray implements Iterable<Integer> {
    private int size = 0; //逻辑大小
    private int capacity = 8; //数值大小
    private int[] arr = {};

    /**
     * 向数据尾部新增一个数据
     * @param val
     */
    public void addLast(int val) {
        insert(size, val);
    }

    /**
     * 向指定索引插入数据
     * 数据不能被覆盖而且需连起来
     * @param i
     * @param val
     */
    public void insert(int i, int val) {
        //数组容量检测和扩容
        checkAndGrow();

        //插入元素
        if (0 <= i && i < size) { //注意i=size时不用拷贝数组
            //将插入位之后的元素后移
            System.arraycopy(arr, i, arr, i+1, size-i);
        } else if (i < 0 || size < i){
            throw new RuntimeException("索引越界~");
        }
        arr[i] = val;
        size++;
    }

    /**
     * 数组容量检测和扩容
     */
    public void checkAndGrow() {
        if (size == 0) {
            //若数组为空
            arr = new int[capacity];
        } else if (size == capacity) {
            //将数组大小扩容为原来的1.5倍
            capacity += capacity >> 1;
            int[] newArr = new int[capacity];
            System.arraycopy(arr, 0 , newArr ,0, size);
            arr = newArr;
        }
    }

    /**
     * 删除指定的元素
     * @param i
     * @return 删除的元素
     */
    public int remove(int i) {
        int removed = arr[i];
        if (i < size-1)
            System.arraycopy(arr, i+1, arr, i, size-i-1);
        size--;
        return removed;
    }

    /**
     * 根据索引查询元素
     * @param i
     * @return
     */
    public int get(int i) {
        return arr[i];
    }

    /**
     * 遍历方式1
     * 利用函数式接口来遍历数组
     * @param consumer
     */
    public void myForEach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(arr[i]);
        }
    }

    /**
     * 遍历方式2
     * 利用迭代器来遍历
     * 使用增强for必须实现迭代器接口
     * @return
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;
            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public Integer next() {
                return arr[i++];
            }
        };
    }

    /**
     * 遍历方式3
     * 将数组转换为流
     * @return
     */
    public IntStream intStream() {
        return IntStream.of(Arrays.copyOfRange(arr, 0, size));
    }
}
