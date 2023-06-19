package com.example.load.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Load")
public class Load {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="loadId")
    private Long id;

    @Column(name = "loadingPoint")
    private String loadingPoint;

    @Column(name="unloadingPoint")
    private String unloadingPoint;

    @Column(name="productType")
    private String productType;

    @Column(name="truckType")
    private String truckType;

    @Column(name="noOfTrucks")
    private Integer noOfTrucks;

    @Column(name="weight")
    private Integer weight;

    @Column(name="shipperId")
    private String shipperId;

    @Column(name="creationDate")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @PrePersist
    @PostLoad
    private void updateShipperId() {
        if (id != null) {
            shipperId = "shipper:" + id.toString();
        }
    }

    public Load(long id, String loadingPoint, String unloadingPoint, String productType, String truckType, Integer noOfTrucks, Integer weight, String shipperId, Date creationDate) {
        this.id = id;
        this.loadingPoint = loadingPoint;
        this.unloadingPoint = unloadingPoint;
        this.productType = productType;
        this.truckType = truckType;
        this.noOfTrucks = noOfTrucks;
        this.weight = weight;
        this.shipperId = shipperId;
        this.creationDate = creationDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLoadingPoint(String loadingPoint) {
        this.loadingPoint = loadingPoint;
    }

    public String getShipperId() {
        return shipperId;
    }

    public void setUnloadingPoint(String unloadingPoint) {
        this.unloadingPoint = unloadingPoint;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setTruckType(String truckType) {
        this.truckType = truckType;
    }

    public void setNoOfTrucks(Integer noOfTrucks) {
        this.noOfTrucks = noOfTrucks;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public long getId() {
        return id;
    }

    public String getLoadingPoint() {
        return loadingPoint;
    }

    public void setShipperId(String shipperId) {
        this.shipperId = shipperId;
    }

    public String getUnloadingPoint() {
        return unloadingPoint;
    }

    public String getProductType() {
        return productType;
    }

    public String getTruckType() {
        return truckType;
    }

    public Integer getNoOfTrucks() {
        return noOfTrucks;
    }

    public Integer getWeight() {
        return weight;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}
