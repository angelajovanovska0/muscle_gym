package com.graduation_thesis.exercise_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class WorkoutPlan {

    @Id
    @GeneratedValue
    private Long id;

    private String userId;

    private boolean isPublic;

    @ManyToMany
    @JoinTable(
            name = "WorkoutPlanExercises",
            joinColumns = @JoinColumn(name = "workoutPlanId"),
            inverseJoinColumns = @JoinColumn(name = "exerciseId")
    )
    private Set<Exercise> exercises = new HashSet<>();
}
