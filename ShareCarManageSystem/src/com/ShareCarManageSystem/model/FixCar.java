package com.ShareCarManageSystem.model;

/**
 *	修车实体类
 */
public class FixCar {
    private int id;
    private String fixDate;
    private String question;
    private int carId;
    private float price;

    public FixCar() {
    }

    public FixCar(int id, String fixDate, String question, int carId, float price) {
        this.id = id;
        this.fixDate = fixDate;
        this.question = question;
        this.carId = carId;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFixDate() {
        return fixDate;
    }

    public void setFixDate(String fixDate) {
        this.fixDate = fixDate;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
}
