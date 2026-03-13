package org.m.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="job_parts")
@Data
public class JobParts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int jobId;
    private int partId;

    private int quantityUsed;
}