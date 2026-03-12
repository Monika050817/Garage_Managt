package org.m.entity;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name="suppliers")
@Data
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supplierId;

    private String supplierName;
    private String phone;
    private String email;
    private String address;
}