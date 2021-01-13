package com.tacos.repo;

import org.springframework.data.repository.CrudRepository;

import com.tacos.domain.Ingredient;

public interface IngredientRepository 
extends CrudRepository<Ingredient, String> {

}
