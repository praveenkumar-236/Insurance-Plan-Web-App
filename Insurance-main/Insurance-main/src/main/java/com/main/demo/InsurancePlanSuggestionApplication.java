
package com.main.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@EnableMongoRepositories("com.main.demo.insurance.repository")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class InsurancePlanSuggestionApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsurancePlanSuggestionApplication.class, args);
	}

}
