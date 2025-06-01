package com.graduation_thesis.exercise_service.services.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.function.Supplier;

public class ApiServiceUtil {
    public static <T> T fetchFromApi(Supplier<ResponseEntity<T>> apiCall) {
        try {
            ResponseEntity<T> response = apiCall.get();

            if (response.getStatusCode() != HttpStatus.OK) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error response from API");
            }

            return response.getBody();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error", e);
        }
    }
}
