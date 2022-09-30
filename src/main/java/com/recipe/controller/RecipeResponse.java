package com.recipe.controller;

import lombok.Builder;
import lombok.Getter;
import com.recipe.domain.Recipe;

import java.util.List;

@Getter
@Builder
public class RecipeResponse {
	
	private List<Recipe> recipes;
}
