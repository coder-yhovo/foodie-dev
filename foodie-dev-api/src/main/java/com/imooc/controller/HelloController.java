package com.imooc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
@EnableAutoConfiguration
public class HelloController {

    final static Logger logger= LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public String hello(){
        logger.debug("debug:hello");
        logger.info("info:hello");
        logger.warn("warn:hello");
        logger.error("error:hello");
        return "hello world";
    }
}
