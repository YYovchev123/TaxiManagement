package com.example.TaxiManagment.service.driver;

import com.example.TaxiManagment.model.Driver;
import com.example.TaxiManagment.model.Order;

import java.util.List;

public interface DriverService {

    Driver save(Driver driver);

    List<Driver> findAll();

    Driver findById(long id);

    Driver findByEmail(String email);

    List<Order> findAllOrdersForDriver(long id);

    Driver update(Driver updatedDriver, long id);

    void delete(long id);
}
