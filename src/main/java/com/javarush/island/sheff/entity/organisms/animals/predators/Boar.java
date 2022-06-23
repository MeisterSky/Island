package com.javarush.island.sheff.entity.organisms.animals.predators;

import com.javarush.island.sheff.entity.organisms.Limit;

public class Boar extends Predator{

    public static int counter = 0;

    public Boar(String name, String color, double weight, Limit limit) {
        super(name, color, weight, limit);
    }

    public Boar(Boar prototype) {
        this(prototype.getName(), prototype.getColor(), prototype.getWeight(), prototype.getLimit());
        ++counter;
    }

    @Override
    public Boar copy() {
        return new Boar(this);
    }

    @Override
    public String toString() {
        return "Boar{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", limit=" + limit +
                '}';
    }
}
