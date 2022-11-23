package com.example.TaxiManagment.service.region;

import com.example.TaxiManagment.model.Region;

import java.util.List;

public interface RegionService {

    Region save(Region region);

    List<Region> findAll();

    Region findById(long id);

    Region findByRegion(String region);

    void deleteById(long id);
}
