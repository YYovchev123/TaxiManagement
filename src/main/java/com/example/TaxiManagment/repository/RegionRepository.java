package com.example.TaxiManagment.repository;

import com.example.TaxiManagment.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegionRepository extends JpaRepository<Region, Long> {

    Optional<Region> findByRegion(String region);
}
