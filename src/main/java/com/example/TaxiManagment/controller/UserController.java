package com.example.TaxiManagment.controller;

import com.example.TaxiManagment.converter.UserConverter;
import com.example.TaxiManagment.dataTransferObject.user.UserResponse;
import com.example.TaxiManagment.dataTransferObject.user.UserSaveRequest;
import com.example.TaxiManagment.dataTransferObject.user.UserUpdateRequest;
import com.example.TaxiManagment.model.User;
import com.example.TaxiManagment.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;
    private final UserConverter userConverter;

    @PostMapping
    public ResponseEntity<UserResponse> saveUser(@RequestBody UserSaveRequest userSaveRequest) {
        User user = userConverter.convert(userSaveRequest);
        User savedUser = userService.save(user);
        UserResponse userResponse = userConverter.convert(savedUser);
        return ResponseEntity.ok().body(userResponse);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAllUsers() {
        List<User> allUsers = userService.findAll();
        return ResponseEntity.ok(allUsers.stream().map(userConverter::convert).collect(Collectors.toList()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponse> findUserByID(@PathVariable long id) {
        User user = userService.findById(id);
        UserResponse userResponse = userConverter.convert(user);
        return ResponseEntity.ok().body(userResponse);
    }

    @GetMapping(value = "/{email}")
    public ResponseEntity<UserResponse> findUserByEmail(@PathVariable String email) {
        User user = userService.findByEmail(email);
        UserResponse userResponse = userConverter.convert(user);
        return ResponseEntity.ok().body(userResponse);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserResponse> updateUserByID(@RequestBody UserUpdateRequest userUpdateRequest, @PathVariable long id) {
        User user = userConverter.convert(userUpdateRequest);
        User updatedUser = userService.update(user, id);
        UserResponse userResponse = userConverter.convert(updatedUser);
        return ResponseEntity.ok().body(userResponse);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> deleteUserByID(@PathVariable long id) {
        userService.deleteByID(id);
        return ResponseEntity.ok().build();
    }
}
