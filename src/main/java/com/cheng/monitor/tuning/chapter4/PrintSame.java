package com.cheng.monitor.tuning.chapter4;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

/**
 * 拦截同名函数
 *
 * @author cheng
 *         2018/12/18 19:19
 */
@BTrace
public class PrintSame {

    @OnMethod(clazz = "com.cheng.monitor.tuning.chapter4.BtraceController",
            method = "same")
    public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, String name) {
//    public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, String name) {

        BTraceUtils.println(pcn + ", " + pmn);
        BTraceUtils.println("name: " + name);
//        BTraceUtils.println("name: " + name + ", id: " + id);
        BTraceUtils.println();
    }
}
