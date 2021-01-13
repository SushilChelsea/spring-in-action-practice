package com.tacos.repo;

import com.tacos.domain.Ingredient;

public interface IngredientRepository {
	Iterable<Ingredient> findAll();
	Ingredient findOne(String id);
	Ingredient save(Ingredient ingredient);
	Ingredient findById(String id);
}
