package com.example.TaxiManagment.controller;

import com.example.TaxiManagment.converter.RegionConverter;
import com.example.TaxiManagment.dataTransferObject.region.RegionResponse;
import com.example.TaxiManagment.dataTransferObject.region.RegionSaveRequest;
import com.example.TaxiManagment.model.Region;
import com.example.TaxiManagment.service.region.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/region")
public class RegionController {

    private final RegionService regionService;
    private final RegionConverter regionConverter;

    @PostMapping
    public ResponseEntity<RegionResponse> saveRegion(@RequestBody RegionSaveRequest regionSaveRequest) {
        Region region = regionConverter.convert(regionSaveRequest);
        Region savedRegion = regionService.save(region);
        RegionResponse regionResponse = regionConverter.convert(savedRegion);
        return ResponseEntity.ok().body(regionResponse);
    }

    @GetMapping
    public ResponseEntity<List<RegionResponse>> findAllRegions() {
        List<Region> allRegions = regionService.findAll();
        return ResponseEntity.ok(allRegions.stream().map(regionConverter::convert).collect(Collectors.toList()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RegionResponse> findRegionByID(@PathVariable long id) {
        Region region = regionService.findById(id);
        RegionResponse regionResponse = regionConverter.convert(region);
        return ResponseEntity.ok().body(regionResponse);
    }

    @GetMapping(value = "/{region}")
    public ResponseEntity<RegionResponse> findByRegion(@PathVariable String region) {
        Region foundRegion = regionService.findByRegion(region);
        RegionResponse regionResponse = regionConverter.convert(foundRegion);
        return ResponseEntity.ok().body(regionResponse);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> deleteByID(@PathVariable long id) {
        regionService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
