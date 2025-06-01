package com.graduation_thesis.exercise_service.web;

import com.graduation_thesis.exercise_service.entities.Exercise;
import com.graduation_thesis.exercise_service.services.impl.ExerciseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/exercises")
public class ExerciseController {

    private final ExerciseServiceImpl exerciseService;

    @GetMapping("/name/{name}")
    public List<Exercise> getExerciseByName(@PathVariable String name) {
        return exerciseService.fetchExerciseByName(name);
    }

    @GetMapping("/bodyPart/{bodyPart}")
    public List<Exercise> getExercisesByBodyPart(@PathVariable String bodyPart) {
        return exerciseService.fetchExercisesByBodyPart(bodyPart);
    }

    @GetMapping("/equipment/{equipment}")
    public List<Exercise> getExercisesByEquipment(@PathVariable String equipment) {
        return exerciseService.fetchExercisesByEquipment(equipment);
    }

    @GetMapping("/target/{target}")
    public List<Exercise> getExercisesByTarget(@PathVariable String target) {
        return exerciseService.fetchExercisesByTargetMuscle(target);
    }

    @GetMapping("/bodyPartList")
    public List<String> getBodyPartList() {
        return exerciseService.fetchBodyPartList();
    }

    @GetMapping("/equipmentList")
    public List<String> getEquipmentList() {
        return exerciseService.fetchEquipmentList();
    }

    @GetMapping("/targetList")
    public List<String> getTargetList() {
        return exerciseService.fetchTargetList();
    }
}