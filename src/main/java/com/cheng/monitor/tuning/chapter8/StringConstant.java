package com.cheng.monitor.tuning.chapter8;

/**
 * @author cheng
 *         2018/12/21 22:10
 */
public class StringConstant {

    public static void main(String[] args) {
        String hello = "Hello", lo = "lo";
        System.out.println((hello == "Hello"));
        System.out.println((Other.hello == hello));
        System.out.println((hello == ("Hel" + "lo")));
        System.out.println((hello == ("Hel" + lo)));
        System.out.println(hello == ("Hel" + lo).intern());
    }

    public static class Other {
        public static String hello = "Hello";
    }
}
