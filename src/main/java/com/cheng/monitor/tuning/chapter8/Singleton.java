package com.cheng.monitor.tuning.chapter8;

/**
 * @author cheng
 *         2018/12/21 22:19
 */
public class Singleton {

    private Singleton() {
    }

    private static class singletonHolder {
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return singletonHolder.instance;
    }
}
