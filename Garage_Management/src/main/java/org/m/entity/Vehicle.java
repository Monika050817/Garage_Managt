package org.m.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="vehicles")
@Data
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleId;

    private String vehicleNumber;

    private String vehicleModel;

    private String brand;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;
}