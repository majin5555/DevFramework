package com.devframework.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * @author: Lemon-XQ
 * @date: 2017/11/12
 * @description: 功能类，封装一些功能函数
 */

public class Util {

    /**
     * @description 字符串处理，防止SQL注入
     * @param input
     * @return
     */
    public static String StringHandle(String input){
        String output;
        // 将包含有 单引号(')，分号(;) 和 注释符号(--)的语句替换掉
        output = input.trim().replaceAll(".*([';]+|(--)+).*", " ");
        return output;
    }

    /**
     * 根据生日推算年龄
     * @param birthDay
     * @return
     */
    public static int getAgeFromDate(Date birthDay){
        int age;
        try {
            Calendar now = Calendar.getInstance();
            now.setTime(new Date());// 当前时间

            Calendar birth = Calendar.getInstance();
            birth.setTime(birthDay);

            if (birth.after(now)) {//如果传入的时间，在当前时间的后面，返回0岁
                age = 0;
            } else {
                age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
                if (now.get(Calendar.DAY_OF_YEAR) > birth.get(Calendar.DAY_OF_YEAR)) {
                    age += 1;
                }
            }
            return age;
        } catch (Exception e) {//兼容性更强,异常后返回数据
            return 0;
        }
    }

    /**
     * 根据怀孕日期推算怀孕天数、周数、月数
     * @param pregnantDate
     * @return
     */
    public static long getPregnantDays(Date pregnantDate){
        Date currentDate = new Date();
        return (currentDate.getTime()-pregnantDate.getTime())/(24*60*60*1000);
    }

    public static long getPregnantWeeks(Date pregnantDate){
        return getPregnantDays(pregnantDate)/7;
    }

    public static long getPregnantMonths(Date pregnantDate){
        return getPregnantDays(pregnantDate)/30;
    }

}
