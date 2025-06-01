package com.graduation_thesis.exercise_service.services.feign_clients;

import com.graduation_thesis.exercise_service.entities.Exercise;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "exerciseApiClient", url = "https://exercisedb.p.rapidapi.com")
public interface ExerciseApiClient {

    @GetMapping("/exercises/name/{name}")
    ResponseEntity<String> getExerciseByName(@PathVariable("name") String name,
                                             @RequestHeader("X-RapidAPI-Key") String apiKey);

    @GetMapping("/exercises/bodyPart/{bodyPart}")
    ResponseEntity<List<Exercise>> getExercisesByBodyPart(@PathVariable("bodyPart") String bodyPart, @RequestHeader(
            "X-RapidAPI-Key") String apiKey);

    @GetMapping("/exercises/equipment/{type}")
    ResponseEntity<List<Exercise>> getExercisesByEquipment(@PathVariable("type") String bodyPart, @RequestHeader("X" +
            "-RapidAPI-Key") String apiKey);

    @GetMapping("/exercises/target/{target}")
    ResponseEntity<List<Exercise>> getExercisesByTarget(@PathVariable("target") String target, @RequestHeader("X" +
            "-RapidAPI-Key") String apiKey);

    //list used for filters
    @GetMapping("/exercises/bodyPartList")
    ResponseEntity<List<String>> getBodyPartList(@RequestHeader("X-RapidAPI-Key") String apiKey);

    @GetMapping("/exercises/equipmentList")
    ResponseEntity<List<String>> getEquipmentList(@RequestHeader("X-RapidAPI-Key") String apiKey);

    @GetMapping("/exercises/targetList")
    ResponseEntity<List<String>> getTargetList(@RequestHeader("X-RapidAPI-Key") String apiKey);


}