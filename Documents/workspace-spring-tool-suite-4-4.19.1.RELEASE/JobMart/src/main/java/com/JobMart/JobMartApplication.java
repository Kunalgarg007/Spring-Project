package com.JobMart;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@EntityScan(basePackages = "com.JobMart.*")

@SpringBootApplication
@EnableJpaRepositories
public class JobMartApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobMartApplication.class, args);
	}

}
