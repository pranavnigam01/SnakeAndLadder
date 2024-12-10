package com.tutofox.demo;

import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
public class Board {
    private int size;
    private List<Hurdle> hurdles;

    Map<Integer, Hurdle> hurdleMap;

    public Board(int size, List<Hurdle> hurdles) {
        this.size = size;
        this.hurdles = hurdles;
        this.initializeMap();
    }

    private void initializeMap() {
        this.hurdleMap = hurdles.stream().collect(Collectors.toMap(Hurdle::getStartPosition, Function.identity()));
    }

}
