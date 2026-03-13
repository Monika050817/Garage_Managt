package org.m.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

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

    private Date lastServiceDate;


    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;
}