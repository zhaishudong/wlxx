package com.ruoyi.common.utils.text;

import org.apache.commons.lang3.StringUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class StrEmpty {
    public static Boolean isNull(String Str) {
        boolean result = false;
        if (StringUtils.isBlank(Str) || "null".equals(Str)) {
            result = true;
        }
        return result;
    }

    public static Boolean isNotNull(String Str) {
        return !isNull(Str);
    }


    /**
     * 获得当天零时零分零秒
     *
     * @return
     */
    public static Date dateAddOne(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE,1); //把日期往后增加一天,整数  往后推,负数往前移动
        return calendar.getTime();


    }
}
