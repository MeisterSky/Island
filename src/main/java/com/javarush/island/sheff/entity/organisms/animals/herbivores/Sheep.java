package com.javarush.island.sheff.entity.organisms.animals.herbivores;

import com.javarush.island.sheff.entity.organisms.Limit;

public class Sheep extends Herbivore {

    public static int counter = 0;

    public Sheep(String name, String color, double weight, Limit limit) {
        super(name, color, weight, limit);
    }

    public Sheep(Sheep prototype) {
        this(prototype.getName(), prototype.getColor(), prototype.getWeight(), prototype.getLimit());
        ++counter;
    }

    @Override
    public Sheep copy() {
        return new Sheep(this);
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", limit=" + limit +
                '}';
    }
}
