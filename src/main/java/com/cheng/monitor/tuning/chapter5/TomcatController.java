package com.cheng.monitor.tuning.chapter5;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Tomcat 远程调试
 *
 * @author cheng
 *         2018/12/19 17:21
 */
@RestController
@RequestMapping("tomcat")
public class TomcatController {

    @RequestMapping("/hello")
    public String hello() {

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            str.append(i);
        }

        return str.toString();
    }
}
