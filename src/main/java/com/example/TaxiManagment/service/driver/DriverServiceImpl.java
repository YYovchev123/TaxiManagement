package com.example.TaxiManagment.service.driver;

import com.example.TaxiManagment.exception.RecordBadRequestException;
import com.example.TaxiManagment.exception.RecordNotFoundException;
import com.example.TaxiManagment.model.Driver;
import com.example.TaxiManagment.model.Order;
import com.example.TaxiManagment.repository.DriverRepository;
import com.example.TaxiManagment.repository.OrderRepository;
import com.example.TaxiManagment.service.order.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;
    private final OrderRepository orderRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Driver save(Driver driver) {
        try {
            driver.setPassword(bCryptPasswordEncoder.encode(driver.getPassword()));
            return driverRepository.save(driver);
        } catch (DataIntegrityViolationException exception) {
            throw new RecordBadRequestException("Driver with this email or phone is already exist.");
        }
    }

    @Override
    public List<Driver> findAll() {
        return driverRepository.findAll();
    }

    @Override
    public Driver findById(long id) {
        return driverRepository.findById(id).orElseThrow(() ->
                new RecordNotFoundException(String.format("Driver with id: %s, not found!", id)));
    }

    @Override
    public Driver findByEmail(String email) {
        return driverRepository.findByEmail(email).orElseThrow(() ->
                new RecordNotFoundException(String.format("Driver with email: %s, not found!", email)));
    }

    @Override
    public List<Order> findAllOrdersForDriver(long id) {
        Driver driver = findById(id);
        return orderRepository.findByDriver(driver);
    }

    @Override
//    @Transactional
    public Driver update(Driver updatedDriver, long id) {
        Driver driver = findById(id);
        return update(driver, updatedDriver);
    }

    @Override
    public void delete(long id) {
        driverRepository.deleteById(id);
    }

    @Transactional
    private Driver update(Driver driver, Driver updatedDriver) {
        if (updatedDriver.getFirstName() != null) {
            driver.setFirstName(updatedDriver.getFirstName());
        }
        if (updatedDriver.getLastName() != null) {
            driver.setLastName(updatedDriver.getLastName());
        }
        if (updatedDriver.getAge() < 18) {
            throw new RecordBadRequestException("The driver must be 18 years old or older!");
        } else {
            driver.setAge(updatedDriver.getAge());
        }
        if (updatedDriver.getPassword() != null) {
            driver.setPassword(updatedDriver.getPassword());
        }
        if (updatedDriver.getEmail() != null) {
            driver.setEmail(updatedDriver.getEmail());
        }
        if (updatedDriver.getPhone() != null) {
            driver.setPhone(updatedDriver.getPhone());
        }
        if (updatedDriver.getTaxi() != null) {
            driver.setTaxi(updatedDriver.getTaxi());
        }
        if (updatedDriver.getRegion() != null) {
            driver.setRegion(updatedDriver.getRegion());
        }
    return driver;
    }
}

