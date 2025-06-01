package com.graduation_thesis.exercise_service.entities;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Exercise {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "target", nullable = false)
    private String target;

    @Column(name = "equipment", nullable = false)
    private String equipment;

    @Column(name = "gif_url", nullable = false)
    private String gifUrl;

    @ElementCollection
    @CollectionTable(name = "exercise_secondary_muscles", joinColumns = @JoinColumn(name = "exercise_id"))
    @Column(name = "muscle")
    private List<String> secondaryMuscles;

    @ElementCollection
    @CollectionTable(name = "exercise_instructions", joinColumns = @JoinColumn(name = "exercise_id"))
    @Column(name = "instruction")
    private List<String> instructions;

    private String  bodyPart;

    @ManyToMany(mappedBy = "exercises")
    private Set<WorkoutPlan> workoutPlans = new HashSet<>();

    public Exercise(String id, String gifUrl, String name, String target, String equipment, List<String> secondaryMuscles, List<String> instructions, String bodyPart) {
        this.id = id;
        this.gifUrl = gifUrl;
        this.name = name;
        this.target = target;
        this.equipment = equipment;
        this.secondaryMuscles = secondaryMuscles;
        this.instructions = instructions;
        this.bodyPart = bodyPart;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "bodyPart='" + bodyPart + '\'' +
                ", equipment='" + equipment + '\'' +
                ", gifUrl='" + gifUrl + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", target='" + target + '\'' +
                ", secondaryMuscles=" + secondaryMuscles +
                ", instructions=" + instructions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Exercise exercise = (Exercise) o;
        return Objects.equals(id, exercise.id) && Objects.equals(name, exercise.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
