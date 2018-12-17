package com.cheng.monitor.tuning.chapter2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 演示内存溢出
 *
 * @author cheng
 *         2018/12/17 18:00
 */
@RestController
public class MemoryController {

    private List<User> userList = new ArrayList<>();
    private List<Class<?>> classList = new ArrayList<>();

    /**
     * 设置运行时最大内存 最小内存
     * -Xms32M -Xmx32M
     */
    @GetMapping("/heap")
    public String heap() {
        int i = 0;
        while (true) {
            userList.add(new User(i++, UUID.randomUUID().toString()));
        }
    }

    /**
     * -XX:MetaspaceSize=32M -XX:MaxMetaspaceSize=32M
     */
    @GetMapping("/nonHeap")
    public String nonHeap() {
        while (true) {
            classList.addAll(Metaspace.createClass());
        }
    }
}
