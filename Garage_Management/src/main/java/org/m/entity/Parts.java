package org.m.entity;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name="parts")
@Data
public class Parts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int partId;

    private String partName;
    private String partNumber;
    private int quantity;
    private double costPrice;
    private double sellingPrice;

    @ManyToOne
    @JoinColumn(name="supplier_id")
    private Supplier supplier;
}