package com.example.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by heyao on 2017/3/8.
 */
@RestController
@EnableAutoConfiguration
public class DemonController {

    @RequestMapping(value = "/")
    public String index() {
        return "我走了，很多地方，我来到，伊斯坦堡，就像是，童话故事，有巧糖有城堡";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DemonController.class, args);
    }
}
