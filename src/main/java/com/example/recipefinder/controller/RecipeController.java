package com.example.recipefinder.controller;

import com.example.recipefinder.model.Recipe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class RecipeController {

    @Value("${spoonacular.api.key}")
    private String apiKey;

    @GetMapping("/recipes")
    public Recipe[] getRecipes(@RequestParam String ingredients) {
        String url = String.format(
            "https://api.spoonacular.com/recipes/findByIngredients?ingredients=%s&number=6&apiKey=%s",
            ingredients, apiKey
        );
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, Recipe[].class);
    }

    @GetMapping("/recipes/{id}")
    public ResponseEntity<?> getRecipeDetails(@PathVariable int id) {
    String url = "https://api.spoonacular.com/recipes/" + id + "/information?includeNutrition=false&apiKey=" + apiKey;

    try {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return response;
        } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching recipe details");
        }
}


}


