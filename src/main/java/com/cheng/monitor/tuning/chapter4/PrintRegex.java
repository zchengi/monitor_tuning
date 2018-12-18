package com.cheng.monitor.tuning.chapter4;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

/**
 * 拦截正则表达式
 *
 * @author cheng
 *         2018/12/18 20:15
 */
@BTrace
public class PrintRegex {

    /**
     * .* 拦截所有方法
     */
    @OnMethod(clazz = "com.cheng.monitor.tuning.chapter4.BtraceController",
            method = "/.*/",
            location = @Location(Kind.ENTRY))
    public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn) {

        BTraceUtils.println(pcn + ", " + pmn);
        BTraceUtils.println();
    }
}
