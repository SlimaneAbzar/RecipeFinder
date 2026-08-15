package com.example.recipefinder.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RecipeController {

    @Value("${spoonacular.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    @SuppressWarnings("unchecked")
    @GetMapping("/recipes")
    public ResponseEntity<?> getRecipes(@RequestParam String ingredients) {
        if (ingredients == null || ingredients.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Ingredients cannot be empty");
        }

        String url = String.format(
            "https://api.spoonacular.com/recipes/complexSearch?query=%s&includeIngredients=%s&number=10&sort=min-missing-ingredients&fillIngredients=true&addRecipeInformation=true&apiKey=%s",
            ingredients.replace(",", " "), ingredients, apiKey
        );

        try {
            Map<String, Object> response = restTemplate.getForObject(url, Map.class);
            List<?> results = (List<?>) response.get("results");
            return ResponseEntity.ok(results);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error fetching recipes");
        }
    }

    @GetMapping("/recipes/{id}")
    public ResponseEntity<?> getRecipeDetails(@PathVariable int id) {
        String url = String.format(
            "https://api.spoonacular.com/recipes/%d/information?includeNutrition=false&apiKey=%s",
            id, apiKey
        );

        try {
            String response = restTemplate.getForObject(url, String.class);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error fetching recipe details");
        }
    }
}
