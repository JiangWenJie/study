package com.jwj.study.data.structure.hash;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * @author jwj
 * @date 2021/1/6 20:55
 * @description hashMap实现
 * @since 1.0
 */
public class MyHashMap implements IMyHashMap {


    @Override
    public void put(String key, String value) {

    }

    @Override
    public int get(String key) {
        return 0;
    }

    class Entry{
        String key;
        String value;
        Entry next;

    }

    public static void main(String[] args) {
        DateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dates="2020-11-03";
        Date date=parseDate(dates,"yyyy-MM-dd");
        Date newDate=new Date(date.getTime()+696842000/2);
        System.out.println(ft.format(newDate));
    }

    public static Date parseDate(String val, String formats) {
        String[] fs = formats.split(",");
        for (String f : fs) {
            DateFormat ft = new SimpleDateFormat(f);
            try {
                return ft.parse(val);
            } catch (Exception e) {
            }
        }
        return null;
    }
}
