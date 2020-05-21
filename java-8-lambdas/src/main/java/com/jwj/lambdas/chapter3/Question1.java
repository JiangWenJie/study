package com.jwj.lambdas.chapter3;

import com.jwj.lambdas.common.Album;
import com.jwj.lambdas.common.Artist;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: jwj
 * @Date: 2020/5/21 11:40
 * @Description: 《第 3 章 流 的课后习题》
 */
public class Question1 {
    /**
     * 计算流中所有数之和
     * @param numbers
     * @return
     */
    public static int addUp(Stream<Integer> numbers){
        return numbers.reduce(0,(x,y)->x+y);
    }

    /**
     * 返回艺术家国籍和姓名的字符串列表
     * @param artists
     * @return
     */
    public static List<String> getNamesAndOrigins(List<Artist> artists){
        return artists.stream()
                .flatMap(artist->Stream.of(artist.getName(),artist.getNationality()))
                .collect(Collectors.toList());
    }

    /**
     * 返回最多包含3首歌曲的专辑组成的列表
     * @param input
     * @return
     */
    public static List<Album> getAlbumsWithAtMostThreeTracks(List<Album> input) {
        return input.stream()
                .filter(album -> album.getTrackList().size()<=3)
                .collect(Collectors.toList());
    }
}
