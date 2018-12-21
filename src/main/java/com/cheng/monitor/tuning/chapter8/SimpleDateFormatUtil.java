package com.cheng.monitor.tuning.chapter8;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author cheng
 *         2018/12/21 22:15
 */
public class SimpleDateFormatUtil {

    private static ThreadLocal<SimpleDateFormat> dateFormatHolder = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public static void main(String[] args) {
        System.out.println(dateFormatHolder.get().format(new Date()));
    }
}
