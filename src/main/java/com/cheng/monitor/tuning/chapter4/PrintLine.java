package com.cheng.monitor.tuning.chapter4;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

/**
 * 拦截行号
 *
 * @author cheng
 *         2018/12/18 19:51
 */
@BTrace
public class PrintLine {

    @OnMethod(clazz = "com.cheng.monitor.tuning.chapter4.BtraceController",
            method = "arg1",
//            location = @Location(value = Kind.LINE, line = 42))
//            location = @Location(value = Kind.LINE, line = 44))
            location = @Location(value = Kind.LINE, line = -1))
    public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, int line) {
        BTraceUtils.println(pcn + ", " + pmn);
        BTraceUtils.println(line);
        BTraceUtils.println();
    }
}
