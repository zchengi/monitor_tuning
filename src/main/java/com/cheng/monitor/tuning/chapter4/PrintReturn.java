package com.cheng.monitor.tuning.chapter4;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

/**
 * 返回的时候拦截
 *
 * @author cheng
 *         2018/12/18 19:27
 */
@BTrace
public class PrintReturn {

    @OnMethod(clazz = "com.cheng.monitor.tuning.chapter4.BtraceController",
            method = "arg1",
            location = @Location(Kind.RETURN))
    public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, @Return AnyType result) {
        BTraceUtils.println(pcn + ", " + pmn);
        BTraceUtils.println(result);
        BTraceUtils.println();
    }
}
