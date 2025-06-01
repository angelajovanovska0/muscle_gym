package com.graduation_thesis.exercise_service.dtos;

import java.util.List;

public record ExerciseDisplayResponseDTO(
        String id,
        String gifUrl,
        String name,
        String target,
        String equipment,
        List<String> secondaryMuscles,
        List<String> instructions,
        String bodyPart
) {
}