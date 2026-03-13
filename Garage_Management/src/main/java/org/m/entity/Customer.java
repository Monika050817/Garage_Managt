package org.m.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="customers")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    private String name;

    private String phone;

    private String email;

    private String address;
    private Date createdAt;
    private Date updatedAt;

    private String updatedBy;
}