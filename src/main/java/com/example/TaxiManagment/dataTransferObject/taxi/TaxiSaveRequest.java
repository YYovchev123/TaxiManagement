package com.example.TaxiManagment.dataTransferObject.taxi;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class TaxiSaveRequest {

    private String brand;
    private String model;
    private int productionYear;
    private int euroStandard;
}
