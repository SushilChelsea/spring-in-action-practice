package com.tacos.repo;


import org.springframework.data.repository.CrudRepository;

import com.tacos.domain.Order;

public interface OrderRepository 
extends CrudRepository<Order, Long> {

}
