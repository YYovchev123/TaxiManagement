package com.example.TaxiManagment.dataTransferObject.order;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class OrderUpdateRequest {

    private String startingAddress;
    private String finalAddress;
    private long driverID;
    private long regionID;
}
