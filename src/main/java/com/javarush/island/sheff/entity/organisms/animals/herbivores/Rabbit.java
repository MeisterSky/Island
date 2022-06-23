package com.javarush.island.sheff.entity.organisms.animals.herbivores;

import com.javarush.island.sheff.entity.organisms.Limit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rabbit extends Herbivore {

    public static int counter = 0;

    public Rabbit(String name, String color, double weight, Limit limit) {
        super(name, color, weight, limit);
    }

    public Rabbit(Rabbit prototype) {
        this(prototype.getName(), prototype.getColor(), prototype.getWeight(), prototype.getLimit());
        ++counter;
    }

    @Override
    public Rabbit copy() {
        return new Rabbit(this);
    }

    @Override
    public String toString() {
        return "Rabbit{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", limit=" + limit +
                '}';
    }
}
