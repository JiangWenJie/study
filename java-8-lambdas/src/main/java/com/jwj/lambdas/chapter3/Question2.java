package com.jwj.lambdas.chapter3;

import com.jwj.lambdas.common.Artist;

import java.util.List;

public class Question2 {
    // Q3
    public static int countBandMembersInternal(List<Artist> artists) {
        return (int)artists.stream()
                .flatMap(artist -> artist.getMembers())
                .count();
    }
}
