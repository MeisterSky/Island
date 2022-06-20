package com.javarush.island.sheff.entity.organisms.animals.predators;

import com.javarush.island.sheff.entity.organisms.Limit;

public class Fox extends Predator{
    public Fox(String name, String color, double weight, Limit limit) {
        super(name, color, weight, limit);
    }

    @Override
    public String toString() {
        return "Fox{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", limit=" + limit +
                '}';
    }
}
