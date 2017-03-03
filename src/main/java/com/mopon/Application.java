package com.mopon;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {
	
	@RequestMapping("/")
    public String greeting() {
		System.out.println("----------------------------------------------");
		System.out.println("当前时间：" + new Date());
        return "Hello World!";
    }

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
