package com.example.TaxiManagment.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.Instant;
import java.util.Set;

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

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "password")
    private String password;

    @Column(name = "email", unique = true)
    @Email
    private String email;

    @Column(name = "phone", unique = true)
    private String phone;

    @OneToOne
    private Taxi taxi;

    @OneToMany
    @JoinColumn(name = "region_id")
    private Set<Region> region;

    @Column(name = "created")
    @CreationTimestamp
    private Instant created;

    @Column(name = "is_busy")
    private boolean isBusy;
}
