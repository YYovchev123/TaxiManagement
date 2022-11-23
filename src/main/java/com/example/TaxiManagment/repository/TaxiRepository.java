package com.example.TaxiManagment.repository;

import com.example.TaxiManagment.model.Taxi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxiRepository extends JpaRepository<Taxi, Long> {
}
