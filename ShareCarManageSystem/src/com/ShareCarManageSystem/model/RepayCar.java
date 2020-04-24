package com.ShareCarManageSystem.model;

/**
 *	还车实体类
 */
public class RepayCar {
    private int id;
    private String repayDate;
    private String name;
    private int carId;
    private String status;

    public RepayCar() {
    }

    public RepayCar(int id, String repayDate, String name, int carId, String status) {
        this.id = id;
        this.repayDate = repayDate;
        this.name = name;
        this.carId = carId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(String repayDate) {
        this.repayDate = repayDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}

