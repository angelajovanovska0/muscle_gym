package com.graduation_thesis.exercise_service.services;

import com.graduation_thesis.exercise_service.entities.Exercise;

import java.util.List;

public interface ExerciseService {
    List<Exercise> fetchExerciseByName(String name);

    List<Exercise> fetchExercisesByBodyPart(String bodyPart);

    List<Exercise> fetchExercisesByEquipment(String equipment);

    List<Exercise> fetchExercisesByTargetMuscle(String target);

    List<String> fetchBodyPartList();

    List<String> fetchTargetList();

    List<String> fetchEquipmentList();
}
