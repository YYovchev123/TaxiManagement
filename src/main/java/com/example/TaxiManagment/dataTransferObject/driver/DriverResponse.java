package com.example.TaxiManagment.dataTransferObject.driver;

import com.example.TaxiManagment.dataTransferObject.region.RegionResponse;
import com.example.TaxiManagment.dataTransferObject.taxi.TaxiResponse;
import lombok.*;

@Builder
@Getter
@Setter
public class DriverResponse {

    private String firstName;
    private String lastName;
    private int age;
    private String phone;
    private String email;
    private TaxiResponse taxi;
    private RegionResponse region;
}
