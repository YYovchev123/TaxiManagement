package com.example.TaxiManagment.dataTransferObject.region;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class RegionSaveRequest {

    private String region;
}
