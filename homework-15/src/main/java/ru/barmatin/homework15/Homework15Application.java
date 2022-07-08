package ru.barmatin.homework15;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.barmatin.homework15.service.PersonService;


@SpringBootApplication
public class Homework15Application {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext ctx = SpringApplication.run(Homework15Application.class, args);

		PersonService personService = ctx.getBean(PersonService.class);
		personService.startPeopleLoop();
	}

}
