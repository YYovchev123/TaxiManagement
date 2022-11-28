package com.example.TaxiManagment.converter;

import com.example.TaxiManagment.dataTransferObject.order.OrderResponse;
import com.example.TaxiManagment.dataTransferObject.order.OrderSaveRequest;
import com.example.TaxiManagment.dataTransferObject.order.OrderUpdateRequest;
import com.example.TaxiManagment.model.Driver;
import com.example.TaxiManagment.model.Order;
import com.example.TaxiManagment.model.Region;
import com.example.TaxiManagment.model.User;
import com.example.TaxiManagment.model.status.OrderStatus;
import com.example.TaxiManagment.service.driver.DriverService;
import com.example.TaxiManagment.service.region.RegionService;
import com.example.TaxiManagment.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class OrderConverter {

    private final DriverService driverService;
    private final UserService userService;
    private final RegionService regionService;
    private final UserConverter userConverter;
    private final DriverConverter driverConverter;

    public Order convert(OrderSaveRequest orderSaveRequest) {
        User user = userService.findById(orderSaveRequest.getUserID());
        Driver driver = driverService.findById(orderSaveRequest.getDriverID());
        Region region = regionService.findById(orderSaveRequest.getRegionID());
        return Order.builder()
                .startingAddress(orderSaveRequest.getStartingAddress())
                .finalAddress(orderSaveRequest.getFinalAddress())
                .user(user)
                .driver(driver)
                .region(region)
                .status(OrderStatus.IN_PROGRESS)
                .build();
    }

    public OrderResponse convert(Order order) {
        return OrderResponse.builder()
                .startingAddress(order.getStartingAddress())
                .finalAddress(order.getFinalAddress())
                .user(userConverter.convert(order.getUser()))
                .driver(driverConverter.convert(order.getDriver()))
                .status(order.getStatus())
                .build();
    }

    public Order convert(OrderUpdateRequest orderUpdateRequest) {
        Driver driver = driverService.findById(orderUpdateRequest.getDriverID());
        Region region = regionService.findById(orderUpdateRequest.getRegionID());
        return Order.builder()
                .startingAddress(orderUpdateRequest.getStartingAddress())
                .finalAddress(orderUpdateRequest.getFinalAddress())
                .driver(driver)
                .region(region)
                .build();
    }
}
