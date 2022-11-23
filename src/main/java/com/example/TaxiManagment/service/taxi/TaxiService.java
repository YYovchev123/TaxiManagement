package com.example.TaxiManagment.service.taxi;

import com.example.TaxiManagment.model.Taxi;

import java.util.List;

public interface TaxiService {

    Taxi save(Taxi taxi);

    List<Taxi> findAll();

    Taxi update(Taxi updatedTaxi, long id);

    Taxi findById(long id);

    void deleteById(long id);
}
