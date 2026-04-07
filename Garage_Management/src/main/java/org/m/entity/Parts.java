package org.m.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name="parts")
public class Parts
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long partId;

    @Column(name="garage_id")
    private Long garageId;

    private String partName;
    private String partNumber;
    private int quantity;
    private double costPrice;
    private double sellingPrice;

    private Date createdAt;
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name="supplier_id")
    private Supplier supplier;

    public Long getPartId()
    {
        return partId;
    }

    public void setPartId(Long partId)
    {
        this.partId = partId;
    }

    public String getPartName()
    {
        return partName;
    }

    public void setPartName(String partName)
    {
        this.partName = partName;
    }

    public String getPartNumber()
    {
        return partNumber;
    }

    public void setPartNumber(String partNumber)
    {
        this.partNumber = partNumber;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public double getCostPrice()
    {
        return costPrice;
    }

    public void setCostPrice(double costPrice)
    {
        this.costPrice = costPrice;
    }

    public double getSellingPrice()
    {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice)
    {
        this.sellingPrice = sellingPrice;
    }

    public Supplier getSupplier()
    {
        return supplier;
    }

    public void setSupplier(Supplier supplier)
    {
        this.supplier = supplier;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt()
    {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }

    public Long getGarageId()
    {
        return garageId;
    }
    public void setGarageId(Long garageId)
    {
        this.garageId = garageId;
    }

    @PrePersist
    protected void onCreate()
    {
        createdAt = new Date();
        updatedAt = new Date();
    }

    @PreUpdate
    protected void onUpdate()
    {
        updatedAt = new Date();
    }

}