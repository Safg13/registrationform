package com.javalearning.registrationform.service;

import com.javalearning.registrationform.model.Order;
import com.javalearning.registrationform.repository.OrderRepository;

public class OrderService extends GenericService<Order> {

    private final OrderRepository repository;

    protected OrderService(OrderRepository repository) {
        super(repository);
        this.repository = repository;
    }



}
