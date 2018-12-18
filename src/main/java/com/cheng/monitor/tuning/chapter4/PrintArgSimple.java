package com.cheng.monitor.tuning.chapter4;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

/**
 * Btrace 脚本
 *
 * @author cheng
 *         2018/12/18 17:00
 */
@BTrace
public class PrintArgSimple {

    @OnMethod(clazz = "com.cheng.monitor.tuning.chapter4.BtraceController",
            method = "arg1",
            location = @Location(Kind.ENTRY))
    public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, AnyType[] args) {
        BTraceUtils.printArray(args);
        BTraceUtils.println(pcn + ", " + pmn);
        BTraceUtils.println();
    }
}
