package com.graduation_thesis.exercise_service.services.impl;

import com.graduation_thesis.exercise_service.entities.Exercise;
import com.graduation_thesis.exercise_service.exercises.api.ExercisesAPIConfigurationProperties;
import com.graduation_thesis.exercise_service.services.utils.ApiServiceUtil;
import com.graduation_thesis.exercise_service.services.ExerciseResponseExtractor;
import com.graduation_thesis.exercise_service.services.ExerciseService;
import com.graduation_thesis.exercise_service.services.feign_clients.ExerciseApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseApiClient exerciseApiClient;
    private final ExercisesAPIConfigurationProperties exercisesAPIConfigurationProperties;
    private final ExerciseResponseExtractor exerciseResponseExtractor;

    @Override
    public List<Exercise> fetchExerciseByName(String name) {
        ResponseEntity<String> response;
        try {
            response = exerciseApiClient.getExerciseByName(name, exercisesAPIConfigurationProperties.getApiKey());

            System.out.println(response.getBody());
            return exerciseResponseExtractor.extractJsonResponseToExercise(response.getBody());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error response from API");
        }
    }

    @Override
    public List<Exercise> fetchExercisesByBodyPart(String bodyPart) {
        return ApiServiceUtil.fetchFromApi(() -> exerciseApiClient.getExercisesByBodyPart(bodyPart,
                exercisesAPIConfigurationProperties.getApiKey()));
    }

    @Override
    public List<Exercise> fetchExercisesByEquipment(String equipment) {
        return ApiServiceUtil.fetchFromApi(() -> exerciseApiClient.getExercisesByEquipment(equipment,
                exercisesAPIConfigurationProperties.getApiKey()));
    }

    @Override
    public List<Exercise> fetchExercisesByTargetMuscle(String target) {
        return ApiServiceUtil.fetchFromApi(() -> exerciseApiClient.getExercisesByTarget(target,
                exercisesAPIConfigurationProperties.getApiKey()));
    }

    @Override
    public List<String> fetchBodyPartList() {
        return ApiServiceUtil.fetchFromApi(() -> exerciseApiClient.getBodyPartList(exercisesAPIConfigurationProperties.getApiKey()));
    }

    @Override
    public List<String> fetchTargetList() {
        return ApiServiceUtil.fetchFromApi(() -> exerciseApiClient.getTargetList(exercisesAPIConfigurationProperties.getApiKey()));
    }

    @Override
    public List<String> fetchEquipmentList() {
        return ApiServiceUtil.fetchFromApi(() -> exerciseApiClient.getEquipmentList(exercisesAPIConfigurationProperties.getApiKey()));
    }
}