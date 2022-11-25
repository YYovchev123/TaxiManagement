package com.example.TaxiManagment.converter;

import com.example.TaxiManagment.dataTransferObject.user.UserResponse;
import com.example.TaxiManagment.dataTransferObject.user.UserSaveRequest;
import com.example.TaxiManagment.dataTransferObject.user.UserUpdateRequest;
import com.example.TaxiManagment.model.User;
import lombok.AllArgsConstructor;

import javax.persistence.Converter;

@Converter
@AllArgsConstructor
public class UserConverter {

    public User convert(UserSaveRequest userSaveRequest) {
        return User.builder()
                .firstName(userSaveRequest.getFirstName())
                .lastName(userSaveRequest.getLastName())
                .password(userSaveRequest.getPassword())
                .email(userSaveRequest.getEmail())
                .phone(userSaveRequest.getPhone())
                .build();
    }

    public UserResponse convert(User user) {
        return UserResponse.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .build();
    }

    public User convert(UserUpdateRequest userUpdateRequest) {
        return User.builder()
                .firstName(userUpdateRequest.getFirstName())
                .lastName(userUpdateRequest.getLastName())
                .password(userUpdateRequest.getPassword())
                .email(userUpdateRequest.getEmail())
                .phone(userUpdateRequest.getPhone())
                .build();
    }
}
