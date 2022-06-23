package com.javarush.island.sheff.entity.organisms.animals.herbivores;

import com.javarush.island.sheff.entity.organisms.Limit;

public class Mouse extends Herbivore {

    public static int counter = 0;

    public Mouse(String name, String color, double weight, Limit limit) {
        super(name, color, weight, limit);
    }

    public Mouse(Mouse prototype) {
        this(prototype.getName(), prototype.getColor(), prototype.getWeight(), prototype.getLimit());
        ++counter;
    }

    @Override
    public Mouse copy() {
        return new Mouse(this);
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", limit=" + limit +
                '}';
    }
}
