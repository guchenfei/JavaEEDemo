package com.example.util;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateUtil implements Converter<String, Date> {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date convert(String source) {
        Date date = null;
        try {
             date = simpleDateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("日期转化异常");
        }
        return date;
    }
}
