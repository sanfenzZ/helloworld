package com.example.helloworld;

import org.apache.catalina.authenticator.jaspic.AuthConfigFactoryImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import javax.security.auth.message.config.AuthConfigFactory;



@SpringBootApplication
@EnableAutoConfiguration
//@ImportResource(locations= "classpath:com/example/helloworld/mapper/PersonMapper.xml")
@MapperScan("com.example.helloworld.mapper")
//@ComponentScan("com.example.helloworld.service")//不能映射Controller
//@ComponentScan(basePackages = {"com.example.helloworld.other","com.example.helloworld.mapper","com.example.helloworld.service"})
public class HelloworldApplication {

    public static void main(String[] args) {
        if (AuthConfigFactory.getFactory() == null) {
            AuthConfigFactory.setFactory(new AuthConfigFactoryImpl());
        }
        SpringApplication.run(HelloworldApplication.class, args);
    }
}
