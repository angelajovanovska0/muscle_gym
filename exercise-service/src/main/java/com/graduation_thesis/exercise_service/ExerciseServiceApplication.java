package com.graduation_thesis.exercise_service;

import com.graduation_thesis.exercise_service.exercises.api.ExercisesAPIConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableConfigurationProperties(ExercisesAPIConfigurationProperties.class)
public class ExerciseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExerciseServiceApplication.class, args);
	}

}
