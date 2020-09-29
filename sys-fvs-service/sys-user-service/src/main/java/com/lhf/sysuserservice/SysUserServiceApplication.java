package com.lhf.sysuserservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lhf
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.lhf")
@EnableFeignClients
@MapperScan("com.lhf.sysuserservice.dao")
public class SysUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SysUserServiceApplication.class, args);
    }

}
