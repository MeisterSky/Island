package com.javarush.island.sheff.entity.organisms.animals.herbivores;

import com.javarush.island.sheff.entity.organisms.Limit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Goat extends Herbivore {

    public static int counter = 0;

    public Goat(String name, String color, double weight, Limit limit) {
        super(name, color, weight, limit);
    }

    public Goat(Goat prototype) {
        this(prototype.getName(), prototype.getColor(), prototype.getWeight(), prototype.getLimit());
        ++counter;
    }

    @Override
    public Goat copy() {
        return new Goat(this);
    }

    @Override
    public String toString() {
        return "Goat{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", limit=" + limit +
                '}';
    }
}
