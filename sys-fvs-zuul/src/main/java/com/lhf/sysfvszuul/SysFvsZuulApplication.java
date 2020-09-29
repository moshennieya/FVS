package com.lhf.sysfvszuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author lhf
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class SysFvsZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SysFvsZuulApplication.class, args);
    }

}
