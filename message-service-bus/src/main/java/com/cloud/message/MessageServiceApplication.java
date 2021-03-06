package com.cloud.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description: 信息服务启动类
 *
 * @author:   ZX
 * @date:     2019/1/16 9:06
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MessageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageServiceApplication.class, args);
    }

}

