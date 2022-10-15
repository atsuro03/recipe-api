package com.recipe.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class Recipe {
	
	/** 自動採番ID */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** メニュー名 */
	private String menu;
	
	/** カテゴリー */
	private String category;
	
	/** 材料 */
	private String material;
	
	/** 作り方 */
	private String step;
	
	/** ポイント */
	private String point;
	
	public static Recipe newRecipe(String menu, String category, String material, String step, String point) {
		Recipe recipe = new Recipe();
		recipe.menu = menu;
		recipe.category = category;
		recipe.material = material;
		recipe.step = step;
		recipe.point = point;
		return recipe;
	}
	
	public static Recipe editRecipe(Long id, String menu, String category, String material, String step, String point) {
		Recipe recipe = new Recipe();
		recipe.id = id;
		recipe.menu = menu;
		recipe.category = category;
		recipe.material = material;
		recipe.step = step;
		recipe.point = point;
		return recipe;
	}
}
