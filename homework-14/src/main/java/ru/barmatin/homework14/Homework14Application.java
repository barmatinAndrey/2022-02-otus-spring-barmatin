package ru.barmatin.homework14;

import com.github.cloudyrock.spring.v5.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongock
@EnableMongoRepositories
@SpringBootApplication
public class Homework14Application {

	public static void main(String[] args) {
		SpringApplication.run(Homework14Application.class, args);
	}

}
