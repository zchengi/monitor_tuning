package com.cheng.monitor.tuning.chapter4;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

/**
 * 拦截构造函数
 *
 * @author cheng
 *         2018/12/18 19:13
 */
@BTrace
public class PrintConstructor {

    @OnMethod(clazz = "com.cheng.monitor.tuning.chapter2.User",
            method = "<init>")
    public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, AnyType[] args) {

        BTraceUtils.println(pcn + ", " + pmn);
        BTraceUtils.printArray(args);
        BTraceUtils.println();
    }
}
