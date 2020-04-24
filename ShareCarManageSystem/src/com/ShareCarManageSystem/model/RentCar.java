package com.ShareCarManageSystem.model;

/**
 *	租车实体类
 */
public class RentCar {
    
    private int Id;
    private String RentDate;
    private String Name;
    private int CarId;
    private float price;

    public RentCar() {
    }

    public RentCar(int Id, String RentDate, String Name, int CarId, float price) {
        this.Id = Id;
        this.RentDate = RentDate;
        this.Name = Name;
        this.CarId = CarId;
        this.price = price;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getRentDate() {
        return RentDate;
    }

    public void setRentDate(String RentDate) {
        this.RentDate = RentDate;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getCarId() {
        return CarId;
    }

    public void setCarId(int CarId) {
        this.CarId = CarId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
}

