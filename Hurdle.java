package com.tutofox.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Hurdle {

    private HurdleType hurdleType;
    private int startPosition;
    private int endPosition;

}
