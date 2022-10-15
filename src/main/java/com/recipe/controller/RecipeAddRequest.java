package com.recipe.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipeAddRequest {
	
	private Long id;
	
	private String menu;
	
	private String category;
	
	private String material;
	
	private String step;
	
	private String point;
	
}
