package com.soyeah;

import com.soyeah.service.UserService;
import com.soyeah.service.impl.UserServiceImpl;
import com.soyeah.util.SpringBootBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication

//@ComponentScan(basePackages={"com.soyeah.service"})
public class HandfaceApplication {

//	@Autowired
//	SpringBootBeanUtil springBootBeanUtil;
	public static void main(String[] args) {
		SpringApplication.run(HandfaceApplication.class, args);
//		UserServiceImpl bean = SpringBootBeanUtil.getBean(UserServiceImpl.class);

	}

}
