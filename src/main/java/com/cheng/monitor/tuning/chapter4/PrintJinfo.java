package com.cheng.monitor.tuning.chapter4;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;

/**
 * 拦截 jinfo 命令可以输出的参数
 *
 * @author cheng
 *         2018/12/18 20:32
 */
@BTrace
public class PrintJinfo {

    static {
        BTraceUtils.println("System Properties:");
        BTraceUtils.printProperties();
        BTraceUtils.println("VM Flags:");
        BTraceUtils.printVmArguments();
        BTraceUtils.println("OS Environment:");
        BTraceUtils.printEnv();
        BTraceUtils.exit(0);
    }
}
