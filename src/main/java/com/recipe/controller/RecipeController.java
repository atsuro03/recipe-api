package com.recipe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.recipe.domain.Recipe;
import com.recipe.service.RecipeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecipeController {
	private final RecipeService recipeService;
	
	@GetMapping("/")
	public ResponseEntity<RecipeResponse> findAll() {
		List<Recipe> recipes = recipeService.findAll();
		RecipeResponse recipeResponse = RecipeResponse.builder()
				.recipes(recipes)
				.build();
		return new ResponseEntity<>(recipeResponse, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<HttpStatus> save(@RequestBody RecipeAddRequest request) {
		recipeService.save(request.getMenu(), request.getCategory(), request.getMaterial(), request.getStep(), request.getPoint());
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
		recipeService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
