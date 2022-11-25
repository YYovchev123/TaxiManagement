package com.example.TaxiManagment.service.taxi;

import com.example.TaxiManagment.exception.RecordBadRequestException;
import com.example.TaxiManagment.exception.RecordNotFoundException;
import com.example.TaxiManagment.model.Taxi;
import com.example.TaxiManagment.repository.TaxiRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class TaxiServiceImpl implements TaxiService {

    private final TaxiRepository taxiRepository;

    @Override
    public Taxi save(Taxi taxi) {
        return taxiRepository.save(taxi);
    }

    @Override
    public List<Taxi> findAll() {
        return taxiRepository.findAll();
    }

    @Override
//    @Transactional
    public Taxi update(Taxi updatedTaxi, long id) {
        Taxi taxi = findById(id);
        return update(taxi, updatedTaxi);
    }

    @Override
    public Taxi findById(long id) {
        return taxiRepository.findById(id).orElseThrow(() ->
                new RecordNotFoundException(String.format("Taxi with ID: %s, not found!", id)));
    }

    @Override
    public void deleteById(long id) {
        taxiRepository.deleteById(id);
    }

    @Transactional
    private Taxi update(Taxi taxi, Taxi updatedTaxi) {
        if (updatedTaxi.getBrand() != null) {
            taxi.setBrand(updatedTaxi.getBrand());
        }
        if (updatedTaxi.getModel() != null) {
            taxi.setModel(updatedTaxi.getModel());
        }
        if (updatedTaxi.getEuroStandard() < 2) {
            throw new RecordBadRequestException("Euro standard should be more than 2!");
        } else {
            taxi.setEuroStandard(updatedTaxi.getEuroStandard());
        }
        if (updatedTaxi.getProductionYear() < 2007) {
            throw new RecordBadRequestException("The taxi should be produced in 2007 or later");
        } else {
            taxi.setEuroStandard(updatedTaxi.getEuroStandard());
        }
        return taxi;
    }
}
