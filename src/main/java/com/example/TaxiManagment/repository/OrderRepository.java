package com.example.TaxiManagment.repository;

import com.example.TaxiManagment.model.Driver;
import com.example.TaxiManagment.model.Order;
import com.example.TaxiManagment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByDriver(Driver driver);

    List<Order> findByUser(User user);
}
