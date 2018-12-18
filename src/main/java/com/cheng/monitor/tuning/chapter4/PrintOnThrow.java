package com.cheng.monitor.tuning.chapter4;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

/**
 * 拦截异常信息
 *
 * @author cheng
 *         2018/12/18 19:27
 */
@BTrace
public class PrintOnThrow {


    /**
     * store current exception in a thread local variable (@TLS annotation).
     * Note that we can't store it in a global variable!
     */
    @TLS
    private static Throwable currentException;

    /**
     * introduce probe into every constructor if java.lang.Throwable
     * class and store "this" in the thread local variable.
     * <p>
     * new Throwable()
     */
    @OnMethod(clazz = "java.lang.Throwable",
            method = "<init>")
    public static void onThrow(@Self Throwable self) {
        currentException = self;
    }

    /**
     * new Throwable(String msg)
     */
    @OnMethod(clazz = "java.lang.Throwable",
            method = "<init>")
    public static void onThrow1(@Self Throwable self, String s) {
        currentException = self;
    }

    /**
     * new Throwable(String msg, Throwable cause)
     */
    @OnMethod(clazz = "java.lang.Throwable",
            method = "<init>")
    public static void onThrow1(@Self Throwable self, String s, Throwable cause) {
        currentException = self;
    }

    /**
     * new Throwable(Throwable cause)
     */
    @OnMethod(clazz = "java.lang.Throwable",
            method = "<init>")
    public static void onThrow2(@Self Throwable self, Throwable cause) {
        currentException = self;
    }

    /**
     * when any constructor of java.lang.Throwable returns
     * print the currentException's stack trace.
     * <p>
     * 打印异常堆栈信息
     */
    @OnMethod(clazz = "java.lang.Throwable",
            method = "<init>",
            location = @Location(Kind.RETURN))
    public static void onThrowReturn() {
        if (currentException != null) {
            BTraceUtils.jstack(currentException);
            BTraceUtils.println("--------------------");
            currentException = null;
        }
    }
}
