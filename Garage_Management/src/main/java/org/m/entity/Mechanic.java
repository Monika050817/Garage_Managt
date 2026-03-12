package org.m.entity;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name="mechanics")
@Data
public class Mechanic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mechanicId;

    private String mechanicName;
    private String phone;
    private int experience;
}