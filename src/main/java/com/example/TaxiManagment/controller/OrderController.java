package com.example.TaxiManagment.controller;

import com.example.TaxiManagment.converter.OrderConverter;
import com.example.TaxiManagment.dataTransferObject.order.OrderResponse;
import com.example.TaxiManagment.dataTransferObject.order.OrderSaveRequest;
import com.example.TaxiManagment.dataTransferObject.order.OrderUpdateRequest;
import com.example.TaxiManagment.model.Order;
import com.example.TaxiManagment.service.order.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/order")
public class OrderController {

    private final OrderService orderService;
    private final OrderConverter orderConverter;

    @PostMapping
    public ResponseEntity<OrderResponse> saveOrder(@RequestBody OrderSaveRequest orderSaveRequest) {
        Order order = orderConverter.convert(orderSaveRequest);
        Order savedOrder = orderService.save(order);
        OrderResponse orderResponse = orderConverter.convert(savedOrder);
        return ResponseEntity.ok().body(orderResponse);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> findAllOrders() {
        List<Order> allOrders = orderService.findAll();
        return ResponseEntity.ok(allOrders.stream().map(orderConverter::convert).collect(Collectors.toList()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderResponse> findOrderByID(@PathVariable long id) {
        Order order = orderService.findById(id);
        OrderResponse orderResponse = orderConverter.convert(order);
        return ResponseEntity.ok().body(orderResponse);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<OrderResponse> updateOrderByID(@RequestBody OrderUpdateRequest orderUpdateRequest, @PathVariable long id) {
        Order order = orderConverter.convert(orderUpdateRequest);
        Order updatedOrder = orderService.update(order, id);
        OrderResponse orderResponse = orderConverter.convert(updatedOrder);
        return ResponseEntity.ok().body(orderResponse);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> deleteByID(@PathVariable long id) {
        orderService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
