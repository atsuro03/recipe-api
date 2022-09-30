package com.recipe.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.recipe.domain.RecipeRepository;
import com.recipe.domain.Recipe;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {
	
	private final RecipeRepository recipeRepository;
	
	public List<Recipe> findAll() {
		return recipeRepository.findAll();
	}
	
	public Recipe save(String menu, String category, String material, String step, String point) {
		return recipeRepository.save(Recipe.newRecipe(menu, category, material, step, point));
	}
	
	public void delete(Long id) {
		recipeRepository.findById(id).ifPresent(recipe -> recipeRepository.delete(recipe));
	}
}
