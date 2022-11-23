package com.example.TaxiManagment.service.order;

import com.example.TaxiManagment.exception.RecordNotFoundException;
import com.example.TaxiManagment.model.Order;
import com.example.TaxiManagment.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(long id) {
        return orderRepository.findById(id).orElseThrow(() ->
                new RecordNotFoundException(String.format("Order with ID: %s, not found!", id)));
    }

    @Override
    @Transactional
    public Order update(Order updatedOrder, long id) {
        Order order = findById(id);
        return update(order, updatedOrder);
    }

    @Override
    public void deleteById(long id) {
        orderRepository.deleteById(id);
    }

    @Transactional
    private Order update(Order order, Order updatedOrder) {
        if (updatedOrder.getStartingAddress() != null) {
            order.setStartingAddress(updatedOrder.getStartingAddress());
        }
        if (updatedOrder.getFinalAddress() != null) {
            order.setFinalAddress(updatedOrder.getFinalAddress());
        }
        if (updatedOrder.getDriver() != null) {
            order.setDriver(updatedOrder.getDriver());
        }
        if (updatedOrder.getRegion() != null) {
            order.setRegion(updatedOrder.getRegion());
        }
        return order;
    }
}
