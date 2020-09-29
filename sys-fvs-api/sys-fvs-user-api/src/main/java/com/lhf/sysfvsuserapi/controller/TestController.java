package com.lhf.sysfvsuserapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/9/12 16:03
 */
@RestController
@RequestMapping("lhf")
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
