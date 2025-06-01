package com.graduation_thesis.exercise_service.converters;

import com.graduation_thesis.exercise_service.dtos.ExerciseDisplayResponseDTO;
import com.graduation_thesis.exercise_service.entities.Exercise;
import org.springframework.stereotype.Component;

@Component
public class ExerciseConverter {
    public ExerciseDisplayResponseDTO toExerciseDisplayResponseDTO(Exercise exercise) {
        return new ExerciseDisplayResponseDTO(
                exercise.getId(),
                exercise.getGifUrl(),
                exercise.getName(),
                exercise.getTarget(),
                exercise.getEquipment(),
                exercise.getSecondaryMuscles(),
                exercise.getInstructions(),
                exercise.getBodyPart()
        );
    }

    public Exercise toExercise(ExerciseDisplayResponseDTO exerciseDisplayResponseDTO) {
        return new Exercise(exerciseDisplayResponseDTO.id(), exerciseDisplayResponseDTO.gifUrl(),
                exerciseDisplayResponseDTO.name(), exerciseDisplayResponseDTO.target(),
                exerciseDisplayResponseDTO.equipment(), exerciseDisplayResponseDTO.secondaryMuscles(),
                exerciseDisplayResponseDTO.instructions(), exerciseDisplayResponseDTO.bodyPart());
    }
}
