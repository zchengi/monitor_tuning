package com.cheng.monitor.tuning.chapter8;

/**
 * @author cheng
 *         2018/12/21 22:10
 */
public class SynchronizedTest {
    public static void main(String[] args) {

    }

    /**
     * 在 this 对象上加锁
     */
    public synchronized void f1() {
        System.out.println("f1");
    }

    public void f2() {
        // code
        synchronized (this) {
            System.out.println("f2");
        }
        // code
    }

    public static synchronized void f3() {
        System.out.println("f3");
    }

    public static void f4() {
        synchronized (SynchronizedTest.class) {
            System.out.println("f4");
        }
    }
}
