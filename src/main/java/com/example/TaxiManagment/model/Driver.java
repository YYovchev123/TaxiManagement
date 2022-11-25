package com.example.TaxiManagment.model;

import com.example.TaxiManagment.model.status.DriverStatus;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "drivers")
public class Driver{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "age")
    private int age;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "email", unique = true)
    @Email
    private String email;

    @NotNull
    @Column(name = "phone", unique = true)
    private String phone;

    @NotNull
    @OneToOne
    private Taxi taxi;

    @OneToOne
    private Region region;

    @Column(name = "created")
    @CreationTimestamp
    private Instant created;

    @Column(name = "status")
    private DriverStatus status;
}
