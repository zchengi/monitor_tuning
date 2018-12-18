package com.cheng.monitor.tuning.chapter4;

import com.cheng.monitor.tuning.chapter2.User;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

import java.lang.reflect.Field;

/**
 * 拦截复杂对象(反射)
 *
 * @author cheng
 *         2018/12/18 20:15
 */
@BTrace
public class PrintArgComplex {

    @OnMethod(clazz = "com.cheng.monitor.tuning.chapter4.BtraceController",
            method = "arg2",
            location = @Location(Kind.ENTRY))
    public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, User user) {

        BTraceUtils.println(pcn + ", " + pmn);
        // print all fields
        BTraceUtils.printFields(user);
        // print one field
        Field field = BTraceUtils.field("com.cheng.monitor.tuning.chapter2.User", "name");
        BTraceUtils.println(BTraceUtils.get(field, user));
        BTraceUtils.println();
    }
}
