package com.jwj.lambdas.chapter3;

import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.*;

public class chapter3Test {
    Chapter3 chapter3 =new Chapter3();

    @Test
    public void calArtistCountFrom() {
        long count = chapter3.calArtistCountFrom("UK");
        assertEquals(5,count);
        System.out.println(count);
    }

    @Test
    public void studyYesy(){
        int count = Stream.of(1,2,3)
                .reduce(0,(acc,element)->acc+element);
    }
}