package com.jwj.study.data.structure.hash;

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
}
