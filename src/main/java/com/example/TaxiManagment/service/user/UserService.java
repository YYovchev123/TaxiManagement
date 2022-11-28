package com.example.TaxiManagment.service.user;

import com.example.TaxiManagment.model.User;

import java.util.List;

public interface UserService {

    User save(User user);

    List<User> findAll();

    User findById(long id);

    User findByEmail(String email);

    User update(User updatedUser, long Id);

    void deleteByID(long id);
}
