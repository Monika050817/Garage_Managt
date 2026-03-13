package org.m.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="jobs")
@Data
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobId;

    private int customerId;
    private int vehicleId;
    private int mechanicId;

    private String problemDescription;
    private String jobStatus;

    private Date createdDate;
}