package com.tacos.repo.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tacos.domain.Ingredient;
import com.tacos.repo.IngredientRepository;

@Repository
public class IngredientRepositoryImpl implements IngredientRepository {
	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public Iterable<Ingredient> findAll() {
		return jdbc.query("select id, name, type from Ingredient", this::mapRowToIngredient);
	}

	@Override
	public Ingredient findOne(String id) {
		return jdbc.queryForObject("select id, name, type from Ingredient where id=?", this::mapRowToIngredient, id);
	}

	@Override
	public Ingredient findById(String id) {
		return jdbc.queryForObject("select id, name, type from Ingredient where id=?", this::mapRowToIngredient, id);
	}

	@Override
	public Ingredient save(Ingredient ingredient) {
		jdbc.update("insert into Ingredient (id, name, type) values (?, ?, ?)", ingredient.getId(),
				ingredient.getName(), ingredient.getType().toString());
		return ingredient;
	}

	private Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
		return new Ingredient(rs.getString("id"), rs.getString("name"), Ingredient.Type.valueOf(rs.getString("type")));
	}

	public JdbcTemplate getJdbc() {
		return jdbc;
	}

	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

}
