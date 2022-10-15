package com.recipe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.recipe.domain.Recipe;
import com.recipe.service.RecipeService;

import java.util.List;
import java.util.ArrayList;

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
	
	@GetMapping("/{id}")
	public ResponseEntity<RecipeResponse> displayEdit(@PathVariable Long id) {
		List<Long> idList = new ArrayList<>();
		idList.add(id);
		List<Recipe> recipes = recipeService.displayEdit(idList);
		RecipeResponse recipeResponse = RecipeResponse.builder()
				.recipes(recipes)
				.build();
		return new ResponseEntity<>(recipeResponse, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<HttpStatus> save(@RequestBody RecipeAddRequest request) {
		recipeService.save(request.getMenu(), request.getCategory(), request.getMaterial(), request.getStep(), request.getPoint());
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<HttpStatus> editSave(@PathVariable Long id, @RequestBody RecipeAddRequest request) {
		request.setId(id);
		recipeService.editSave(request.getId(), request.getMenu(), request.getCategory(), request.getMaterial(), request.getStep(), request.getPoint());
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
		recipeService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
