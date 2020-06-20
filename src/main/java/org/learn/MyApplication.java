package org.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@SpringBootConfiguration
@ServletComponentScan
@EnableCaching
public class MyApplication{
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class);
    }
}
