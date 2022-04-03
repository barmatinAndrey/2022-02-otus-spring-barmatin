package ru.barmatin.homework03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.barmatin.homework03.service.TestService;

@SpringBootApplication
public class Homework03Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Homework03Application.class, args);
		TestService testService = context.getBean(TestService.class);
		testService.startTest();
	}

}
