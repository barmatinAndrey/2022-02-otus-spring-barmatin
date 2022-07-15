package ru.barmatin.homework17;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Homework17Application {

	public static void main(String[] args) {
		SpringApplication.run(Homework17Application.class, args);
	}
//	docker run --detach --env="POSTGRES_PASSWORD=password" --publish 6603:3306 postgres

}
