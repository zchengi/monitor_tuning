package com.cheng.monitor.tuning.chapter8;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 模拟栈
 *
 * @author cheng
 *         2018/12/21 21:55
 */
public class Stack {

    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private Object[] elements;
    private int size = 0;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        // 内存泄漏问题
//        return elements[--size];
        // 解决：
        Object ret = elements[size - 1];
        elements[size - 1] = null;
        size--;
        return ret;
    }

    /**
     * Ensure space for at least one more element, roughly doubling the capacity
     * each time the array needs to grow.
     */
    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
