package com.hermes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 权限管理模块启动类
 *
 * @author fengtingjun
 * @date 2023/7/29 16:39
 */
@SpringBootApplication
public class ServiceAclApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAclApplication.class, args);
    }
}
