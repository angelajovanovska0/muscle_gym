package com.graduation_thesis.exercise_service.services;

import com.graduation_thesis.exercise_service.entities.Exercise;

import java.util.List;

public interface ExerciseResponseExtractor {
    List<Exercise> extractJsonResponseToExercise(String jsonResponse);
}
