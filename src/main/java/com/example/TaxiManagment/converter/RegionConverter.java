package com.example.TaxiManagment.converter;

import com.example.TaxiManagment.dataTransferObject.region.RegionResponse;
import com.example.TaxiManagment.dataTransferObject.region.RegionSaveRequest;
import com.example.TaxiManagment.model.Region;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class RegionConverter {

    public Region convert(RegionSaveRequest regionSaveRequest) {
        return Region.builder()
                .region(regionSaveRequest.getRegion())
                .build();
    }

    public RegionResponse convert(Region region) {
        return RegionResponse.builder()
                .region(region.getRegion())
                .build();
    }
}
