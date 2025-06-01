package com.graduation_thesis.exercise_service.services.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.graduation_thesis.exercise_service.entities.Exercise;
import com.graduation_thesis.exercise_service.services.ExerciseResponseExtractor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ExerciseResponseExtractorImpl implements ExerciseResponseExtractor {
    private final ObjectMapper objectMapper;

    public List<Exercise> extractJsonResponseToExercise(String jsonResponse) {
        try {
            JsonNode rootNode = objectMapper.readTree(jsonResponse);
            List<Exercise> exercises = new ArrayList<>();

            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    exercises.add(parseExercise(node));
                }
            } else if (rootNode.isObject()) {
                exercises.add(parseExercise(rootNode));
            } else {
                throw new RuntimeException("Unexpected json format");
            }
            return exercises;
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse JSON response.", e);
        }
    }

    private Exercise parseExercise(JsonNode firstElement) {
        String bodyPart = firstElement.get("bodyPart").asText();
        String equipment = firstElement.get("equipment").asText();
        String name = firstElement.get("name").asText();
        String id = firstElement.get("id").asText();
        String gifUrl = firstElement.get("gifUrl").asText();
        String target = firstElement.get("target").asText();

        List<String> secondaryMuscles = new ArrayList<>();
        firstElement.get("secondaryMuscles").forEach(node -> secondaryMuscles.add(node.asText()));

        List<String> instructions = new ArrayList<>();
        firstElement.get("instructions").forEach(node -> instructions.add(node.asText()));

        return new Exercise(id, gifUrl, name, target, equipment, secondaryMuscles, instructions, bodyPart);
    }
}
