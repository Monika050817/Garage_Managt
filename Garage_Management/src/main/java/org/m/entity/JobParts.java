package org.m.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="job_parts")
public class JobParts
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long jobPartsId;

    @Column(name="garage_id")
    private Long garageId;

    @Column(name="job_id")
    private Long jobId;

    @Column(name="part_id")
    private Long partId;

    @Column(name="quantity_used")
    private int quantityUsed;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="created_timestamp")
    private LocalDateTime createdTimestamp;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @Column(name="updated_timestamp")
    private LocalDateTime updatedTimestamp;

    public Long getId()
    {
        return jobPartsId;
    }

    public void setId(Long id)
    {
        this.jobPartsId = id;
    }

    public Long getJobId()
    {
        return jobId;
    }

    public void setJobId(Long jobId)
    {
        this.jobId = jobId;
    }

    public Long getPartId()
    {
        return partId;
    }

    public void setPartId(Long partId)
    {
        this.partId = partId;
    }

    public int getQuantityUsed()
    {
        return quantityUsed;
    }

    public void setQuantityUsed(int quantityUsed)
    {
        this.quantityUsed = quantityUsed;
    }
    public LocalDateTime getCreatedAt()
    {
        return createdAt;
    }

    public LocalDateTime getCreatedTimestamp()
    {
        return createdTimestamp;
    }

    public LocalDateTime getUpdatedAt()
    {
        return updatedAt;
    }

    public LocalDateTime getUpdatedTimestamp()
    {
        return updatedTimestamp;
    }

    public Long getGarageId()
    {
        return garageId;
    }
    public void setGarageId()
    {
         this.garageId=garageId;
    }

    @PrePersist
    protected void onCreate()
    {
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.createdTimestamp = now;
        this.updatedAt = now;
        this.updatedTimestamp = now;
    }

    @PreUpdate
    protected void onUpdate()
    {
        LocalDateTime now = LocalDateTime.now();
        this.updatedAt = now;
        this.updatedTimestamp = now;
    }

}