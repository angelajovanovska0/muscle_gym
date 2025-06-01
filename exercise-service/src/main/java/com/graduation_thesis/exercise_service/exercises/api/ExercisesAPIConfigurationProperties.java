package com.graduation_thesis.exercise_service.exercises.api;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="rapid.api")
@Getter
@Setter
public class ExercisesAPIConfigurationProperties {
    private String apiKey;
    private String host;

}
