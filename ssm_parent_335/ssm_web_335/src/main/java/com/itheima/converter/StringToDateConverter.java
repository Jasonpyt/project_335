package com.itheima.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * 把页面提交的字符串转换为Date类型
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public class StringToDateConverter implements Converter<String ,Date> {
    @Override
    public Date convert(String source) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        //把字符串解析为日期
        try {
            Date date = sdf.parse(source);
            return  date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
