package com.javarush.island.sheff.entity.organisms.animals.predators;

import com.javarush.island.sheff.entity.organisms.Limit;

public class Boa extends Predator{
    public Boa(String name, String color, double weight, Limit limit) {
        super(name, color, weight, limit);
    }

    @Override
    public String toString() {
        return "Boa{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", limit=" + limit +
                '}';
    }
}
