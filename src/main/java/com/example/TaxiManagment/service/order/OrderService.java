package com.example.TaxiManagment.service.order;

import com.example.TaxiManagment.model.Order;

import java.util.List;

public interface OrderService {

    Order save(Order order);

    List<Order> findAll();

    Order findById(long id);

    Order update(Order updatedOrder, long id);

    void deleteById(long id);
}
