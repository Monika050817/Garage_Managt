package org.m.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="mechanics")
public class Mechanic
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mechanicId;

    @Column(name="garage_id")
    private Long garageId;

    private String mechanicName;

    @Column(length=15)
    private String phone;

    @Column(length = 100)
    private String email;

    @Column(length = 255)
    private String address;

    private String specialization;

    private LocalDate joiningDate;

    @Column(length = 20)
    private String status;

    private Long experience;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Column(name="created_timestamp")
    private LocalDateTime createdTimestamp;

    @Column(name="updated_timestamp")
    private LocalDateTime updatedTimestamp;

    public Long getMechanicId()
    {
        return mechanicId;
    }

    public void setMechanicId(Long mechanicId)
    {
        this.mechanicId = mechanicId;
    }

    public String getMechanicName()
    {
        return mechanicName;
    }

    public void setMechanicName(String mechanicName)
    {
        this.mechanicName = mechanicName;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getSpecialization()
    {
        return specialization;
    }

    public void setSpecialization(String specialization)
    {
        this.specialization = specialization;
    }

    public LocalDate getJoiningDate()
    {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate)
    {
        this.joiningDate = joiningDate;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public Long getExperience()
    {
        return experience;
    }

    public void setExperience(Long experience)
    {
        this.experience = experience;
    }

    public LocalDateTime getCreatedAt()
    {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt()
    {
        return updatedAt;
    }

    public Long getGarageId()
    {
        return garageId;
    }

    public void setGarageId(Long garageId)
    {
        this.garageId=garageId;
    }

    public LocalDateTime getCreatedTimestamp()
    {
        return createdTimestamp;
    }

    public LocalDateTime getUpdatedTimestamp()
    {
        return updatedTimestamp;
    }

    @PrePersist
    protected void onCreate()
    {
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
        this.createdTimestamp = now;
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