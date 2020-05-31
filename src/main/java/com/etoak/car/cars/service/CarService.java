package com.etoak.car.cars.service;

import com.etoak.car.cars.entity.Car;
import com.etoak.car.cars.entity.CarPic;
import com.etoak.car.cars.mapper.CarMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by P870TM1-G on 2019/11/29.
 */
@Service
public class CarService {
    @Autowired
    CarMapper dao;

    public void addCar(Car car) {
        dao.addCar(car);
    }

    public void addCarPic(CarPic cp) {
        dao.addCarPic(cp);
    }

    public List<Car> querySomeCar(Integer pageNumber,Integer pageSize,String brand,String train,String startprice,String endprice,String starttime,String endtime,String type,String gearbox,String capacity,String location) {
        PageHelper.startPage(pageNumber,pageSize);
        List<Car> cars = dao.querySomeCar(brand,train,startprice,endprice,starttime,endtime,type,gearbox,capacity,location);
        return cars;
    }

    public Set<String> queryAllBrand() {
        Set<String> brand = dao.queryAllBrand();
        return brand;
    }

    public Set<String> queryTrainWithBrand(String brand) {
        Set<String> trains = dao.queryTrainWithBrand(brand);
        return trains;
    }

    public Set<String> queryAllLocation() {
        Set<String> locations = dao.queryAllLocation();
        return locations;
    }

    public Set<String> queryAllTrain(String brand) {
        Set<String> trains = dao.queryAllTrain();
        return trains;
    }
}
