package com.example.TaxiManagment.controller;

import com.example.TaxiManagment.converter.DriverConverter;
import com.example.TaxiManagment.converter.OrderConverter;
import com.example.TaxiManagment.dataTransferObject.driver.DriverResponse;
import com.example.TaxiManagment.dataTransferObject.driver.DriverSaveRequest;
import com.example.TaxiManagment.dataTransferObject.driver.DriverUpdateRequest;
import com.example.TaxiManagment.dataTransferObject.order.OrderResponse;
import com.example.TaxiManagment.model.Driver;
import com.example.TaxiManagment.model.Order;
import com.example.TaxiManagment.service.driver.DriverService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/driver")
public class DriverController {

    private final DriverService driverService;
    private final DriverConverter driverConverter;
    private final OrderConverter orderConverter;

    @PostMapping(value = "/register")
    public ResponseEntity<DriverResponse> registerDriver(@RequestBody DriverSaveRequest driverSaveRequest) {
        Driver driver = driverConverter.convert(driverSaveRequest);
        Driver savedDriver = driverService.save(driver);
        DriverResponse driverResponse = driverConverter.convert(savedDriver);
        return ResponseEntity.ok().body(driverResponse);
    }

    @GetMapping
    public ResponseEntity<List<DriverResponse>> getAllDrivers() {
        List<Driver> allDrivers = driverService.findAll();
        return ResponseEntity.ok(allDrivers.stream().map(driverConverter::convert).collect(Collectors.toList()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DriverResponse> findDriverByID(@PathVariable long id) {
        Driver driver = driverService.findById(id);
        DriverResponse driverResponse = driverConverter.convert(driver);
        return ResponseEntity.ok().body(driverResponse);
    }

    @GetMapping(value = "/orders/{id}")
    public ResponseEntity<List<OrderResponse>> findAllOrdersForDriverByID(@PathVariable long id) {
        List<Order> allOrdersForDriver = driverService.findAllOrdersForDriver(id);
        return ResponseEntity.ok(allOrdersForDriver.stream().map(orderConverter::convert).collect(Collectors.toList()));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DriverResponse> updateDriver(@RequestBody DriverUpdateRequest driverUpdateRequest, @PathVariable long id) {
        Driver driver = driverConverter.convert(driverUpdateRequest);
        Driver updatedDriver = driverService.update(driver, id);
        DriverResponse driverResponse = driverConverter.convert(updatedDriver);
        return ResponseEntity.ok().body(driverResponse);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> deleteDriverByID(@PathVariable long id) {
        driverService.delete(id);
        return ResponseEntity.ok().build();
    }
}
