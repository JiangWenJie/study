package com.jwj.lambdas.chapter3;

import com.jwj.lambdas.common.Artist;
import com.jwj.lambdas.common.MusicChapter;

/**
 * @Author: jwj
 * @Date: 2020/5/21 10:14
 * @Description: 《第 3 章 流》
 */
public class Chapter3 extends MusicChapter {
    /**
     * 使用lambda计算来自某国家的艺术家
     * @param nationality 国籍
     * @return 该国籍的艺术家的数量
     */
    public long calArtistCountFrom(String nationality){
        long count=this.artists.stream()
                .filter(artist -> artist.isFrom(nationality))
                .count();
        return count;
    }

    /**
     * 使用循环计算来自某国家的艺术家
     * @param nationality 国籍
     * @return 该国籍的艺术家的数量
     */
    public long calArtistCountFromNL(String nationality){
        long count=0;
        for (Artist artist:this.artists) {
            if (artist.isFrom(nationality)){
                count++;
            }
        }
        return count;
    }
}
