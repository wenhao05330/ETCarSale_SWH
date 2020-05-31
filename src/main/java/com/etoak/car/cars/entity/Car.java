package com.etoak.car.cars.entity;

/**
 * Created by P870TM1-G on 2019/11/29.
 */
public class Car {
    private String id;
    private String brand;//品牌
    private String train;//车系
    private Double price;
    private String uploadtime;
    private String type;//级别
    private String gearbox;//变速箱
    private String capacity;//排量
    private String course;//里程
    private String location;//归属地
    private String info;//概述
    private CarPic carPic;

    public CarPic getCarPic() {
        return carPic;
    }

    public void setCarPic(CarPic carPic) {
        this.carPic = carPic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTrain() {
        return train;
    }

    public void setTrain(String train) {
        this.train = train;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(String uploadtime) {
        this.uploadtime = uploadtime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", train='" + train + '\'' +
                ", price=" + price +
                ", uploadtime='" + uploadtime + '\'' +
                ", type='" + type + '\'' +
                ", gearbox='" + gearbox + '\'' +
                ", capacity='" + capacity + '\'' +
                ", course='" + course + '\'' +
                ", location='" + location + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
