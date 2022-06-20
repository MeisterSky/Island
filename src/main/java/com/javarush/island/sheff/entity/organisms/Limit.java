package com.javarush.island.sheff.entity.organisms;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Limit {
    private double maxWeight;
    private double maxFood;
    private int maxCount;
    private int maxSpeed;

    @Override
    public String toString() {
        return "Limit{" +
                "maxWeight=" + maxWeight +
                ", maxCount=" + maxCount +
                ", maxSpeed=" + maxSpeed +
                ", maxFood=" + maxFood +
                '}';
    }
}
