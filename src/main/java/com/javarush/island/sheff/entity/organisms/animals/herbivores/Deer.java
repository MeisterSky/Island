package com.javarush.island.sheff.entity.organisms.animals.herbivores;

import com.javarush.island.sheff.entity.organisms.Limit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Deer extends Herbivore {

    public static int counter = 0;

    public Deer(String name, String color, double weight, Limit limit) {
        super(name, color, weight, limit);
    }

    public Deer(Deer prototype) {
        this(prototype.getName(), prototype.getColor(), prototype.getWeight(), prototype.getLimit());
        ++counter;
    }

    @Override
    public Deer copy() {
        return new Deer(this);
    }

    @Override
    public String toString() {
        return "Deer{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", limit=" + limit +
                '}';
    }
}
