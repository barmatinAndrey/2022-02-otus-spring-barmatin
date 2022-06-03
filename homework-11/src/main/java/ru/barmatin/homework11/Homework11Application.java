package ru.barmatin.homework11;

import com.github.cloudyrock.spring.v5.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableMongock
@EnableReactiveMongoRepositories
@SpringBootApplication
public class Homework11Application {

	public static void main(String[] args) {
		SpringApplication.run(Homework11Application.class, args);
	}

}
