package com.javarush.island.sheff.entity.organisms.animals.predators;

import com.javarush.island.sheff.entity.organisms.Limit;

public class Wolf extends Predator{

    public static int counter = 0;

    public Wolf(String name, String color, double weight, Limit limit) {
        super(name, color, weight, limit);
    }

    public Wolf(Wolf prototype) {
        this(prototype.getName(), prototype.getColor(), prototype.getWeight(), prototype.getLimit());
        ++counter;
    }

    @Override
    public Wolf copy() {
        return new Wolf(this);
    }

    @Override
    public String toString() {
        return "Wolf{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", limit=" + limit +
                '}';
    }
}
