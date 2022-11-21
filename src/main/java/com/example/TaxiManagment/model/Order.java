package com.example.TaxiManagment.model;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    @Column(name = "starting_address")
    private String startingAddress;

    @Column(name = "final_address")
    private String finalAddress;

    @ManyToOne
    private User user;

    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Region region;

    @Column(name = "created")
    private Instant created;

    @Column(name = "is_finished")
    private boolean isFinished;

}
