package com.example.TaxiManagment.dataTransferObject.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserSaveRequest {

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phone;
}
