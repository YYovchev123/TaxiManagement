package com.example.TaxiManagment.converter;

import com.example.TaxiManagment.dataTransferObject.driver.DriverResponse;
import com.example.TaxiManagment.dataTransferObject.driver.DriverSaveRequest;
import com.example.TaxiManagment.dataTransferObject.driver.DriverUpdateRequest;
import com.example.TaxiManagment.model.Driver;
import com.example.TaxiManagment.model.Region;
import com.example.TaxiManagment.model.Taxi;
import com.example.TaxiManagment.model.status.DriverStatus;
import com.example.TaxiManagment.service.region.RegionService;
import com.example.TaxiManagment.service.taxi.TaxiService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DriverConverter {

    private final TaxiService taxiService;
    private final RegionService regionService;
    private final TaxiConverter taxiConverter;
    private final RegionConverter regionConverter;

    public Driver convert(DriverSaveRequest driverSaveRequest) {
        Taxi taxi = taxiService.findById(driverSaveRequest.getTaxiID());
        Region region = regionService.findById(driverSaveRequest.getRegionID());
        return Driver.builder()
                .firstName(driverSaveRequest.getFirstName())
                .lastName(driverSaveRequest.getLastName())
                .age(driverSaveRequest.getAge())
                .password(driverSaveRequest.getPassword())
                .email(driverSaveRequest.getEmail())
                .phone(driverSaveRequest.getPhone())
                .taxi(taxi)
                .region(region)
                .status(DriverStatus.FREE)
                .build();
    }

    public DriverResponse convert(Driver driver) {
        return DriverResponse.builder()
                .firstName(driver.getFirstName())
                .lastName(driver.getLastName())
                .age(driver.getAge())
                .email(driver.getEmail())
                .phone(driver.getPhone())
                .taxi(taxiConverter.convert(driver.getTaxi()))
                .region(regionConverter.convert(driver.getRegion()))
                .build();
    }

    public Driver convert(DriverUpdateRequest driverUpdateRequest) {
        Taxi taxi = taxiService.findById(driverUpdateRequest.getTaxiID());
        Region region = regionService.findById(driverUpdateRequest.getRegionID());
        return Driver.builder()
                .firstName(driverUpdateRequest.getFirstName())
                .lastName(driverUpdateRequest.getLastName())
                .age(driverUpdateRequest.getAge())
                .password(driverUpdateRequest.getPassword())
                .phone(driverUpdateRequest.getPhone())
                .taxi(taxi)
                .region(region)
                .build();
    }
}
