package com.recipe.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipeAddRequest {
	
	private String menu;
	
	private String category;
	
	private String material;
	
	private String step;
	
	private String point;
}
