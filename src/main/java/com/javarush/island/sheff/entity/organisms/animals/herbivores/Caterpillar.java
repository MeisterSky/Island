package com.javarush.island.sheff.entity.organisms.animals.herbivores;

import com.javarush.island.sheff.entity.organisms.Limit;

public class Caterpillar extends Herbivore {

    public static int counter = 0;

    public Caterpillar(String name, String color, double weight, Limit limit) {
        super(name, color, weight, limit);
    }

    public Caterpillar(Caterpillar prototype) {
        this(prototype.getName(), prototype.getColor(), prototype.getWeight(), prototype.getLimit());
        ++counter;
    }

    @Override
    public Caterpillar copy() {
        return new Caterpillar(this);
    }

    @Override
    public String toString() {
        return "Caterpillar{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", limit=" + limit +
                '}';
    }
}
