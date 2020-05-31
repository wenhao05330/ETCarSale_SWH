package com.etoak.car.cars.mapper;

import com.etoak.car.cars.entity.Car;
import com.etoak.car.cars.entity.CarPic;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * Created by P870TM1-G on 2019/11/29.
 */
public interface CarMapper {

    void addCar(Car car);

    void addCarPic(CarPic cp);

    List<Car> querySomeCar(@Param("brand") String brand,@Param("train") String train,@Param("startprice") String startprice,@Param("endprice") String endprice,@Param("starttime") String starttime,@Param("endtime") String endtime,@Param("type") String type,@Param("gearbox") String gearbox,@Param("capacity") String capacity,@Param("location") String location);

    Set<String> queryAllBrand();

    Set<String> queryTrainWithBrand(@Param("brand") String brand);

    Set<String> queryAllLocation();

    Set<String> queryAllTrain();

}
