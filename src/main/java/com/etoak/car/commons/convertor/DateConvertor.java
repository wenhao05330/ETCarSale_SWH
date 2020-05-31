package com.etoak.car.commons.convertor;

import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by 老周 on 2019/11/27.
 */
public class DateConvertor implements Converter<String,Timestamp> {

    @Override
    public Timestamp convert(String o) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return new Timestamp(sdf.parse(o.toString()).getTime());
        }catch(Exception e){
            e.printStackTrace();return null;
        }
    }
}
