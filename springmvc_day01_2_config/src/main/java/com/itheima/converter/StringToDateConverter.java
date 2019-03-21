package com.itheima.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 字符串转换日期类型
 *
 * s:source: 源
 * t:target: 目标
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public class StringToDateConverter implements Converter<String,Date>{
    /**
     * 类型的转换
     * @param source  源
     * @return  目标
     */
    @Override
    public Date convert(String source) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //转换为日期
        try {
            Date date = dateFormat.parse(source);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
