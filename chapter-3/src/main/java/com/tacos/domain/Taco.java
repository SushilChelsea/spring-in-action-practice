package com.tacos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Taco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 5, message = "Name must be at least 5 characters long")
	@Column(name = "name")
	private String name;

	@Column(name = "created_at")
	private Date createdAt;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "taco_ingredients",
			joinColumns = @JoinColumn(name="taco_id"),
			inverseJoinColumns = @JoinColumn(name="ingredients_id")
	)
	@Size(min = 1, message = "You must choose at least 1 ingredient")
	private List<Ingredient> ingredients = new ArrayList<>();

	@PrePersist
	void createdAt() {
		this.createdAt = new Date();
	}
}
