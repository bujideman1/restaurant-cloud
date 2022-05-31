package com.order.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class WaiterMain {
    public static void main(String[] args) {
        SpringApplication.run(WaiterMain.class,args);
    }

}
