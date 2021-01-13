package com.tacos.repo;

import com.tacos.domain.Order;

public interface OrderRepository {
	Order save(Order order);
}
