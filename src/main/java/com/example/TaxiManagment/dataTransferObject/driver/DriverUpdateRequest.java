package com.example.TaxiManagment.dataTransferObject.driver;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class DriverUpdateRequest {

    private String firstName;
    private String lastName;
    private int age;
    private String password;
    private String email;
    private String phone;
    private long taxiID;
    private long regionID;
}
