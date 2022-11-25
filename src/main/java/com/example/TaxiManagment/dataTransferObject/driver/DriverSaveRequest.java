package com.example.TaxiManagment.dataTransferObject.driver;

import com.example.TaxiManagment.dataTransferObject.region.RegionSaveRequest;
import com.example.TaxiManagment.dataTransferObject.taxi.TaxiSaveRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
public class DriverSaveRequest {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private int age;
    @NotNull
    private String phone;
    @NotNull
    private String email;
    @NotNull
    private String password;
    private long taxiID;
    private long regionID;
}
