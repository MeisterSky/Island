package com.javarush.island.sheff.entity.organisms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class Limit {
    private double maxWeight;
    private double maxFood;
    private int maxCount;
    private int maxSpeed;
    private Map<String, Integer> ration;

    @Override
    public String toString() {
        return "Limit{" +
                "maxWeight=" + maxWeight +
                ", maxFood=" + maxFood +
                ", maxCount=" + maxCount +
                ", maxSpeed=" + maxSpeed +
                ", ration=" + ration +
                '}';
    }
}
