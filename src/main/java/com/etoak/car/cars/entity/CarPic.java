package com.etoak.car.cars.entity;

/**
 * Created by P870TM1-G on 2019/11/29.
 */
public class CarPic {

    private String id;
    private String savepath;
    private String showname;
    private String carid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSavepath() {
        return savepath;
    }

    public void setSavepath(String savepath) {
        this.savepath = savepath;
    }

    public String getShowname() {
        return showname;
    }

    public void setShowname(String showname) {
        this.showname = showname;
    }

    public String getCarid() {
        return carid;
    }

    public void setCarid(String carid) {
        this.carid = carid;
    }

    @Override
    public String toString() {
        return "CarPic{" +
                "id='" + id + '\'' +
                ", savepath='" + savepath + '\'' +
                ", showname='" + showname + '\'' +
                ", carid='" + carid + '\'' +
                '}';
    }
}
