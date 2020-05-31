package com.etoak.car.cars.controller;

import com.etoak.car.cars.entity.Car;
import com.etoak.car.cars.entity.CarPic;
import com.etoak.car.cars.service.CarService;
import com.etoak.car.commons.page.Page;
import com.github.pagehelper.PageInfo;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by P870TM1-G on 2019/11/29.
 */
@Controller
public class CarController {
    @Autowired
    CarService cs;

    @RequestMapping("addCar.do")
    public String addCar(HttpServletRequest request, Car car, MultipartFile[] pic) throws Exception{
        cs.addCar(car);
        CarPic cp = new CarPic();
        for(MultipartFile f:pic){
            String fExt = FilenameUtils.getExtension(f.getOriginalFilename());
            String newName = UUID.randomUUID().toString().replaceAll("-","")+"."+fExt;
            String path = request.getServletContext().getRealPath("/files/"+newName);
            f.transferTo(new File(path));
            cp.setCarid(car.getId());
            cp.setSavepath("/files/"+newName);
            cp.setShowname(f.getOriginalFilename());
        }
        cs.addCarPic(cp);
        return "addcar";
    }

    @RequestMapping("querySomeCar.do")
    @ResponseBody
    public Page<Car> querySomeCar(Integer pageNumber,Integer pageSize,String brand,String train,String price,String age,String type,String gearbox,String capacity,String location) throws Exception{
        System.out.println(brand+","+train+","+price+","+age+","+type+","+gearbox+","+capacity+","+location);
        SimpleDateFormat p = new SimpleDateFormat("yyyy-MM");
        Long curtime = new Date().getTime();
        Long oneyeartime = 12*30*24*60*60*1000L;
        String startprice = "";
        String endprice = "";
        String starttime = "";
        String endtime = "";
        switch (price){
            case "3万以下":endprice="3";break;
            case "3~5":startprice="3";endprice="5";break;
            case "5-8":startprice="5";endprice="8";break;
            case "8-10":startprice="8";endprice="10";break;
            case "10-15":startprice="10";endprice="15";break;
            case "15-20":startprice="15";endprice="20";break;
            case "20-30":startprice="20";endprice="30";break;
            case "30-50":startprice="30";endprice="50";break;
            case "50万以上":startprice="50";break;
            default:break;
        }
        switch (age){
            case "1年以内":endtime=p.format(curtime-oneyeartime);break;
            case "1-3":starttime=p.format(curtime-oneyeartime);endtime=p.format(curtime-(oneyeartime*3));break;
            case "3-5":starttime=p.format(curtime-(oneyeartime*3));endtime=p.format(curtime-(oneyeartime*5));break;
            case "5-8":starttime=p.format(curtime-(oneyeartime*5));endtime=p.format(curtime-(oneyeartime*8));break;
            case "8-10":starttime=p.format(curtime-(oneyeartime*8));endtime=p.format(curtime-(oneyeartime*10));break;
            case "10年以上":starttime=p.format(curtime-(oneyeartime*10));break;
            default:break;
        }
        Page<Car> page = new Page<>();
        page.setPageNumber(pageNumber);
        page.setPageSize(pageSize);
        List<Car> cars = cs.querySomeCar(pageNumber,pageSize,brand,train,startprice,endprice,starttime,endtime,type,gearbox,capacity,location);
        PageInfo info = new PageInfo(cars);
        page.setTotal(((Long)info.getTotal()).intValue());
        page.setRows(info.getList());
        return page;
    }

    @RequestMapping("queryAllBrand.do")
    @ResponseBody
    public Set<String> queryAllBrand(){
        Set<String> brands = cs.queryAllBrand();
        return brands;
    }

    @RequestMapping("queryTrainWithBrand.do")
    @ResponseBody
    public Set<String> queryTrainWithBrand(String brand){
        Set<String> trains = cs.queryTrainWithBrand(brand);
        return trains;
    }

    @RequestMapping("queryAllLocation.do")
    @ResponseBody
    public Set<String> queryAllLocation(){
        Set<String> locations = cs.queryAllLocation();
        return locations;
    }

    @RequestMapping("queryAllTrain.do")
    @ResponseBody
    public Set<String> queryAllTrain(String brand){
        Set<String> trains = cs.queryAllTrain(brand);
        return trains;
    }
}
