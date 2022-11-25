package com.example.TaxiManagment.converter;

import com.example.TaxiManagment.dataTransferObject.taxi.TaxiResponse;
import com.example.TaxiManagment.dataTransferObject.taxi.TaxiSaveRequest;
import com.example.TaxiManagment.dataTransferObject.taxi.TaxiUpdateRequest;
import com.example.TaxiManagment.model.Order;
import com.example.TaxiManagment.model.Taxi;
import lombok.AllArgsConstructor;

import javax.persistence.Converter;

@Converter
@AllArgsConstructor
public class TaxiConverter {

    public Taxi convert(TaxiSaveRequest taxiSaveRequest) {
        return Taxi.builder()
                .brand(taxiSaveRequest.getBrand())
                .model(taxiSaveRequest.getModel())
                .productionYear(taxiSaveRequest.getProductionYear())
                .euroStandard(taxiSaveRequest.getEuroStandard())
                .build();
    }

    public TaxiResponse convert(Taxi taxi) {
        return TaxiResponse.builder()
                .brand(taxi.getBrand())
                .model(taxi.getModel())
                .productionYear(taxi.getProductionYear())
                .euroStandard(taxi.getEuroStandard())
                .build();
    }

    public Taxi convert(TaxiUpdateRequest taxiUpdateRequest) {
        return Taxi.builder()
                .brand(taxiUpdateRequest.getBrand())
                .model(taxiUpdateRequest.getModel())
                .productionYear(taxiUpdateRequest.getProductionYear())
                .euroStandard(taxiUpdateRequest.getEuroStandard())
                .build();
    }
}
