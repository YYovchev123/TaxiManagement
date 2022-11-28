package com.example.TaxiManagment.controller;

import com.example.TaxiManagment.converter.TaxiConverter;
import com.example.TaxiManagment.dataTransferObject.taxi.TaxiResponse;
import com.example.TaxiManagment.dataTransferObject.taxi.TaxiSaveRequest;
import com.example.TaxiManagment.dataTransferObject.taxi.TaxiUpdateRequest;
import com.example.TaxiManagment.model.Taxi;
import com.example.TaxiManagment.service.taxi.TaxiService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/taxi")
public class TaxiController {

    private final TaxiService taxiService;
    private final TaxiConverter taxiConverter;

    @PostMapping
    public ResponseEntity<TaxiResponse> saveTaxi(@RequestBody TaxiSaveRequest taxiSaveRequest) {
        Taxi taxi = taxiConverter.convert(taxiSaveRequest);
        Taxi savedTaxi = taxiService.save(taxi);
        TaxiResponse taxiResponse = taxiConverter.convert(savedTaxi);
        return ResponseEntity.ok().body(taxiResponse);
    }

    @GetMapping
    public ResponseEntity<List<TaxiResponse>> findAllTaxis() {
        List<Taxi> allTaxis = taxiService.findAll();
        return ResponseEntity.ok(allTaxis.stream().map(taxiConverter::convert).collect(Collectors.toList()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TaxiResponse> findTaxiByID(@PathVariable long id) {
        Taxi taxi = taxiService.findById(id);
        TaxiResponse taxiResponse = taxiConverter.convert(taxi);
        return ResponseEntity.ok().body(taxiResponse);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TaxiResponse> updateTaxiByID(@RequestBody TaxiUpdateRequest taxiUpdateRequest, @PathVariable long id) {
        Taxi taxi = taxiConverter.convert(taxiUpdateRequest);
        Taxi updatedTaxi = taxiService.update(taxi, id);
        TaxiResponse taxiResponse = taxiConverter.convert(updatedTaxi);
        return ResponseEntity.ok().body(taxiResponse);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> deleteTaxiByID(@PathVariable long id) {
        taxiService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
