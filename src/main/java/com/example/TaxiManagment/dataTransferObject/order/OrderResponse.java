package com.example.TaxiManagment.dataTransferObject.order;

import com.example.TaxiManagment.dataTransferObject.driver.DriverResponse;
import com.example.TaxiManagment.dataTransferObject.user.UserResponse;
import com.example.TaxiManagment.model.status.OrderStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class OrderResponse {

    private String startingAddress;
    private String finalAddress;
    private UserResponse user;
    private DriverResponse driver;
    private OrderStatus status;
}
