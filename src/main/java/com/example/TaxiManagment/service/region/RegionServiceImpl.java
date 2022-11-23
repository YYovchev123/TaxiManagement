package com.example.TaxiManagment.service.region;

import com.example.TaxiManagment.exception.RecordNotFoundException;
import com.example.TaxiManagment.model.Region;
import com.example.TaxiManagment.repository.RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RegionServiceImpl implements RegionService{

    private final RegionRepository regionRepository;

    @Override
    public Region save(Region region) {
        return regionRepository.save(region);
    }

    @Override
    public List<Region> findAll() {
        return regionRepository.findAll();
    }

    @Override
    public Region findById(long id) {
        return regionRepository.findById(id).orElseThrow(() ->
                new RecordNotFoundException(String.format("Region with ID: %s, not found!", id)));
    }

    @Override
    public Region findByRegion(String region) {
        return regionRepository.findByRegion(region).orElseThrow(() ->
                new RecordNotFoundException(String.format("Region: %s, not found!", region)));
    }

    @Override
    public void deleteById(long id) {
        regionRepository.deleteById(id);
    }
}
