package com.example.TaxiManagment.model;

import com.example.TaxiManagment.model.status.OrderStatus;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @NotNull
    @Column(name = "starting_address")
    private String startingAddress;

    @NotNull
    @Column(name = "final_address")
    private String finalAddress;

    @NotNull
    @ManyToOne
    private User user;

    @NotNull
    @ManyToOne
    private Driver driver;

    @NotNull
    @ManyToOne
    private Region region;

    @Column(name = "created")
    private Instant created;

    @Column(name = "status")
    private OrderStatus status;

}
