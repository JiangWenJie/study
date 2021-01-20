package com.jwj.study.data.structure.hash;

import junit.framework.TestCase;
import org.junit.Before;
import org.testng.annotations.Test;

public class MyHashMapTest extends TestCase {
    IMyHashMap hashMap;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        hashMap = new MyHashMap();
        hashMap.put("k1", "v1");
        hashMap.put("k2", "v2");
        hashMap.put("k3", "v3");
        hashMap.put("k4", "v4");
        hashMap.put("k5", "v5");
        hashMap.put("k6", "v6");
        hashMap.put("k7", "v7");
        hashMap.put("k8", "v8");
        hashMap.put("k9", "v9");
        hashMap.put("k10", "v10");
        hashMap.put("k11", "v11");
        hashMap.put("k12", "v12");
    }

    @Test
    public void testPut() {
        hashMap.put("k10","nv10");
        hashMap.put("k1","nv1");
        hashMap.put("k12","nv12");
        System.out.println(hashMap.toString());
    }

    @Test
    public void testGet() {
        for (int i = 3; i < 9; i = i + 2) {
            System.out.println("key is " + i + " value is " + hashMap.get("k" + i));
        }
    }

    @Test
    public void testResize(){
        for (int i = 13; i < 23; i++) {
            hashMap.put("k"+i,"v"+i);
        }
        System.out.println(hashMap.toString());
    }
}