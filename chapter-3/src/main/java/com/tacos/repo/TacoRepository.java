package com.tacos.repo;

import org.springframework.data.repository.CrudRepository;

import com.tacos.domain.Taco;

public interface TacoRepository 
extends CrudRepository<Taco, Long> {

}
