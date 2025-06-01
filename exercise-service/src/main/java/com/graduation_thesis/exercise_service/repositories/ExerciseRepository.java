package com.graduation_thesis.exercise_service.repositories;

import com.graduation_thesis.exercise_service.entities.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, String> {
}
