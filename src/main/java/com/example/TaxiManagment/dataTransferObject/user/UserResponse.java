package com.example.TaxiManagment.dataTransferObject.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserResponse {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
